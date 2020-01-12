package io.github.appuhafeez.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.appuhafeez.video.entity.FileStore;

@Repository
public interface FileStoreRepository extends JpaRepository<FileStore, String>{

	
}
