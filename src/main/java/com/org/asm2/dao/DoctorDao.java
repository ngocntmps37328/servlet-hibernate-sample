package com.org.asm2.dao;

import java.util.List;

import com.org.asm2.config.JpaConfig;
import com.org.asm2.model.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DoctorDao {

	public void save(Doctor entity) {
		EntityManager em = JpaConfig.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void update(Doctor entity) {
		EntityManager em = JpaConfig.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public Doctor findById(Integer id) {
		EntityManager em = JpaConfig.getEntityManager();
		try {
			return em.find(Doctor.class, id);
		} finally {
			em.close();
		}
	}

	public List<Doctor> findAll() {
		EntityManager em = JpaConfig.getEntityManager();
		try {
			// String jpql = "SELECT d FROM Doctor d ORDER BY d.firstName ASC,
			// d.salary DESC";
			String jpql = "SELECT d FROM Doctor d ORDER BY d.firstName ASC";
			return em.createQuery(jpql, Doctor.class).getResultList();
		} finally {
			em.close();
		}
	}

	public void deleteById(Integer id) {
		EntityManager em = JpaConfig.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			Doctor entity = em.find(Doctor.class, id);
			if (entity != null) {
				em.remove(entity);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
