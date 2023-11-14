package com.library.management.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.system.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
