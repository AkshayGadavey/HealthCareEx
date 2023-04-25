package com.healthcare.service;

import java.util.List;

import com.healthcare.entity.specialization.Specialization;

public interface ISpecializationService {
	public Long saveSpecialization(Specialization spec);

	public Specialization getOneSpecializations(Long id);

	public List<Specialization> getAllSpecializations();

	public void updateSpecialization(Specialization spec);

	public void removeSpecialization(Long id);

}
