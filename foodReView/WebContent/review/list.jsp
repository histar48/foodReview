<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");
String rInsert = request.getParameter("mainLeft");

if(rInsert == null){
	rInsert = "insert.jsp";
}

%>

<!-- <script src='../js/review.js'></script> -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>




<div id="reviewWrap" class="">
		<div id="rWrap">
			<div id="reviewInsertWrap">
				<div id="reviewTitle">
				
					<h3>평점&amp;후기</h3>
				
				</div>			
				
				<jsp:include page="<%=rInsert%>"/>
					
			</div>
		
			<div id="reviewListWrap">
				<div><span>네티즌 평점</span><span>0.0</span></div>
				
				
				
				<!-- 반복되는 부분 -->
				
				<div id="reviewRows">
					<div id="reviewRow">				
					  <div class="media">
					    <div class="media-left media-top">
					      <img src="http://placehold.it/150x150" class="media-object" style="width:150px">
					    </div>
					    <div class="media-body">
					      <h4 class="media-heading">Media Top</h4>
					      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
					      <p>&nbsp;</p>
					      <p>&nbsp;</p>
					      
					      <div>
					 	   	<button type="button" class="btn btn-primary">수정</button>
					 	   	<button type="button" class="btn btn-primary">삭제</button>
					      </div>
					    </div>
					  </div>	
					<hr>
					</div>		
				
				</div>
				
				<!-- //반복되는 부분 -->
				
				
				<div id="reviewPaging">
					<div class="revlist_btns">
					    <div class="paginate"><!-- remove width id you don't need it-->
					        <ul class="pagination">
					          <li><a href="#"rel="prev" class="page-prev"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
					          <li class="active "><span>1</span></li>
					          <li><a href="#" class=" ">2</a></li>
					          <li><a href="#" class=" ">3</a></li>
					          <li><a href="#" rel="next" class="page-next"><span class="glyphicon glyphicon-chevron-right"></span></a></li> 
					        </ul>
					        <div class="clearfix"></div>
					     </div>
					</div>  	
					
				</div>	
			</div>
		</div>
</div>