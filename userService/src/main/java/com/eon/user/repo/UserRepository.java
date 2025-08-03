package com.eon.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eon.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
