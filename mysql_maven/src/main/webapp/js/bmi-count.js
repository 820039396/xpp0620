/**
 * Created by Administrator on 2019/5/15.
 */
var h;
var w;
var bmi;
var sign;
var date;


function Cal() {
    alert("计算");
    //获取表单的输入数据
    h=document.getElementById("height").value;
    w=document.getElementById("weight").value;
    alert(h+"=="+w);
    var genders = document.getElementsByName("sex");
    var gender;
    for(var i=0;i<genders.length;i++){
        if( genders[i].checked){
            gender = genders[i].id;
        }
    }
    var idea_w = (h- 80)*0.7;
    idea_w=Math.round(idea_w*100)/100;
    h=h/100;
    bmi=w/(h*h);
    bmi=Math.round(bmi*100)/100;
    var bmi_result_photo =  document.getElementById("bmi_result_photo");
    var  bmi_result_value=  document.getElementById("bmi_result_value");
    bmi_result_idealweight =   document.getElementById("bmi_result_idealweight");
    bmi_result_idealweight.innerText = idea_w;//innerText修改p标签的值

    if(gender=="male"){
        if(bmi<18.5){
            bmi_result_photo.src = "img/3_01.jpg";
            bmi_result_value.innerText =bmi +" 偏瘦";
            bmi_result_value.style.background ="rgb( 135, 206, 250)";
            bmi_result_idealweight.style.background ="rgb( 135, 206, 250)";
        }else if(bmi>=18.5 && bmi < 25 ){
            bmi_result_photo.src = "img/3_02.jpg";
            bmi_result_value.innerText =bmi +" 正常";
            bmi_result_value.style.background ="rgb(180, 238, 180)";
            bmi_result_idealweight.style.background ="rgb(180, 238, 180)";
        }else if(bmi>=25 && bmi < 30 ){
            bmi_result_photo.src = "img/3_03.jpg";
            bmi_result_value.innerText =bmi +" 过重";
            bmi_result_value.style.background ="gold";
            bmi_result_idealweight.style.background ="gold";
        }else if(bmi>=30 ){
            bmi_result_photo.src = "img/3_04.jpg";
            bmi_result_value.innerText =bmi +" 肥胖";
            bmi_result_value.style.background ="rgb(238, 99, 99)";
            bmi_result_idealweight.style.background ="rgb(238, 99, 99)";
        }
    }else {
        if(bmi<20.5){
            bmi_result_photo.src = "img/3_01_01.jpg";
            bmi_result_value.innerText =bmi +" 偏瘦";
            bmi_result_value.style.background ="rgb( 135, 206, 250)";
            bmi_result_idealweight.style.background ="rgb( 135, 206, 250)";
        }else if(bmi>=20.5 && bmi < 27 ){
            bmi_result_photo.src = "img/3_01_03.jpg";
            bmi_result_value.innerText =bmi +" 正常";
            bmi_result_value.style.background ="rgb(180, 238, 180)";
            bmi_result_idealweight.style.background ="rgb(180, 238, 180)";
        }else if(bmi>=27 && bmi < 32 ){
            bmi_result_photo.src = "img/3_01_04.jpg";
            bmi_result_value.innerText =bmi +" 过重";
            bmi_result_value.style.background ="gold";
            bmi_result_idealweight.style.background ="gold";
        }else if(bmi>=32 ){
            bmi_result_photo.src = "img/3_01_05.jpg";
            bmi_result_value.innerText =bmi +" 肥胖";
            bmi_result_value.style.background ="rgb(238, 99, 99)";
            bmi_result_idealweight.style.background ="rgb(238, 99, 99)";
        }
    }
    bmi_add();
}