<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.hit_list {
  position: relative;
  width: 100%;
  max-width: 400px;
  margin-bottom: 10px;
}

.hit_list img {
  width: 100px;
  height: auto;
}

.hit_list .btn {
  position: absolute;
  bottom: -16px;
  right: 55px;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  background-color: #555;
  color: white;
  font-size: 16px;
/*   padding: 12px 24px; */
  border: none;
/*   cursor: pointer; */
  border-radius: 5px;
  text-align: center;
}

.hit_list .btn:hover {
  background-color: black;
}
</style>
<div id='subHitList'>
	<div id='subhitListTitle'>
		<h3>인기 순위</h3>
	</div>
	<div class="hit_list">
	  <img src="http://placehold.it/80x80" alt="Snow">
	  <button class="btn">1</button>
	</div>	
	<div class="hit_list">
	  <img src="http://placehold.it/80x80" alt="Snow">
	  <button class="btn">2</button>
	</div>	
	<div class="hit_list">
	  <img src="http://placehold.it/80x80" alt="Snow">
	  <button class="btn">3</button>
	</div>	
	<div class="hit_list">
	  <img src="http://placehold.it/80x80" alt="Snow">
	  <button class="btn">4</button>
	</div>	
	<div class="hit_list">
	  <img src="http://placehold.it/80x80" alt="Snow">
	  <button class="btn">5</button>
	</div>	

</div>