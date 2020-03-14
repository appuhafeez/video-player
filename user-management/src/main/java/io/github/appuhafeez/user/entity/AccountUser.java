package io.github.appuhafeez.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accountuser")
@Data
@NoArgsConstructor
public class AccountUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users userId;
	
	@Email
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@Lob
	private byte[] avatar;
	
	private String fileName;
	
	private String contentType;
}
