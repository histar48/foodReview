<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <div id='listWrap'>
    	<div id='listTitle'>
    		<h3>맛집 리스트</h3>
    	</div>
    	<div id='list_search'>
	    	<form name="listSearch" id="listSearch" method="post">
	    		<input type="search" name="searchBar" id="searchBar"  class="  search-query form-control" placeholder="Search" />
	    				      <button class="btn btn-danger" type="button" name="btnListSearch" id="btnListSearch" onclick='resList(this.form)'>
		                          <span class=" glyphicon glyphicon-search"></span>
		                      </button>
	    		<input type="hidden" name="serial"/> 
	    		<input type="hidden" id="nowPage" name="nowPage"/>
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
				                    <ul id='restaurantListRow' class="list-group list-group-body" style="">
				                    
				                    </ul>
				                </div>
				            </div>
				        </div>
				    </div>   
					
					<div class="list_btns">
					    <div class="paginate"><!-- remove width id you don't need it-->
					        <ul id='listBtns' class="pagination">

					        </ul>
					        <div class="clearfix"></div>
					     </div>
					</div>    	
    		
    	</div>
      
    </div>
    <script>resList();</script>
    