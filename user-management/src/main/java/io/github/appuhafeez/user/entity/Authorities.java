package io.github.appuhafeez.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="authorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Authorities {

	@Id
	private AuthoriteId authoriteId;

}
