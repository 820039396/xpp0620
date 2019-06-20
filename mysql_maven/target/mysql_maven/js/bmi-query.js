/**
 * Created by Administrator on 2019/5/15.
 */
window.onload=function (){
    alert("ok");
//    使用ajax发出查询请求
//    1、创建XmlHttpRequest对象
    var xhr;
    if(window.XMLHttpRequest){
        xhr = new  XMLHttpRequest();
    }else{//ie系列浏览器
        xhr = new ActiveXObject("Microsoft.XMLHttpRequest");
    }
//    2、设置回调函数
    xhr.onreadystatechange = huidiao;
//    3、设置请求的地址参数
    var url = "http://localhost:8088/bim?action=list";
    xhr.open("GET",url,true);
//    4、发送请求
    xhr.send(null);
//    5、在回调函数中使用dom模型更新页面（局部）
//
    function huidiao(){
        if( xhr.readyState == 4 && xhr.status == 200 ){
            alert(xhr.responseText);
            var tb =  document.getElementById("table_history");
            var datas =  JSON.parse(xhr.responseText);
            for(var i =0;i<datas.length ;i++){
                // datas[i];
                var tr =  document.createElement("tr");
                tr.id= datas[i].id;  //设置行的id，方便根据id删除此行
                tr.className = "table_history_rsult";

                tr.innerHTML =" <td>"+datas[i].id+"</td>"
                    + "<td>"+datas[i].date+"</td>"
                    + "<td>"+datas[i].height+"</td>"
                    + "<td>"+datas[i].weight+"</td>"
                    + "<td>"+datas[i].bmi+"</td>"
                    +'<td><input type="submit" value="删除" class="submit" onclick="bmi_delete('+datas[i].id+')" /></td>';
                tb.appendChild(tr);
            }


            // <tr class="table_history_rsult">
            //         <td>id</td>
            //         <td>Header</td>
            //         <td>Header</td>
            //         <td>Header</td>
            //         <td>Header</td>
            //         <td><input type="submit" value="删除" class="submit" /></td>
            //         </tr>

        }

    }
}