

function validation(frm){
	frm.vflag.value="yes";
	//alert(frm.vflag.value="yes");
	//get the error messages
//	alert(1);
	document.getElementById("empnameErr").innerHTML="";
	document.getElementById("salaryErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	
	let ename=frm.empname.value;
	let salary=frm.salary.value;
	let job=frm.job.value;
	let flag=true;
	
	if(ename==""){
		document.getElementById("empnameErr").innerHTML="Employee Must be present !!";
		flag=false;
	}
	else if(ename.length>10){
		document.getElementById("empnameErr").innerHTML="Size must be less than 10 characters please !!";
		flag=false;
	}
	
	if(job==""){
		document.getElementById("jobErr").innerHTML="Job Must be present !!";
		flag=false;
	}
	else if(ename.length>10){
		document.getElementById("jobErr").innerHTML="Size must be less than 9 characters please !!";
		flag=false;
	}
	
	if(salary==""){
		document.getElementById("salaryErr").innerHTML="Salary is required !!"
		flag=false;
	}else if(isNaN(salary)){
		document.getElementById("salaryErr").innerHTML="Salary should be numeric !!"
	}
	else if(salary<1000 || salary>400000){
		document.getElementById("salaryErr").innerHTML="Salary is must be in range  !!"
		flag=false;
	}
	//alert(2);

	frm.vflag.value="yes";

//	alert(document.getElementById("flag").value="yes");
 	return flag;
}