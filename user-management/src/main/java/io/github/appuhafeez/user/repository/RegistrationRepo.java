package io.github.appuhafeez.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.appuhafeez.user.entity.Users;

public interface RegistrationRepo extends JpaRepository<Users, Integer> {

}
