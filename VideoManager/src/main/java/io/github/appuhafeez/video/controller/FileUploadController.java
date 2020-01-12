package io.github.appuhafeez.video.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.github.appuhafeez.video.bo.FileUplaodReponse;
import io.github.appuhafeez.video.bo.FileUploadRequest;
import io.github.appuhafeez.video.entity.FileStore;
import io.github.appuhafeez.video.service.FileMetadataService;
import io.github.appuhafeez.video.service.FileUploadService;
import io.github.appuhafeez.video.service.MultipartFileSender;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadService fileStorageService;
	
	@Autowired
	private FileMetadataService metadataService;

	@PostMapping("/uploadVideo")
//	public FileUplaodReponse uploadFile(@RequestParam("video") MultipartFile file, @RequestParam("thumbnail") MultipartFile thumbnail) throws FileNotFoundException {
	public FileUplaodReponse uploadFile(@RequestParam("video") MultipartFile video, @RequestParam("thumbnail") MultipartFile thumbnail, 
			@RequestParam("hashtags") String hashtags, @RequestParam("heading") String heading,
			@RequestParam("description") String description) throws FileNotFoundException {

		FileStore fileName = fileStorageService.storeFile(video);
		FileUplaodReponse response = new FileUplaodReponse();
		response.setId(fileName.getId());
		response.setSize(video.getSize());
		FileUploadRequest request = new FileUploadRequest();
		request.setDescription(description);
		request.setHashtags(hashtags);
		request.setHeading(heading);
		
		metadataService.storeFileMetadata(request, response.getId(),thumbnail);
		return response;
	}
	
	@GetMapping(value="/video/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void downloadFile(@PathVariable String id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileStore databaseFile = fileStorageService.getFile(id);

	    MultipartFileSender.setBytesStatic(databaseFile.getData())
                .with(request)
                .with(response)
            .serveResource();
    }

}
