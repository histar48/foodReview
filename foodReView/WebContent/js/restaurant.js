/**
 * 가게리스트 관련 script
 */

$(function(){
	$('#contentTop').load('restaurant/hitList.jsp');
	
	
	
	$("#btnResInsert").click(function(){
		$('#contentTop').load('restaurant/insert.jsp');
		$('#contentMid').html('');
		$('#contentBottom').html('<br/>');
		
	});
	
	
});

function resView(){
	moveTop();
	$('#contentTop').load('restaurant/view.jsp?resSerial=' + $(this).find('#resSerial').val());
	$('#contentMid').load('review/list.jsp');
	$('#aMenu').load('restaurant/hitList_sub.jsp');
}

function resList(frm){
	var search = '';
	var nowPage = 1;
	var targetList = $('#restaurantList #restaurantListRow');
	var targetBtn = $('#restaurantList #listBtns');
	if(frm != null){
		if(frm.searchBar.value != '') search = frm.searchBar.value;
		if(frm.nowPage.value > 1) nowPage = frm.nowPage.value;
	}
	
	resAjax('get', 'json', 'list.res?search=' + search + '&nowPage=' + nowPage, 'list', targetList, targetBtn);
}

function resAddress(frm){
    new daum.Postcode({
        oncomplete: function(data) {
            frm.postal.value = data.zonecode;
            frm.address.value = data.address;
            frm.location.value = data.sido;
        }
    }).open();
}

function resAjax(sendType, sendDataType, sendUrl, nextFunc, target1, target2){
	$.ajax({
		type : sendType,
		dataType : sendDataType,
		url : sendUrl,
		success : function(data, status){
			switch(nextFunc){
			case 'list' :
			resSpreadList(data, target1, target2);
			break;
			}
		},
		error : function(xhr, status, err){
			alert('실패 원인 : ' + err);
		}
	});
}

function resSpreadList(data, list, btn){
	var strBtn = '';
	var strList = '';
	var d = data[0];
	if(d.nowBlock > 1){
		strBtn += "<li><span class='glyphicon glyphicon-chevron-left'></span></li>";
	}else{
		// 1일때 비활성
		
	}
	for(var i = d.startList; i<=d.endList; i++){
		if(i == d.nowPage){
			strBtn += "<li class='active '><span>" + i + "</span></li>";
		}else{
			strBtn += "<li class=' '><span>" + i + "</span></li>";
		}
	}
	if(d.totBlock > d.nowBlock){
		strBtn += "<li><span class='glyphicon glyphicon-chevron-right'></span></li>";
	}else{
		// 마지막블록일때 비활성
		
	}
	
			
	for(var i = 1; i<data.length; i++){
		var dd = data[i];
		strList += "<li class='list-group-item r_list-item' id='resListRow'>";
		strList += "<div class='row'>";
		strList += "<div class='col-xs-4 text-left' style=' '><span class='glyphicon glyphicon-file' aria-hidden='true'></span>" + dd.resName + "</div>";
		strList += "<div class='col-xs-3' style=''>" + dd.resLocation + "</div>";
		strList += "<div class='col-xs-2' style=''>" + dd.resScore + "</div>";
		strList += "<div class='col-xs-2' style=''>" + dd.resHit + "</div>";
		strList += "<input type='hidden' id='resSerial' name='resSerial' value='" + dd.resSerial + "'>";
		strList += "</div>";
		strList += "</li>";
	}
	list.html(strList);
	btn.html(strBtn);
	$('#restaurantList #resListRow').click(resView);
}

function moveTop(){
	location.href = "#";
}