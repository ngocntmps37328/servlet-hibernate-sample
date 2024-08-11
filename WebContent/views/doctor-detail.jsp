<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctor Profile</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.profile-card {
	border: 1px solid #ddd;
	border-radius: 10px;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.profile-avatar {
	width: 150px;
	height: 150px;
	border-radius: 50%;
	background-color: #f0f0f0;
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 0 auto 20px;
	position: relative;
}

.profile-avatar img {
	width: 100%;
	border-radius: 50%;
}

.profile-avatar input[type="file"] {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	opacity: 0;
	cursor: pointer;
}

.info-group {
	margin-bottom: 15px;
}

.info-group label {
	font-weight: bold;
}

.profile-header {
	font-weight: bold;
	margin-bottom: 15px;
	font-size: 1.2rem;
}
</style>
</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">${message}</div>
	</c:if>
	<div class="container mt-5">
		<h2>${doctor == null ? "Create Doctor" : "Edit Doctor"}</h2>
		<form class="teacherform"
			action="doctor?action=${doctor == null ? 'create' : 'edit'}"
			method="post" enctype="multipart/form-data">
			<c:if test="${doctor != null}">
				<input type="hidden" name="id" value="${doctor.id}">
			</c:if>
			<div class="row">
				<div class="col-md-4">
					<div class="profile-card text-center">
						<div class="profile-avatar">
							<img id="avatar"
								src="${pageContext.request.contextPath}/${doctor != null && doctor.img != null ? doctor.img : 'https://via.placeholder.com/150'}"
								alt="Avatar"> <input type="file" id="avatarInput"
								name="img" accept="image/*">
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="profile-card">
						<div class="profile-header">Infor Doctor</div>
						<div class="form-group row">
							<label for="hoTen" class="col-sm-4 col-form-label">Last
								Name:</label>
							<div class="col-sm-8">
								<input type="text" required="required" class="form-control"
									id="lastName" name="lastName"
									value="${doctor != null ? doctor.lastName : ''}">
							</div>
						</div>
						<div class="form-group row">
							<label for="emailCaNhan" class="col-sm-4 col-form-label">First
								Name:</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" required="required"
									id="lastName" name="firstName"
									value="${doctor != null ? doctor.firstName : ''}">
							</div>
						</div>
						<div class="form-group row">
							<label for="ngaySinh" class="col-sm-4 col-form-label">Hire
								Date (dd/MM/yyyy):</label>
							<div class="col-sm-8">
								<input type="date" class="form-control" required="required"
									id="hireDate" name="hireDate"
									value="${doctor != null ? doctor.hireDate : ''}">
							</div>
						</div>
						<div class="form-group row">
							<label for="soDienThoai" class="col-sm-4 col-form-label">Salary:</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" required="required"
									id="salary" name="salary"
									value="${doctor != null ? doctor.salary : ''}">
							</div>
						</div>
						<div class="form-group row">
							<label for="sex" class="col-sm-4 col-form-label">Sex:</label>
							<div class="col-sm-8">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="sex"
										id="male" value="true"
										${doctor != null && doctor.sex ? 'checked' : ''} required>
									<label class="form-check-label" for="male"> Male </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="sex"
										id="female" value="false"
										${doctor != null && !doctor.sex ? 'checked' : ''}> <label
										class="form-check-label" for="female"> Female </label>
								</div>
							</div>
						</div>
						<div class="form-group form-button">
							<input type="submit" name="updateTeacherButton"
								class="form-submit btn btn-primary"
								value="${doctor == null ? 'Create' : 'Edit'} Doctor" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
    document.getElementById('avatarInput').onchange = function (event) {
        const [file] = event.target.files;
        if (file) {
            document.getElementById('avatar').src = URL.createObjectURL(file);
        }
    };

    /* function validateForm() {
        const fileInput = document.getElementById('avatarInput');
        if (fileInput.files.length === 0) {
            alert('No file selected. Please choose an image to upload.');
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }   */  
    
</script>
</body>
</html>
