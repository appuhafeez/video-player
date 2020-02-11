package io.github.appuhafeez.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="username", unique = true , length = 256 )
	@NotNull
	private String userName;
	
	@Column(name="password", length = 256 )
	@NotNull
	private String password;
	
	@Column(name="enabled", columnDefinition = "TINYINT(1)")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@NotNull
	private boolean enabled = false;
	
	@OneToOne(mappedBy = "userId", cascade = CascadeType.ALL)
	private AccountUser user;
}
