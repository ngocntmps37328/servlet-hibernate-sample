<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
<
style>body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-size: cover;
	background-position: center;
}

.login-container {
	background: rgba(255, 255, 255, 0.9);
	padding: 2rem;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	width: 100%;
}

.form-control:focus {
	box-shadow: none;
	border-color: #4CAF50;
}

.btn-primary {
	background-color: #4CAF50;
	border-color: #4CAF50;
}

.btn-primary:hover {
	background-color: #45A049;
	border-color: #45A049;
}

.forgot-password {
	margin-top: 10px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="login-container">
		<h2 class="text-center">Đăng Nhập</h2>
		<c:if test="${not empty message}">
			<div class="alert alert-danger">${message}</div>
		</c:if>
		<form method="post"
			action="${pageContext.request.contextPath}/sign-in">
			<div class="mb-3">
				<label for="username" class="form-label">Tên đăng nhập</label> <input
					type="text" class="form-control" id="username" name="username"
					placeholder="Tên đăng nhập" required>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Mật khẩu</label> <input
					type="password" class="form-control" id="password" name="password"
					placeholder="Mật khẩu" required>
			</div>
			<button type="submit" class="btn btn-primary w-100">Đăng
				Nhập</button>
		</form>
		<div class="forgot-password">
			<a href="#">Quên mật khẩu?</a>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
