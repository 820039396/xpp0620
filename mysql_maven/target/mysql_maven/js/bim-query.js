/**
 * 页面加载时触发的功能
 * Created by Administrator on 2019/5/15.
 */
window.onload=function () {
    //判断浏览器是否支持XMLHttpResqust
    alert("od");
    var xhr;
    if(window.XMLHttpRequest){
        xhr=new XMLHttpRequest();
    }else {
        xhr=new ActiveXObject("Microsoft.XMLHttpRequest");
    }
    //设置回调函数
    xhr.onreadystatechange = huidiao;
    //设置请求地址、参数
    var url="http://localhost:8088/bim?action=list";
    xhr.open("GET",url,true);
    //发送请求
    xhr.send(null);
    //在回调函数中使用（原生的）dom模型异步更新界面
    function huidiao() {
        if (xhr.readyState==4 && xhr.status==200){
            alert("请求成功");
            alert(xhr.responseText);
            var table=document.getElementById("table_history");
            var datas = JSON.parse(xhr.responseText);
            for(var i=0;i<datas.length;i++){
                var tr = document.createElement("tr");
                tr.id=datas[i].id;
                tr.className="table_history_title";
                tr.innerHTML="<td>"+datas[i].id+"</td>"
                            +"<td>"+datas[i].date+"</td>"
                    +"<td>"+datas[i].height+"</td>"
                    +"<td>"+datas[i].weight+"</td>"
                    +"<td>"+datas[i].bmi+"</td>"
                    +'<td><input type="submit" value="删除" class="submit" onclick="bmi_delete('+datas[i].id+')" /></td>'
                table.appendChild(tr);
            }

        }
    }
}