package com.example.toycommunity.repository;

import com.example.toycommunity.entity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetailsImpl, String> {



}
