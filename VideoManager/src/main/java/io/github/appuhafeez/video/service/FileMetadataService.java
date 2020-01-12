package io.github.appuhafeez.video.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.github.appuhafeez.video.bo.FileUploadRequest;
import io.github.appuhafeez.video.bo.SearchResponse;
import io.github.appuhafeez.video.entity.Comments;
import io.github.appuhafeez.video.entity.FileMetaData;
import io.github.appuhafeez.video.enums.SearchCriteria;
import io.github.appuhafeez.video.repository.FileMetadataRepo;

@Service
public class FileMetadataService {

	@Autowired
	private FileMetadataRepo repo;
	
	public boolean storeFileMetadata(FileUploadRequest request, String id, MultipartFile thumbnail) {
		try {
			FileMetaData data = new FileMetaData();
			data.setDescription(request.getDescription());
			data.setHeading(request.getHeading());
			data.setId(id);
			data.setHashtags(request.getHashtags());
			data.setThumbail(thumbnail.getBytes());
			data.setUploadedDate(new Date());
			repo.save(data);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<SearchResponse> searchFiles(String searchTag, String startIndex, String count){
		int start =  Integer.parseInt(startIndex);
		int countInt =  Integer.parseInt(count);
		List<FileMetaData> dataHeading = repo.searchList(searchTag,start, countInt,SearchCriteria.HEADING);
		int req = countInt-dataHeading.size();
		if(req!=0 && req!=countInt) {
			dataHeading.addAll(repo.searchList(searchTag, 0 , req, SearchCriteria.HASHTAGS));
		}else if(req !=0) {
			dataHeading.addAll(repo.searchList(searchTag, start - repo.getCount(searchTag, SearchCriteria.HEADING), req, SearchCriteria.HASHTAGS));
		}
		req = countInt - dataHeading.size();
		if(req!=0 && req!=countInt) {
			dataHeading.addAll(repo.searchList(searchTag, 0 , req, SearchCriteria.DESCRIPTION));
		}else if(req !=0) {
			dataHeading.addAll(repo.searchList(searchTag, start - (repo.getCount(searchTag, SearchCriteria.HEADING)+repo.getCount(searchTag, SearchCriteria.HASHTAGS)), req, SearchCriteria.DESCRIPTION));
		}
		return convertToResponse(dataHeading);
	}
	
	private List<SearchResponse> convertToResponse(List<FileMetaData> data){
		List<SearchResponse> response = new ArrayList<>();
		for(FileMetaData temp: data) {
			SearchResponse resp = new SearchResponse();
			resp.setDesciption(temp.getDescription());
			resp.setThumbnail(temp.getThumbail());
			resp.setHeading(temp.getHeading());
			resp.setId(temp.getId());
			response.add(resp);
		}
		return response;
	}
	
	public boolean addComment(String id, String comment, String user) {
		try {
			FileMetaData data= repo.getFileMetadata(id);
			Comments commentObj = new Comments();
			commentObj.setComment(comment);
			commentObj.setUser(user);
			commentObj.setUserName(user);
			Set<Comments> comments = data.getComments();
			comments.add(commentObj);
			data.setComments(comments);
			repo.update(data);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
