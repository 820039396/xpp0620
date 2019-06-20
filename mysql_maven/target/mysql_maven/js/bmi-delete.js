/**
 * Created by Administrator on 2019/5/15.
 */
var delId;
function bmi_delete(bmiid) {
    alert("delete"+bmiid);
    delId=bmiid;
    var url="http://localhost:8088/bim?action=delete&id="+bmiid;
    myAjax("GET",url,true,null,sucess,myError);
}
function sucess(msg) {
    if (msg=="success"){
        alert("删除成功");
        var tb =  document.getElementById("table_history");
        var delTr = document.getElementById(delId);
        tb.removeChild(delTr);//删除页面的行
    }
}
function myError() {
    alert("操作异常");
}