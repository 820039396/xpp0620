/**
 * Created by Administrator on 2019/5/15.
 */
var xhr2;
function myAjax(method,url,sync,data,mySuccess,myError) {
    //创建XmlHttpRequest对象
    var xhr;
    if(window.XMLHttpRequest){
        xhr = new  XMLHttpRequest();
    }else{//ie系列浏览器
        xhr = new ActiveXObject("Microsoft.XMLHttpRequest");
    }
    xhr2=xhr;
//    2、设置回调函数
    xhr.onreadystatechange = function () {
        if( xhr.readyState == 4 && xhr.status == 200 ){
            mySuccess(xhr.responseText);
        }
    }
//    3、设置请求的地址参数
    xhr.open(method,url,sync);
//    4、发送请求
    xhr.send(data);
}