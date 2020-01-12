package io.github.appuhafeez.video.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="comments")
@Data
public class Comments {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId;
	
	@ManyToOne
    @JoinColumn(name="comments", nullable=false)
    private FileMetaData data;
	
	private String user;
	private String userName;
	private String comment;
	
}
