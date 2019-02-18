<%@page import="bean.StoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<link rel='stylesheet' type='text/css' href='./style/member.css'  >

</head>
<body>

<%
   String msg = "";
   if(request.getMethod().equals("POST")){
      String email = request.getParameter("email");
      String irum = request.getParameter("irum");
      String findType = request.getParameter("findType");
      String id = request.getParameter("id");
      
      StoreDao dao = new StoreDao();
      msg = dao.findId(findType, irum, email, id);
   }
%>

<div id = 'member'>
   <form name = 'member' method ='post'>
   
   <label>선택</label>
   <label><input type='radio' name='findType' value='find_id'
      ${(param.findType=='find_id')? 'checked' : '' } 
      checked onclick = 'chk(1)' />아이디 찾기</label>
   <label><input type='radio' name='findType' value='find_pwd'
      ${(param.findType=='find_pwd')? 'checked' : '' }
      onclick = 'chk(2)' />암호 찾기</label>
      <p/>  
   
   <div id='zone_id'>
   <br/>
   <label>아이디</label>
   <input type='text' name='id' autocomplete ='off'>
   </div>
   
   <label>이름</label>
   <input type='text' size ='10' name='irum' autocomplete = 'off' ><p/>
   <label>이메일</label>
   <input type='email' size='35' name='email' autocomplete='off' placeholder ='등록시 입력한 이메일'>
   <input type ='submit' value = '찾기'/>  
   </form>
   
   <div id='result'> <%= msg %> </div>

</div>


<script>
var frm = document.member;
 
if(frm.findType[1].checked){
   chk(2);
}
 
function chk(obj){
   var zone = document.getElementById('zone_id');
    
   if(obj ==1){
      zone.style.display='none';
   }else if(obj ==2){
      zone.style.display='block';
   }
}
 
   frm.onsubmit = function(){
      if(frm.email.value==''){
         alert("이메일을 입력해주세요");
         return false;
      }
    }
</script>
</body>
</html>