<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='../style/modify.css'>
<link rel='stylesheet' href='../style/loginok.css'>
<style>
#dialog{
    display: none;
    position: fixed;
    top: 0; left: 0;
    width: 100%; height: 100%;
    background: rgba(0,0,0,.3);
    z-index: 10;
}
#my-dialog {
    display: none;
    position: fixed;
    left: calc( 50% - 160px ); top: calc( 50% - 70px );
    width: 400px; height: 500px; 
    background: #fff;
    z-index: 11;
    padding: 10px;
}
</style>
<script src='//code.jquery.com/jquery.min.js'></script>
<script>
$(function(){
	$('#btn-open-dialog,#dialog,#btnok').click(function(){
		$('#my-dialog,#dialog').toggle();
	});
});

var test = document.getElementById('btn-open-dialog');

test.addEventListener('click',function(){
	location.href="btn-open-dialog.mb";
});
</script>
</head>
<body>
<input type='button' id='btn-open-dialog' value='내정보'>
<section class='container'>
<div id='my-dialog'>
	<form method='post' action='abc.mb?code=modify'>
		<label>아이디</label>
		<input type='text' name='id' id='id'>
		<br/>
		<label>비밀번호</label>
		<input type='password' name='pwd' id='pwd' class='join-inpt'>
		<br/>
		<label>이름</label>
		<input type='text' name='name' id='name' class='inpt'>
		<br/>
		<label>핸드폰</label>
		<input type='text' name='phone' id='phone' class='inpt'>
		<br/>
		<label>우편번호</label>
		<input type='text' name='postal' id='postal' class='inpt'>
		<input type='button' name='btnpostal' id='btnpostal' class='idChk-submit' value='검색'>
		<br/>
		<label>주소</label>
		<input type='text' name='address' id='address' class='inpt'>
		<br/>
		<input type='button' name='btnok' id='btnok' class='idChk-submit' value='확인'>
		<input type='button' name='btnmodify' id='btnmodify' class='idChk-submit' value='수정'>
		<input type='button' name='btndelete' id='btndelete' class='idChk-submit' value='탈퇴'> 
	</form>
</div>
<div id ='dialog'></div>
</section>
</body>
</html>