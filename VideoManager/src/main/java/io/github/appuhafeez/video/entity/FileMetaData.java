package io.github.appuhafeez.video.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="file_meta_data")
@Data
public class FileMetaData {

	@Id
	@Column(name="id",length=40)
	private String id;
	
	@Lob
	private byte[] thumbail;
	
	@Column(name="hash_tags")
	private String hashtags;
	
	private Date uploadedDate;
	
	private String description;
	
	private String heading;
	
	private String uploadedBy;
	
    @OneToMany(mappedBy="data", fetch = FetchType.LAZY)
    private Set<Comments> comments;
	
}
