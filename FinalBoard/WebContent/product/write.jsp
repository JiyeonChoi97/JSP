<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="all">

	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<div class="box" id="contact">
					<h2>코로나19 상품 입력</h2>

					<form action="./product" method="post">
					<input type="hidden" name="sign" value="pWrite">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="firstname">Category</label>
									<select class="form-control" id="category" name="category">
										<option selected>선택하세요</option>
										<option value="handcleaner">손세정제</option>
										<option value="mask">마스크</option>
										<option value="thermometer">체온계</option>
									</select>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="lastname">Product Name</label> <input type="text"
										class="form-control" id="pname" name="pname">
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Writer</label> <input type="text"
										class="form-control" id="email" name="pwriter" value="${s_email }" readonly>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="subject">Image File</label> <input type="file"
										class="form-control" id="imgfile" name="imgfile">
								</div>
							</div>
							<div class="col-sm-12">
								<div class="form-group">
									<label for="message">Content</label>
									<textarea id="message" class="form-control" name="pcontent"></textarea>
								</div>
							</div>

							<div class="col-sm-12 text-center">
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-envelope-o"></i> Register
								</button>

							</div>
						</div>
						<!-- /.row -->
					</form>
				</div>
			</div>
		</div>
	</div>