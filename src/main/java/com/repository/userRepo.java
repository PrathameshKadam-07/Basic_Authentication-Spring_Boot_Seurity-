package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserBean;

@Repository
public interface userRepo extends JpaRepository<UserBean,Long>{
	Optional<UserBean> findbyusername(String username);
}
