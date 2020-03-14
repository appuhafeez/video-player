package io.github.appuhafeez.notify.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.appuhafeez.notify.enums.VisibilityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="notification_data")
public class NotificationData {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	private String heading;
	
	private String messageContent;
	
	private VisibilityType visibilityType;
	
	private String username;
	
	private String specialNote;
	
	private Date timeStamp;

}
