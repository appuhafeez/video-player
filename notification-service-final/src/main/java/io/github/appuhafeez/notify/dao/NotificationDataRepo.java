package io.github.appuhafeez.notify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.appuhafeez.notify.entity.NotificationData;

@Repository
public interface NotificationDataRepo extends JpaRepository<NotificationData, Integer>{

	public List<NotificationData> findAllByUsernameInOrderByTimeStamp(String userName);
	
}
