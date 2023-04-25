package com.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.specialization.Specialization;
import com.healthcare.repo.SpecializationRepo;
import com.healthcare.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepo repo;

	@Override
	public Long saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	@Override
	public Specialization getOneSpecializations(Long id) {
		Optional<Specialization> optional = repo.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else
			return null;

	}

	@Override
	public List<Specialization> getAllSpecializations() {
		return repo.findAll();
	}

	@Override
	public void updateSpecialization(Specialization spec) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSpecialization(Long id) {
		repo.deleteById(id);

	}

}
