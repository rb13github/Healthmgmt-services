package com.healthmgmt.app.dao.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.healthmgmt.app.entity.v1.Productv1;

public interface ProductRepositoryv1 extends JpaRepository<Productv1, Long> {
	List<Productv1> findByIsActiveTrue();
}
