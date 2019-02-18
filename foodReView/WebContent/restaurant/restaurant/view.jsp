<%@page import="bean.ResListVo"%>
<%@page import="bean.ResListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- <script src="/foodReView/lib/jquery-3.3.1.min.js"></script> -->
<style>
<!--
.gallery-wrap .img-big-wrap img {
    height: 450px;
    width: auto;
    display: inline-block;
  
}


.gallery-wrap .img-small-wrap .item-gallery {
    width: 60px;
    height: 60px;
    border: 1px solid #ddd;
    margin: 7px 2px;
    display: inline-block;
    overflow: hidden;
}

.gallery-wrap .img-small-wrap {
    text-align: center;
}
.gallery-wrap .img-small-wrap img {
    max-width: 100%;
    max-height: 100%;
    object-fit: cover;
    border-radius: 4px;
    /*cursor: zoom-in;*/
    cursor: pointer;
}
-->
</style>
<%
String serialStr = request.getParameter("resSerial");

int serial = serialStr == null ? 1 : Integer.parseInt(serialStr);
ResListDao dao = new ResListDao();
ResListVo vo = dao.view(serial);
if(vo.getResAddress() == null) vo.setResAddress("경기도 성남시 분당구 정자동 불정로 6");
%>
<c:set var='v' value='<%=vo %>' scope='page'/>
    <div id='restaurantView'>
    
 
		<div class="container">
								   
			<div class="card">
			   <div class="row">
			      <aside class="col-sm-5 border-right">
			<article class="gallery-wrap"> 
			<div class="img-big-wrap">
			  <div><img src="http://placehold.it/300x300"></div>
			</div> 
			<div class="img-small-wrap">
			  <div class="item-gallery"> <img src="http://placehold.it/100x100"> </div>
			  <div class="item-gallery"> <img src="http://placehold.it/100x100"> </div>
			  <div class="item-gallery"> <img src="http://placehold.it/100x100"> </div>
			  <div class="item-gallery"> <img src="http://placehold.it/100x100"> </div>
			  
			</div> 
			</article> 
			      </aside>
			      <aside class="col-sm-7">
			<article class="card-body p-5">
			   <h3 class="title mb-3">${v.resName }</h3>
			<input type='hidden' id='resSerial' value='${v.resSerial }'>
			<dl class="param param-feature">
			  <dt>전화번호</dt>
			  <dd>${v.resPhone }</dd>
			</dl>  <!-- item-property-hor .// -->
			<dl class="param param-feature">
			  <dt>주소</dt>
			  <dd>${v.resAddress}</dd>
			</dl>  <!-- item-property-hor .// -->
			<dl class="param param-feature">
			  <dt>홈페이지</dt>
			  <dd>${v.resSite }</dd>
			</dl>  <!-- item-property-hor .// -->
			<dl class="param param-feature">
			  <dt>이용시간</dt>
			  <dd>${v.resOpentime } ~ ${v.resClosetime }</dd>
			</dl>  <!-- item-property-hor .// -->						
			<dl class="param param-feature">
			  <dt>휴무일</dt>
			  <dd>${v.resHoliday }</dd>
			</dl>
			<dl class="param param-feature">
			  <dt>설명</dt>
			  <dd>${v.resContent}</dd>
			</dl>
			<dl class="param param-feature">
			  <dt>분류</dt>
			  <dd>${v.resCategory }</dd>
			</dl>
			<dl class="param param-feature">
			  <dt>위치</dt>
			  <dd><div id="locMap" style="width:350px;height:300px;"></div></dd>
			</dl>
			
			</article>
			      </aside>
			   </div>
			</div> 
		
		
		</div>


    </div>
    <script>
    var addr = '<%=vo.getResAddress().replaceAll(" ", "%20")%>';
    var url = 'restaurant/map.jsp?resName=${v.resName}&resAddr=' + addr;
    $('#restaurantView #locMap').load(url);
    </script>
    