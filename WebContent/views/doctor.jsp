<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctor List</title>
<base href="${pageContext.request.contextPath}/">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.table th, .table td {
	vertical-align: middle !important;
}

.table img {
	border-radius: 50%;
}

.action-buttons {
	display: flex;
	flex-direction: column;
}

.action-buttons .btn {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<div class="container m-2">
		<h2>List of Doctors</h2>
		<c:if test="${not empty message}">
			<div class="alert alert-danger">${message}</div>
		</c:if>
		<p>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/doctor?action=create">Add
				Doctors</a>
		</p>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>STT</th>
					<th>Photo</th>
					<th>ID Doctor</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Hire Date</th>
					<th>Salary</th>
					<th>Sex</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="doctor" items="${doctorList}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td width="100"><img
							src="${pageContext.request.contextPath}/${doctor.img}"
							alt="Photo" width="80" height="80" /></td>
						<td>${doctor.id}</td>
						<td>${doctor.lastName}</td>
						<td>${doctor.firstName}</td>
						<td>${doctor.hireDate}</td>
						<td>${doctor.salary}</td>
						<td>${doctor.sex != null ? (doctor.sex ? 'Male' : 'Female') : 'Not Specified'}</td>
						<td>
							<div class="action-buttons">
								<a class="btn btn-primary btn-sm"
									href="doctor?action=edit&id=${doctor.id}">Edit</a> <a
									class="btn btn-danger btn-sm" href="javascript:void(0);"
									onclick="if(confirm('Are you sure you want to delete this doctor?')) { window.location.href='doctor?action=delete&id=${doctor.id}'; }">
									Delete </a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
