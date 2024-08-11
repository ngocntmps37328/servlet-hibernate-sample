package com.org.asm2.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.org.asm2.config.FileConfig;
import com.org.asm2.dao.DoctorDao;
import com.org.asm2.model.Doctor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/doctor")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DoctorDao doctorDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorController() {
		super();
		// TODO Auto-generated constructor stub
		doctorDao = new DoctorDao();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action == null) {
			action = "list";
		}

		switch (action) {
		case "create":
			if (req.getMethod().equalsIgnoreCase("POST")) {
				createDoctor(req, resp);
			} else {
				showCreateForm(req, resp);
			}
			break;
		case "edit":
			if (req.getMethod().equalsIgnoreCase("POST")) {
				updateDoctor(req, resp);
			} else {
				showFormEditDoctor(req, resp);
			}
			break;
		case "delete":
			deleteDoctor(req, resp);
			break;
		default:
			listDoctor(req, resp);
			break;
		}
	}

	private void listDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Doctor> doctorList = doctorDao.findAll();
		req.setAttribute("doctorList", doctorList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/doctor.jsp");
		dispatcher.forward(req, resp);
	}

	private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/doctor-detail.jsp");
		dispatcher.forward(req, resp);
	}

	private void createDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String lastName = req.getParameter("lastName");
		String firstName = req.getParameter("firstName");
		LocalDate hireDate = parseDate(req.getParameter("hireDate"));
		Float salary = Float.valueOf(req.getParameter("salary"));
		Boolean sex = Boolean.valueOf(req.getParameter("sex"));
		Part filePart = req.getPart("img");
		String filePath = null;
		if (filePart.getSize() != 0) {
			filePath = FileConfig.updateFiletoCreate(filePart, req);
		}

		Doctor doctor = new Doctor();
		doctor.setLastName(lastName);
		doctor.setFirstName(firstName);
		doctor.setHireDate(hireDate);
		doctor.setSalary(salary);
		doctor.setSex(sex);

		doctor.setImg(filePath);

		doctorDao.save(doctor);
		req.setAttribute("message", "Create success !!!");
		resp.sendRedirect("doctor?action=list");
	}

	private LocalDate parseDate(String date) {
		if (date == null || date.isEmpty()) {
			return null;
		}
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	private void deleteDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		try {
			doctorDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("doctor?action=list");
	}

	private void showFormEditDoctor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Doctor doctor = doctorDao.findById(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/doctor-detail.jsp");
		req.setAttribute("doctor", doctor);
		dispatcher.forward(req, resp);
	}

	private void updateDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");

		String lastName = req.getParameter("lastName");
		String firstName = req.getParameter("firstName");
		LocalDate hireDate = parseDate(req.getParameter("hireDate"));
		Float salary = Float.valueOf(req.getParameter("salary"));
		Boolean sex = Boolean.valueOf(req.getParameter("sex"));
		Part filePart = req.getPart("img");
		String filePath = null;
		if (filePart.getSize() != 0) {
			filePath = FileConfig.updateFiletoCreate(filePart, req);
		}

		Doctor doctor = doctorDao.findById(Integer.valueOf(idStr));
		doctor.setLastName(lastName);
		doctor.setFirstName(firstName);
		doctor.setHireDate(hireDate);
		doctor.setSalary(salary);
		doctor.setSex(sex);
		if (filePath != null) {
			doctor.setImg(filePath);
		}

		doctorDao.update(doctor);
		req.setAttribute("message", "Update success !!!");
		resp.sendRedirect("doctor?action=list");
	}
}
