package com.unac.salescarpremium.dao;

import com.unac.salescarpremium.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}