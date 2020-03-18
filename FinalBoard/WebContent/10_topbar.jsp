<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="s_nick" value="${nick }" scope="session" />
<c:set var="s_email" scope="session">${email }</c:set>
<c:set var="s_grade" value="${grade }" scope="session" />
<!-- *** TOPBAR ***
 _________________________________________________________ -->
<div id="top">

	<c:choose>
		<c:when test="${s_email ne null && s_email ne ''}">
			<!-- 로그인이 되어 있을때 -->
			<div class="container">
				<div class="col-md-6 offer" data-animate="fadeInDown">
					<a href="#" class="btn btn-success btn-sm"
						data-animate-hover="shake">Offer of the day</a> <a href="#">Get
						flat 35% off on orders over $50!</a>
				</div>
				<div class="col-md-6" data-animate="fadeInDown">
					<ul class="menu">
						<li style="color:#ffffff;">${s_email }</li>
						<li style="color:#ffffff;">( ${s_nick } )</li>
						<li style="color:#ffffff;">
							<c:choose>
								<c:when test="${s_grade eq '0' }">일반회원</c:when>
								<c:when test="${s_grade eq '5' }">우수회원</c:when>
								<c:when test="${s_grade eq '10' }">골드회원</c:when>
								<c:when test="${s_grade eq '20' }">VIP회원</c:when>
								<c:when test="${s_grade eq '99' }">관리자</c:when>
							</c:choose>
						</li>
						<li><a href="./member?sign=logout">로그아웃</a></li>
					</ul>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<!-- 로그인이 안되어 있을때 -->
			<div class="container">
				<div class="col-md-6 offer" data-animate="fadeInDown">
					<a href="#" class="btn btn-success btn-sm"
						data-animate-hover="shake">Offer of the day</a> <a href="#">Get
						flat 35% off on orders over $50!</a>
				</div>
				<div class="col-md-6" data-animate="fadeInDown">
					<ul class="menu">
						<li><a href="#" data-toggle="modal"
							data-target="#login-modal">Login</a></li>
						<li><a href="#" data-toggle="modal" data-target="#reg-modal">Register</a>
						</li>
						<li><a href="contact.html">Contact</a></li>
						<li><a href="#">Recently viewed</a></li>
					</ul>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true">
		<div class="modal-dialog modal-sm">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="Login">Customer login</h4>
				</div>
				<div class="modal-body">
					<form action="./member" method="post">
						<input type="hidden" name="sign" value="login">
						<div class="form-group">
							<input type="text" class="form-control" id="email-modal"
								placeholder="email" name="email">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password-modal"
								placeholder="password" name="pwd">
						</div>

						<p class="text-center">
							<button class="btn btn-primary">
								<i class="fa fa-sign-in"></i> Log in
							</button>
						</p>

					</form>

					<p class="text-center text-muted">Not registered yet?</p>
					<p class="text-center text-muted">
						<a href="register.html"><strong>Register now</strong></a>! It is
						easy and done in 1&nbsp;minute and gives you access to special
						discounts and much more!
					</p>

				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="reg-modal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true">
		<div class="modal-dialog modal-sm">

			<div class="modal-content">
				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="Login">Customer Register</h4>
				</div>
				<div class="modal-body">
					<form action="./member" method="post">
						<input type="hidden" name="sign" value="regist">
						<div class="form-group">
							<input type="text" class="form-control" id="email"
								placeholder="email" name="email"><br>
								<span id="isOk"></span>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password-modal"
								placeholder="password" name="pwd">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="nick-modal"
								placeholder="nickname" name="nick">
						</div>

						<p class="text-center">
							<button class="btn btn-primary" type="submit">
								<i class="fa fa-sign-in"></i> Register
							</button>
						</p>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- *** TOP BAR END *** -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$("#email").blur(function(){
		$.ajax({
			type: "POST",
			url: "./member",
			data: {"inemail": $("#email").val(), "sign" : "idCheck"},
			success: function(datas){
				console.log(datas);
				if(datas=='1'){
					$("#isOk").html("사용할 수 없는 이메일!").css("color", "#f00");
					$("#email").focus();
					$("#email").val("");
				} else{
					$("#isOk").html("사용할 수 있는 이메일!").css("color", "#0f0");
				}
			}		
		});
	});
</script>





