package io.github.appuhafeez.video.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.github.appuhafeez.video.entity.FileMetaData;
import io.github.appuhafeez.video.enums.SearchCriteria;

@Repository
public class FileMetadataRepo{

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save(FileMetaData data) {
		entityManager.persist(data);
	}
	
	public List<FileMetaData> searchList(String searchString, int startIndex, int endIndex, SearchCriteria criteria){
		Query query = getSearchQuery(criteria);
		query.setParameter("searchString","%"+searchString+"%");
		query.setFirstResult(startIndex);
		query.setMaxResults(endIndex);
		return query.getResultList();
	}

	private Query getSearchQuery(SearchCriteria criteria) {
		Query query = null;
		if(criteria.equals(SearchCriteria.HEADING)) {
			query = entityManager.createQuery("from FileMetaData fd where fd.heading LIKE :searchString");
		}else if(criteria.equals(SearchCriteria.DESCRIPTION)) {
			query = entityManager.createQuery("from FileMetaData fd where fd.description LIKE :searchString");
		}else if(criteria.equals(SearchCriteria.HASHTAGS)) {
			query = entityManager.createQuery("from FileMetaData fd where fd.hashtags LIKE :searchString");
		}
		return query;
	}
	public int getCount(String searchString, SearchCriteria criteria) {
		return getAllData(searchString, criteria).size();
	}
	public List<FileMetaData> getAllData(String searchString, SearchCriteria criteria){
		Query query = getSearchQuery(criteria);
		query.setParameter("searchString","%"+searchString+"%");
		return query.getResultList();
	}
	
	public FileMetaData getFileMetadata(String id) {
		return entityManager.find(FileMetaData.class, id);
	}
	
	public void update(FileMetaData data) {
		entityManager.merge(data);
	}
}
