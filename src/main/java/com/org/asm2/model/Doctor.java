package com.org.asm2.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// @Column(name = "LastName", length = 70, nullable = false)
	private String lastName;

	// @Column(name = "FirstName", length = 50, nullable = false)
	private String firstName;

	// @Column(name = "HireDate")
	private LocalDate hireDate;

	// @Column(name = "Salary", length = 53, nullable = false)
	private Float salary;

	// @Column(name = "Img", length = 245, nullable = false)
	private String img;
	
//	 @Column(name = "Sex", nullable = false)
	private Boolean sex;

	public Doctor() {
		super();
	}

	public Doctor(Integer id, String lastName, String firstName, LocalDate hireDate, Float salary, String img,
			Boolean sex) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.hireDate = hireDate;
		this.salary = salary;
		this.img = img;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", hireDate=" + hireDate
				+ ", salary=" + salary + ", img=" + img + ", sex=" + sex + "]";
	}

	
}
