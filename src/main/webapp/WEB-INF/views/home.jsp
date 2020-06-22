<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false"%>
<html>
<head>
<link rel=" shortcut icon" href="resources//image/favicon.png">
<link rel="icon" href="resources/image/favicon.png">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>To Do List</title>
<style>
header .topBtn {
	color: #000000;
	border: 2px solid #000000;
}

header .insertBtn {
	color: #DF1763;
	border: 2px solid #DF1763;
}

.btn {
	display: inline-block;
	border-radius: 30px;
	padding: 20px 30px;
	font-weight: bold;
	text-decoration: none;
	color: white;
}

header nav {
	float: right;
	padding: 20px 10px;
}

header nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

header nav ul li {
	float: left;
	margin: 0 10px;
}

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}
</style>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><button class="btn topBtn" id="topBtn" type="button"
						style="background-color: white"><</button></li>
				<li>
					<button class="btn topBtn" id="topBtn" type="button"
						style="background-color: white">
						<fmt:formatDate value="${ date }" pattern="yyyy년 MM월 dd일" />
					</button>
				</li>
				<li><button class="btn topBtn" id="topBtn" type="button"
						style="background-color: white">></button></li>
				<li><button class="btn insertBtn" id="insertBtn" type="button"
						style="background-color: white">일정 등록</button></li>
			</ul>
		</nav>
	</header>

	<table class="">
		<thead>
			<tr>
				<th>일정명</th>
				<th>상세내용</th>
				<th>중요도</th>
				<th>시작일</th>
				<th>종료일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${ pList }">
				<tr>
					<td>${ p.pName }</td>
					<td>${ p.pDetail }</td>
					<td>${ p.pLevel }</td>
					<td>${ p.pStartDate }</td>
					<td>${ p.pEndDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Modal 내용 -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<p style="text-align: center;">일정등록</p>
			<form action="pInsert.do" method="POST">
				<span>일정명 </span> <input type="text" id="pName" name="pName"><br>
				<span>중요도 </span> <select id="pLevel" name="pLevel">
					<option value="A">매우 중요</option>
					<option value="B">중요</option>
					<option value="C">보통</option>
					<option value="D">중요하지 않음</option>
				</select><br> <span>상세 내용 </span> <input type="text" id="pDetail"
					name="pDetail"><br> <span>시작일 </span><input
					type="date" id="pStartDate" name="pStartDate"><br> <span>종료일
				</span><input type="date" id="pEndDate" name="pEndDate"><br>
				<br>
				<br>
				<button id="modalBtn" type="submit">등록</button>
				<button id="modalBtn" type="button">닫기</button>
			</form>
		</div>
	</div>



	<script type="text/javascript">
    $(document).ready(function(){
        $("#insertBtn").click(function(){
            $("#myModal").show();
        });
    });
        //팝업 Close 기능
        function close_pop(flag) {
             $('#myModal').hide();
        };
        
        $("#modalBtn").click(function(){
        	$('#myModal').hide();
        });
    </script>

</body>
</html>
