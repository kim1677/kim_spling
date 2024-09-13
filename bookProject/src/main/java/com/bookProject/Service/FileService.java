package com.bookProject.Service;

import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class FileService {
	public String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uuid=UUID.randomUUID();
		String ext=originalName.substring(originalName.lastIndexOf("."));
		String saveName=uuid.toString()+ext;
		String fileUploadUrl=uploadPath+'/'+saveName;
		FileOutputStream fos=new FileOutputStream(fileUploadUrl);
		fos.write(fileData);
		fos.close();
		return saveName;
	}
}