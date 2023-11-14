package com.library.management.system.service;

import java.util.List;

import com.library.management.system.entity.Admin;

public interface AdminService {
	void save(Admin admin);
	
	List<Admin> findAll();
	
	void deleteById(Integer id);
	
	Admin findById(Integer id);

}
