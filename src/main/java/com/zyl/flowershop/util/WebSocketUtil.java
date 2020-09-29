package com.zyl.flowershop.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zyl.flowershop.dao.IAdminDao;
import com.zyl.flowershop.dao.IUserDao;
import com.zyl.flowershop.entity.Admin;
import com.zyl.flowershop.entity.ChatData;
import com.zyl.flowershop.entity.ChatMessage;
import com.zyl.flowershop.entity.MChatSession;
import com.zyl.flowershop.entity.User;

@ServerEndpoint("/chat/websocket/{chatIsUser}/{chatId}")
@Component
public class WebSocketUtil {
	public static Map<Integer, MChatSession> aSessionMap = new ConcurrentHashMap<Integer, MChatSession>();
	public static Map<Integer, MChatSession> uSessionMap = new ConcurrentHashMap<Integer, MChatSession>();
	public static Map<Integer, List<Integer>> sessionAdminMap = new ConcurrentHashMap<Integer, List<Integer>>();
	public static Map<Integer, Integer> sessionUserMap = new ConcurrentHashMap<Integer, Integer>();
	/**
	 * 解决@Autowired注值失败
	 */
	private IUserDao userDao = SpringUtil.getBean(IUserDao.class);
	private IAdminDao adminDao = SpringUtil.getBean(IAdminDao.class);

	@OnOpen
	public void onOpen(@PathParam("chatIsUser") Integer chatIsUser, @PathParam("chatId") Integer chatId,
			Session session) {
		System.out.println("WebSocketService onOpen: " + chatId);
		System.out.println(userDao);
		if (chatIsUser == 1) {
			User user = userDao.findById(chatId);
			if (user.equals(null))
				return;
			if (!aSessionMap.isEmpty()) {
				Integer[] keys = aSessionMap.keySet().toArray(new Integer[0]);
				Random random = new Random();
				Integer randomKey = keys[random.nextInt(keys.length)];
				System.out.println(randomKey + ":" + sessionAdminMap.get(randomKey) + ":" + sessionAdminMap.size());
				List<Integer> list = null;
				if ((list = sessionAdminMap.get(randomKey)) == null)
					list = new ArrayList<Integer>();
				list.add(chatId);
				sessionAdminMap.put(randomKey, list);
				sessionUserMap.put(chatId, randomKey);
				System.out.println("-------------" + session);
				Admin admin = adminDao.findById(randomKey);
				uSessionMap.put(chatId, new MChatSession(session, admin, user));
				MChatSession session_ = aSessionMap.get(randomKey);
				session_.setUser(user);
				aSessionMap.put(randomKey, session_);
			}
		} else {
			System.out.println(adminDao);
			Admin admin = adminDao.findById(chatId);
			aSessionMap.put(chatId, new MChatSession(session, admin, null));
		}
	}

	@OnClose
	public void OnClose(@PathParam("chatIsUser") Integer chatIsUser, @PathParam("chatId") Integer chatId) {
		System.out.println("WebSocketService OnClose: " + chatId);
		if (chatIsUser == 1) {
			sessionAdminMap.get(sessionUserMap.get(chatId)).remove(chatId);
			uSessionMap.remove(chatId);
			sessionUserMap.remove(chatId);
		} else {
			sessionAdminMap.remove(chatId);
			aSessionMap.remove(chatId);
		}
	}

	@OnMessage
	public void OnMessage(@PathParam("chatIsUser") Integer chatIsUser, @PathParam("chatId") Integer chatId,
			Session session, String message) {
		System.out.println("WebSocketService OnMessage: " + message);

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd hh:mm:ss");
		String nowDate = sdf.format(System.currentTimeMillis());
		Gson gson = new Gson();

		if (chatIsUser == 1) {
			MChatSession session_ = aSessionMap.get(sessionUserMap.get(chatId));
			session.getAsyncRemote().sendText(gson.toJson(new ChatData(message, nowDate, true, null, null)));
			session_.getSession().getAsyncRemote()
					.sendText(gson.toJson(new ChatData(message, nowDate, false, session_.getUser(), null)));
		} else {
			// 获取用户id
//			String jsonString = "{\"name\":\"张三\",\"age\":24}";
			ChatMessage chatMessage = gson.fromJson(message, ChatMessage.class);
			System.out.println(chatMessage);
			for (Entry<Integer, List<Integer>> temp : sessionAdminMap.entrySet()) {
				System.out.println(temp.getKey() + ":" + temp.getValue().toString());
			}
			if (sessionAdminMap.get(chatId).equals(null))
				return;
			if (sessionAdminMap.get(chatId).contains(chatMessage.getUid())) {
				for (Entry<Integer, MChatSession> temp : uSessionMap.entrySet()) {
					System.out.println(temp.getKey() + ">>>" + temp.getValue().toString());
				}
				MChatSession session_ = uSessionMap.get(chatMessage.getUid());
				System.out.println(session_);
				session.getAsyncRemote()
						.sendText(gson.toJson(new ChatData(chatMessage.getMsg(), nowDate, true, null, null)));
				session_.getSession().getAsyncRemote().sendText(
						gson.toJson(new ChatData(chatMessage.getMsg(), nowDate, false, null, session_.getAdmin())));
			}
		}
	}

	@OnError
	public void error(Session session, Throwable t) {
		t.printStackTrace();
	}

}
