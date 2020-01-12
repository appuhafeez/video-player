package io.github.appuhafeez.video.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.appuhafeez.video.bo.SearchResponse;
import io.github.appuhafeez.video.service.FileMetadataService;

@RestController
public class SearchAndCommentController {

	@Autowired
	private FileMetadataService metadataService;
	
	@RequestMapping("/search")
	public List<SearchResponse> searchMetadata(@RequestParam("searchTag") String searchTag, @RequestParam("startIndex") String index,
			@RequestParam("count") String count){
		return metadataService.searchFiles(searchTag, index, count);
	}
	
	@RequestMapping("/addcomment/{id}")
	public String addComment(@PathVariable String id, @RequestParam String comment) {
		if(metadataService.addComment(id, comment, "")) {
			return "success";
		}else {
			return "fail";
		}
	}
	
}
