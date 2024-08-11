package com.org.asm2;

import com.org.asm2.config.JpaConfig;

public class Main {

	public static void main(String[] args) {
		JpaConfig.getEntityManager();
		
//		DoctorDao doctorDao = new DoctorDao();
//		List<Doctor> doctors = doctorDao.findAll();
//		doctors.forEach(t -> System.out.println(t));
	}
}
