package io.github.appuhafeez.video.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import io.github.appuhafeez.video.entity.FileStore;
import io.github.appuhafeez.video.repository.FileStoreRepository;

@Service
public class FileUploadService {

	@Autowired
    private FileStoreRepository dbFileRepository;

    public FileStore storeFile(MultipartFile file) throws FileNotFoundException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileNotFoundException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            FileStore dbFile = new FileStore();
            dbFile.setData(file.getBytes());
            dbFile.setContentType(file.getContentType());
            dbFile.setFileName(file.getName());
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileNotFoundException("Could not store file " + fileName + ". Please try again!");
        }
    }

    public FileStore getFile(String fileId) {
        return dbFileRepository.findById(fileId).get();
    }
    
}
