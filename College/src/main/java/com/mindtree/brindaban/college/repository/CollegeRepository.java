package com.mindtree.brindaban.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.brindaban.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

	College findById(long col_id);
}