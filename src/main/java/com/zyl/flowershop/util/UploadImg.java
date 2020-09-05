package com.zyl.flowershop.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadImg {
	public String uploadWaterLogoImg(MultipartFile file, String path) throws IOException {
		String fileName = "_" + System.currentTimeMillis() + "." + file.getOriginalFilename().split("\\.", 2)[1];
		File dest = new File((System.getProperty("user.dir") +path),
                fileName);
		Image srcImg = ImageIO.read(file.getInputStream());
		int srcImgWidth = srcImg.getWidth(null);
		int srcImgHeight = srcImg.getHeight(null);
		// 加水印
		BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
		// 获取 Graphics2D 对象
		Graphics2D g = bufImg.createGraphics();
		// 设置绘图区域
		g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
		// 设置字体
		Font font = new Font("宋体", Font.PLAIN, 15);
		// 根据图片的背景设置水印颜色
		g.setColor(Color.gray);
		g.setFont(font);
		// 获取文字长度
		int len = g.getFontMetrics(g.getFont()).charsWidth("图片來源:ZJ购物商城".toCharArray(), 0, "图片來源:ZJ购物商城".length());
		int x = srcImgWidth - len - 10;
		int y = srcImgHeight - 20;
		g.drawString("图片來源:ZJ购物商城", x, y);
		g.dispose();
		// 输出图片
		FileOutputStream outImgStream = new FileOutputStream(dest);
		ImageIO.write(bufImg, fileName.substring(fileName.lastIndexOf(".") + 1), outImgStream);
		outImgStream.flush();
		outImgStream.close();
		return fileName;
	}

	public String uploadImage(MultipartFile file, String path) throws IOException {
		String fileName = "_" + System.currentTimeMillis() + "." + file.getOriginalFilename().split("\\.", 2)[1];
		 File dest = new File((System.getProperty("user.dir") +path),
	                fileName);
		file.transferTo(dest);
		return fileName;
	}

}
