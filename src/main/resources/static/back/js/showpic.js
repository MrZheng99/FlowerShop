function setImagePreviews(imagesObj,divid) {
    var dd = document.getElementById(divid);
    dd.style.display="block";
    dd.innerHTML = "";
    var fileList = imagesObj.files;
    for (var i = 0; i < fileList.length; i++) {            
        dd.innerHTML += "<div style='float:left' > <img id='"+divid+"_img" + i + "'  /> </div>";
        var imgObjPreview = document.getElementById(divid+"_img"+i); 
        if (imagesObj.files && imagesObj.files[i]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '100px';
            imgObjPreview.style.height = '100px';
            imgObjPreview.src = window.URL.createObjectURL(imagesObj.files[i]);
        }else {
            //IE下，使用滤镜
            imagesObj.select();
            var imgSrc = document.selection.createRange().text; //运用IE滤镜获取数据;
            //alert(imgSrc);
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "100px";
            localImagId.style.height = "100px";
            //图片异常的捕捉
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader( true,sizingMethod=scale,src = imgSrc)";  //scale：缩放图片以适应对象的尺寸边界。
            }
            catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty(); //在当前网页下不能选择对象,也就是鼠标不能选中 
        }
    }  
    return true;
}


function setFloImagePreviews(imagesObj,divid) {
    var dd = document.getElementById(divid);
    dd.style.display="block";
    dd.innerHTML = "";
    var fileList = imagesObj.files;
    for (var i = 0; i < fileList.length; i++) {            
        dd.innerHTML += "<div style='float:left' > <img id='"+divid+"_img" + i + "'  /> </div>";
        var imgObjPreview = document.getElementById(divid+"_img"+i); 
        if (imagesObj.files && imagesObj.files[i]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '150px';
            imgObjPreview.style.height = '150px';
            imgObjPreview.src = window.URL.createObjectURL(imagesObj.files[i]);
        }else {
            //IE下，使用滤镜
            imagesObj.select();
            var imgSrc = document.selection.createRange().text; //运用IE滤镜获取数据;
            //alert(imgSrc);
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "100px";
            localImagId.style.height = "100px";
            //图片异常的捕捉
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader( true,sizingMethod=scale,src = imgSrc)";  //scale：缩放图片以适应对象的尺寸边界。
            }
            catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty(); //在当前网页下不能选择对象,也就是鼠标不能选中 
        }
    }  
    return true;
}

function modifyFloImagePreviews(imagesObj,divid, x) {   //x为修改鲜花信息中图片的序号
    var dd = document.getElementById(divid);
    dd.style.display="block";
    dd.innerHTML = "";
    var fileList = imagesObj.files;
    for (var i = 0; i < fileList.length; i++) {            
        dd.innerHTML += "<img id='"+divid+"_img" + x + "'  /><input type='file' id='pic_"+ x + "'  style='display:none;' onchange='show_img(this ,"+ x +")'> <input type='button' value='再次修改' onclick='modify_img("+ x +")'> ";
        var imgObjPreview = document.getElementById(divid+"_img"+x); 
        if (imagesObj.files && imagesObj.files[i]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '150px';
            imgObjPreview.style.height = '150px';
            imgObjPreview.src = window.URL.createObjectURL(imagesObj.files[i]);
        }else {
            //IE下，使用滤镜
            imagesObj.select();
            var imgSrc = document.selection.createRange().text; //运用IE滤镜获取数据;
            //alert(imgSrc);
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "100px";
            localImagId.style.height = "100px";
            //图片异常的捕捉
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader( true,sizingMethod=scale,src = imgSrc)";  //scale：缩放图片以适应对象的尺寸边界。
            }
            catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty(); //在当前网页下不能选择对象,也就是鼠标不能选中 
        }
    }  
    return true;
}

function setAdmImagePreviews(imagesObj,divid) {
    var dd = document.getElementById(divid);
    dd.style.display="block";
    dd.innerHTML = "";
    var fileList = imagesObj.files;
    for (var i = 0; i < fileList.length; i++) {            
        dd.innerHTML += "<div style='text-align:center' > <img id='"+divid+"_img" + i + "'  /> </div>";
        var imgObjPreview = document.getElementById(divid+"_img"+i); 
        if (imagesObj.files && imagesObj.files[i]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '200px';
            imgObjPreview.style.height = '200px';
           imgObjPreview.src = window.URL.createObjectURL(imagesObj.files[i]);
        }else {
            //IE下，使用滤镜
            imagesObj.select();
            var imgSrc = document.selection.createRange().text; //运用IE滤镜获取数据;
            //alert(imgSrc);
            var localImagId = document.getElementById("img" + i);
            //必须设置初始大小
            localImagId.style.width = "200px";
            localImagId.style.height = "200px";
            //图片异常的捕捉
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader( true,sizingMethod=scale,src = imgSrc)";  //scale：缩放图片以适应对象的尺寸边界。
            }
            catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty(); //在当前网页下不能选择对象,也就是鼠标不能选中 
        }
    }  
    return true;
}