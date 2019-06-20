/**
 * Created by Administrator on 2019/5/17.
 */
function bmi_add() {
    //h/w/bmi
    var d=new Date();
    sign=d.getTime();
    date=d.getFullYear()+"-"+(d.getMonth()+1);
    var url = "http://localhost:8088/bim?action=add&h="+h+"&w="+w+"&bmi="+bmi+"&date="+date+"&sign="+sign;
    alert(url);
    myAjax("GET",url,true,null,modifyList,myError);
}
function modifyList(mac){
    alert("在列表中添加一行记录"+mac);
    var macs =  JSON.parse(mac);
    var ma=0;
    for(var i =0;i<macs.length ;i++){
        if(i==(macs.length-1)){
            ma=macs[i].id;
        }
    }
    var tb =  document.getElementById("table_history");
    /*var rowNum=tb.rows.length;
     for (i=0;i<rowNum;i++)
     {
     tb.deleteRow(i);
     rowNum=rowNum-1;
     i=i-1;
     }*/
    var count=ma;
    var tr =  document.createElement("tr");
    tr.id= count;  //设置行的id，方便根据id删除此行
    tr.className = "table_history_rsult";
    tr.innerHTML = " <td>" +count + "</td>"
        + "<td>" + date + "</td>"
        + "<td>" + h + "</td>"
        + "<td>" + w + "</td>"
        + "<td>" + bmi + "</td>"
        + '<td><input type="submit" value="删除" class="submit" /></td>';
    tb.appendChild(tr);
    alert("添加成功");
}