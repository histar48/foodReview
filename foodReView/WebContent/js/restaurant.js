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

function resView(ddd){
	
	$('#contentTop').load('restaurant/view.jsp?serial=' + ddd.serial.value);
	$('#contentMid').load('review/list.jsp');
	$('#aMenu').load('restaurant/hitList_sub.jsp');
	
}