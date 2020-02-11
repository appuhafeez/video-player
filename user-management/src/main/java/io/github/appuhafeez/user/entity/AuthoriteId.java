package io.github.appuhafeez.user.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class AuthoriteId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4621351983299063493L;

	@Column(name="username" , length = 256 , nullable = false )
	private String userName;
	
	@Column(name="authority" , length = 256 , nullable = false )
	private String authority;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
		AuthoriteId authoriteId = (AuthoriteId) o;
		return userName.equals(authoriteId.userName) &&
				authority.equals(authoriteId.authority);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userName,authority);
	}
}
