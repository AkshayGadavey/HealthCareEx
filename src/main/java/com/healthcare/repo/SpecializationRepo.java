package com.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entity.specialization.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Long>{

}
