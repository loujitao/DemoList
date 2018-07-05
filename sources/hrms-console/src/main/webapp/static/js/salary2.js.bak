function getSum(){
	var va =  document.getElementsByName("standardDetailIname");
	var sum = "";
	for(var i = 0;i<va.length;i++){
			sum +=	va[i].value
		
	}
	document.getElementById("salary").value = sum ;
}
 
function changeTab(msg1, msg2, msg3) {
	obj1 = document.getElementById(msg1);
	obj2 = document.getElementById(msg2);
	obj3 = document.getElementById(msg3);
	
	
	obj1.style.display="block";
	obj2.style.display="none";
	obj3.style.display="none";
}

//校验增加时的薪酬标准表
function checkform() {
	var fm = document.getElementById("form1");
	var standardCode = fm.standardCode.value;
	var standardName = fm.standardName.value;
	var standardSalarySum = fm.standardSalarySum.value;
	var standardDesigner = fm.standardDesigner.value;
	//var register = fm.register.value;
	
	if(null == standardCode || standardCode.length < 1) {
		alert("请输入薪酬标准编号!");
		return;
	}else if(null == standardName || standardName.length < 1) {
		alert("请输入薪酬标准名称!");
		return;
	}else if(isNaN(standardSalarySum)){
		alert("请输入合法的薪酬金额");
		return;
	}else if(null == standardDesigner || standardDesigner.length < 1){
		alert("请输入制定人姓名!");
		return;
	//}else if(null == register || register.length < 1){
		//alert("请输入登记人姓名");
		//return;
	}else {
		fm.submit();
	}
}
//校验修改时的薪酬标准表
function checkform2() {
	var fm = document.getElementById("form1");
	var standardCode = fm.standardCode.value;
	var standardName = fm.standardName.value;
	var standardSalarySum = fm.standardSalarySum.value;
	var standardDesigner = fm.standardDesigner.value;
	var register = fm.register.value;
	
	if(null == standardCode || standardCode.length < 1) {
		alert("请输入薪酬标准编号!");
		return;
	}else if(null == standardName || standardName.length < 1) {
		alert("请输入薪酬标准名称!");
		return;
	}else if(isNaN(standardSalarySum)){
		alert("请输入合法的薪酬金额");
		return;
	}else {
		fm.submit();
	}
}

function resetform() {
	var fm = document.getElementById("form1");
	fm.reset();
}

function addTr() {

	
	
	var tObj = document.getElementById("msg5");

	var tr = document.getElementsByTagName("tr");
	var maxTr = tr[tr.length-1].children[0].innerText;
	var trInt = parseInt(maxTr) + 1;
	
	var trObj = tObj.insertRow();
	var tdObj1 = trObj.insertCell();
	var tdObj2 = trObj.insertCell();
	var tdObj3 = trObj.insertCell();
	var tdObj4 = trObj.insertCell();
	
	tdObj1.innerText=trInt;
	tdObj1.style.background="#f0fbda";
	tdObj1.align="center";
	
	tdObj2.align="center";
	tdObj2.style.background="#f0fbda";
	tdObj2.innerHTML="<input type='text' name=\"standardDetailIname\" class='inp1' />";
	
	tdObj3.align="center";
	tdObj3.style.background="#f0fbda";
	tdObj3.innerHTML="<input type='text' name=\"standardDetailIsalary\" class='inp1' onblur='getSum()'/>";
	
	tdObj4.align="center";
	tdObj4.style.background="#f0fbda";
	tdObj4.innerHTML="<select name=\"standardDetailIrule\">"
			+"<option value=\"1\">按出勤天数计算</option>"
    		+"<option value=\"2\">按考核分数计算</option>"
    		+"<option value=\"3\">固定值</option>"
    		+"<option value=\"4\">手工填写</option>"
    		+"</select>";
}
function delTr()
{
 var objTable = document.getElementById("msg5");
 var tr = document.getElementsByTagName("tr");

 if(objTable.rows.length==3)
 {
  alert("对不起，你不能删除表格头!!!");
  return;
 }
 if(confirm("确定删除?"))
 {
  objTable.deleteRow();
 }
}

//function checkSelect(){
//	var ruleId = document.getElementById("standardDetailRuleId").value;
//	alert("ruleId--"+ruleId);
//	var rule = document.getElementById("standardDetailIrule").options;
//	for(var i = 0; i < rule.length; i++){
//		if(ruleId == rule[i].value) {
//				rule[i].selected=true;
//		}
//	}	
//}

//选择按钮
function selectButton()
{
	var button=document.getElementById("getButton").value;
	
	if(button==1){
		document.getElementById("count").disabled=false;
		document.getElementById("data").disabled=true;
	}
	if(button==2){
		document.getElementById("count").disabled=true;
		document.getElementById("data").disabled=true;
	}
}


function checkDelete(){
	var inps = document.getElementsByTagName("input");
	var frm=document.getElementById("form1")
	var sum=0;
	for(var i = 0; i < inps.length; i++ ) {
			if("checkbox" == inps[i].type) {
				if(inps[i].checked==true){
					sum++;
				}
			}
	}
	if(sum==0){
		alert("请选择要删除的选项！");
		return false;
	}else{
		frm.submit();
		return true;
	}
		

}




function SplitDemo()
{
  var s, ss;
  var s = "The quick brown fox jumped over the lazy yellow dog.";
  // 在每个空格字符处进行分解。
  ss = s.split(" ");
  alert(ss)
  return false;
}
