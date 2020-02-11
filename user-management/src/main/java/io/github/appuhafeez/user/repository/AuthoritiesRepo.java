package io.github.appuhafeez.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.appuhafeez.user.entity.AuthoriteId;
import io.github.appuhafeez.user.entity.Authorities;

public interface AuthoritiesRepo extends JpaRepository<Authorities, AuthoriteId> {

}
