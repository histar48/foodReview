<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
    <div id='listWrap'>
    	<div id='listTitle'>
    		<h3>맛집 리스트</h3>
    	</div>
    	
    	<div id='list_search'>
	    	<form name="listSearch" id="listSearch" method="post">
	    		<input type="search" name="searchBar" id="searchBar"  class="  search-query form-control" placeholder="Search" />
	    				      <button class="btn btn-danger" type="button" name="btnListSearch" id="btnListSearch">
		                          <span class=" glyphicon glyphicon-search"></span>
		                      </button>
	    		<input type="hidden" name="serial"/> 
	    		<input type="hidden" name="nowPage"/>
	    	</form>
    	</div>
    	    	
    	<div id='restaurantList'>
 				    <div class="row">
				        <div class="col-xs-12" style="">
				            <div class="panel panel-default list-group-panel">
				                <div class="panel-body">
				                    <ul class="list-group list-group-header">
				                        <li class="list-group-item list-group-body">
				                            <div class="row">
				                                <div class="col-xs-4 text-left">Restaurant</div>
				                                <div class="col-xs-3">Location</div>
				                                <div class="col-xs-2">Score</div>
				                                <div class="col-xs-2">hit</div>
				                            </div>
				                        </li>
				                    </ul>
				                    <ul class="list-group list-group-body" style="">
				                    <c:forEach var="i" begin="1" end="10">
				                        <li class="list-group-item r_list-item">
				                            <form class="row" onclick='resView(this)'>
				                                <div class="col-xs-4 text-left" style=" "><span class="glyphicon glyphicon-file" aria-hidden="true"></span> 맥도날드 </div>
				                                <div class="col-xs-3" style="">서울</div>
				                                <div class="col-xs-2" style="">6.0</div>
				                                <div class="col-xs-2" style="">2034</div>
				                                <input type="hidden" name='serial' value="1">
				                            </form>
				                        </li>
				                    </c:forEach>
				                    </ul>
				                </div>
				            </div>
				        </div>
				    </div>   
					
					<div class="list_btns">
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
    