package com.library.management.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.management.system.dao.AdminRepository;
import com.library.management.system.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public void save(Admin admin) {
		adminRepository.save(admin);

	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		adminRepository.deleteById(id);
	}

	@Override
	public Admin findById(Integer id) {
		Optional<Admin> result = adminRepository.findById(id);
		Admin admin = null;
		if (result.isPresent()) {
			admin = result.get();
		} else {
			throw new RuntimeException("Id didn't found : " + id);
		}
		return admin;
	}

}
