<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="kr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>J M T G R - 로그인</title>
<link href="../style/login.css" rel="stylesheet">
<link rel='stylesheet' href='../style/loginok.css'>
<script src='../js/member.js'></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<c:if test="${empty sessionScope.uid }">
		<%-- 로그인되어있지 않는 상태라면 --%>
		<section class="container" id="shabang">
			<article class="half">
				<h1>
					<a href="../index">J M T G R</a>
				</h1>
				<div class="tabs">
					<span class="tab signin active"><a href="#signin">로그인</a></span> 
					<span class="tab signup"><a href="#signup">회원가입</a></span>
				</div>
				<div class="content">
					<div class="signin-cont cont">
						<form action="abc.mb?code=index" method="post">
							<label for="uid">Your ID</label> 
							<input name="uid" class="inpt" required="required" placeholder="Your ID" autocomplete="off">
							
							<label for="pwd">Your password</label>
							<input type="password" name="pwd" class="inpt" required="required" placeholder="Your password"> 
							
							<input type="checkbox" id="remember" class="checkbox" checked>
							
							<div class="submit-wrap">
							<input type="hidden" name="return-url" value="${param['return-url']}" /> 
							<input type="button" value="Sign in" id='btngo' class="submit">
							<a href="#" class="more">아이디/비밀번호 찾기</a>
							</div>
						</form>
					</div>
					<div class="signup-cont cont" id="idchk">
						<form action="./main.jsp" method="post" name="userInfo" >
							<div class="idChk-group">
								<label for="uid">Use ID</label> 
								<input id="id" name="uid" class="join-inpt" required="required" placeholder="Use ID" style="width: 180px;"> 
								<input type="button" value="중복확인" class="idChk-submit" id='idchk' style="width: 70px;" onclick='idchk();'>
							</div>

							<label for="pwd">비밀번호</label> 
							<input type="password" name="pwd" class="join-inpt" required="required" placeholder="Use password">
							<label for="pwdChk">비밀번호 확인</label> 
							<input type="password" name="pwdChk" class="join-inpt" required="required" placeholder="Password check"> 
							<label for="unick">이름</label>
							<input name="unick" class="join-inpt" required="required" placeholder="Use nickname"> 
							<label for="email">이메일</label>
							<input type="email" name="email" class="join-inpt" required="required" placeholder="Your email"> 
							<label for='phone'>핸드폰</label>
							<input type='text' name='phone' class='join-inpt' required='required' placeholder='핸드폰번호'>

							<div class='postalchk-group'>
								<label for='postal'>우편번호</label> 
								<input type='text' name='postal' class='join-inpt' required='required' placeholder='우편번호' style='width: 180px;'> 
								<input type='button' class='idChk-submit' name='btnpostal' value='우편번호' style='width: 70px;'>
							</div>

							<label for='address'>주소</label> 
							<input type='text' name='address' class='join-inpt' required='required' placeholder='상세주소'>
							<input type='button' class='idChk-submit' id='btnok' value='확인' >
						</form>
					</div>
				</div>
			</article>
			<div class="half bg"></div>
		</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	</c:if>
<script>
$('.tabs .tab').click(function() {
	if ($(this).hasClass('signin')) {
		$('.tabs .tab').removeClass('active');
		$(this).addClass('active');
		$('.cont').hide();
		$('.signin-cont').show();
	}
	if ($(this).hasClass('signup')) {
		$('.tabs .tab').removeClass('active');
		$(this).addClass('active');
		$('.cont').hide();
		$('.signup-cont').show();
	}
});


$(function(){
	$('#btngo').on("click",function(){
		location.href='./member/main.jsp';
	});
	
	$('#btnok').on("click",function(){
		location.href='./member/main.jsp';
	});
});

</script>
<script>mainInsert()</script>
</body>
</html>