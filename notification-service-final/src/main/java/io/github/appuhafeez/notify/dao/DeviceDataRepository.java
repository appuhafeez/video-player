package io.github.appuhafeez.notify.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.appuhafeez.notify.entity.DeviceData;
import io.github.appuhafeez.notify.enums.DeviceType;

@Repository
public interface DeviceDataRepository extends JpaRepository<DeviceData, Integer>{

	public List<DeviceData> findAllByDeviceType(DeviceType deviceType);
	
	public DeviceData findByDeviceTypeAndUserName(DeviceType deviceType,String userName);
	
}
