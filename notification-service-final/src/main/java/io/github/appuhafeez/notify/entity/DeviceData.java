package io.github.appuhafeez.notify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.appuhafeez.notify.enums.DeviceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="device_data")
public class DeviceData {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	private String userName;
	
	@Column(name="device_id", length=300)
	private String deviceId;
	
	@Column(name="device_type", nullable=false)
	private DeviceType deviceType;

}
