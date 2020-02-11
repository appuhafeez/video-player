package io.github.appuhafeez.user.bo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBo {

	private MultipartFile avatar;
	
	private String email;
	
	private String name;
	
	private String password;
	
	private String username;
}
