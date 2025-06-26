<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" />
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class='wrapper'>
		<header>
			<h3 style="fontWeight: bolder">KH C CLASS</h3>
		</header>
		<nav>
			<a id='list'>게시판</a> <a id='insert'>등록</a>
		</nav>
		<div class='outer'>
			
		</div>
	</div>
	<script>
		$(function() {
			$("#list").click(function() {
				$.ajax({
					url: "/ajax/board/list",
					success: function(data) {
						//console.log(data);
						$(".outer").html(data);
					},
					error: function(xhr, status, err) {
						console.log(xhr, status, err);
					}
				});
			});
			
			$(".outer").on("click", "table tr", function() {
				// console.log($(this).find("td"));
				// console.log($(this).find("td").eq(1).html());
				
				$.ajax({
					url: "/ajax/board/view",
					data: {
						boardNo: $(this).find("td").eq(0).html()
					},
					success: function(data) {
						//console.log(data);
						
						$(".outer").html(data);
					},
					error: function(xhr, status, err) {
						console.log(xhr, status, err);
					}
				});
			});
			
			$("#insert").click(function() {
				$.ajax({
					url: "/ajax/board/insert",
					success: function(data) {
						$(".outer").html(data);
					},
					error: function(xhr, status, err) {
						console.log(xhr, status, err);
					}
				});
			});
		});
	</script>
</body>
</html>