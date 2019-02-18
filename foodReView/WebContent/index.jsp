<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<link rel='stylesheet' type='text/css' href='./style/index.css'>
		<link rel='stylesheet' type='text/css' href='./style/review.css'>
		<link rel='stylesheet' type='text/css' href='./style/restaurantList.css'>  		
				
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  		
  		<script src="lib/jquery-3.3.1.min.js"></script>
  		<script src="js/restaurant.js"></script>
  		<script src="js/review.js"></script>
  		
		<%
			request.setCharacterEncoding("utf-8");
			String aCont = request.getParameter("mainLeft");
			String aMenu = request.getParameter("mainCenterTop");

			if(aCont == null){
				aCont = "./restaurant/list.jsp";
			}
			if(aMenu == null){
				aMenu = "./restaurant/hitList_sub.jsp";
			}

			
		%>	
  		
  		
		
		
	</head>
	<body>
		<div id="jmtgrWrap">
		
			<%@ include file="header.jsp" %>		
		
		
			<div id="jmtgrContent">
			
				<div id="cMain" class=>
					<div class='i_content'>
	
						
						<div id="articleContent" class=''>
						
							<div class='cont_article'>
									<div id="contentTop">
										
									
									
									</div>
									
									<div  id="contentMid">
											
									</div>
	
									
									<div  id="contentBottom">
										
										<jsp:include page="<%=aCont%>"/>
					
									
									</div>		
							</div>
						
						</div>
						
						
						<div id="asideMenu" class=''>
							<div class='aside_menu' id="aMenu">
					
								
								
							</div>
						</div>
						
					</div>
				</div>
			
				
			</div>
			
			<%@ include file="footer.jsp" %>				
			
			
		</div>
	
	</body>
</html>