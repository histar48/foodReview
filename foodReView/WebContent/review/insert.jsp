<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<script>

function revinsert(){	
	
	/*$('#btnReviewInsert').click(function(){*/
		$('#revpSerial').val("1");		
		
		var frm = $('#reviewInsert')[0];
		
		
		var data = new FormData(frm);
		
	
		$.ajax({
			type : 'post',
			data : data,
			dataType : 'html',
			processData : false,
			contentType: false,
			url : 'insertR.rev',
			success : function(data, status){
				alert(data)
			},
			error : function(xhr, status, error){
				alert(status);
			}
			
		});

		
	/*});*/
	
	
	
}

</script>

<div id="reviewInsertWrap">
	<div id="revInsertWrap">
			<form id="reviewInsert" name="reviewInsert" method="post" enctype="multipart/form-data">
			  <fieldset>
			    <legend>후기 &amp; 평점</legend>
			    <div class="form-group row">
			      <label for="revId" class="col-sm-2 col-form-label">ID</label>
			      <div class="col-sm-10">
			        <input type="text" readonly class="form-control-plaintext" id="revId"  name="revId" value="test1">
			      </div>
			    </div>

			    <div class="form-group">
			      <label for="revScore">평점</label>
			      <select class="form-control" id="revScore" name="revScore">
			        <option>0</option>
			        <option>1</option>
			        <option>2</option>
			        <option>3</option>
			        <option>4</option>
			        <option>5</option>
			        <option>6</option>
			        <option>7</option>
			        <option>8</option>
			        <option>9</option>
			        <option>10</option>
			      </select>
			    </div>

			    <div class="form-group">
			      <label for="revContent">후기</label>
			      <textarea class="form-control" id="revContent" name="revContent" rows="3"></textarea>
			    </div>
			    <div class="form-group">
			      <label for="revInputFile">인증사진</label>
			      <input type="file" class="form-control-file" id="revInputFile" name="revInputFile" aria-describedby="fileHelp">
			      <small id="fileHelp" class="form-text text-muted">인증사진을 선택 해주세요.</small>
			    </div>
			    <button type="button" id="btnReviewInsert" name="btnReviewInsert" class="btn btn-primary" onclick="revinsert()">입력</button>
			    <input type="hidden" id="revpSerial" name="revpSerial" />
			  </fieldset>
			</form> 
			<hr>
			   	
	</div>
</div>
