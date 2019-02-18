/**
 * 
 */

$('.tabs .tab').click(function(){
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
$('.container .bg').mousemove(function(e){
    var amountMovedX = (e.pageX * -1 / 30);
    var amountMovedY = (e.pageY * -1 / 9);
    $(this).css('background-position', amountMovedX + 'px ' + amountMovedY + 'px');
});



/*
 * 회원가입
 */

function mainInsert(){
	chk = false;
	var frm = document.userInfo;
	var id = document.getElementById('id');
	
	id.focus();
	

	var items = document.getElementsByClassName('join-inpt');
	for (var i = 0; i < items.length; i++) {
		items[i].onkeyup = function(ev) {
			if (ev.keyCode == 13) {
				var obj = null;
				switch (ev.srcElement.name) {
				case 'uid':
					obj = frm.pwd;
					break;
				case 'pwd':
					obj = frm.pwdChk;
					break;
				case 'pwdChk':
					obj = frm.unick;
					break;
				case 'unick':
					obj = frm.email;
					break;
				case 'email':
					obj = frm.phone;
					break;
				case 'phone':
					obj = frm.postal;
					break;
				}
				obj.focus();
				obj.select();
			}
		}

	}
	//우편번호 검색
	frm.btnpostal.onclick = function() {
		new daum.Postcode({
			oncomplete : function(data) {
				frm.postal.value = data.zonecode;
				frm.address.value = data.address;
			}
		}).open();
	}
	
}

function idchk(){
	var id = $('#id').val();
	$.ajax({
		type : 'post',
		url : './abc.mb',
		data : {id: id},
		success : function(result){
			if(result == 1){
				
			}
		}
	});
}
