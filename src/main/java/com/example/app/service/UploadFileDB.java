package com.example.app.service;

import com.example.core.AbstractEntity;
import com.example.core.StandardUploadFile;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadFileDB {
    public String fileDB;

    public static String encodeImagem(byte[] imageByteArray) {
        return Base64.encodeBase64String(imageByteArray);
    }

    public String gravarImagemBase64(MultipartFile file) {
        try {
            fileDB = encodeImagem(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDB;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public String gravaImagemBase64Service(MultipartFile file, StandardUploadFile standardUploadFile, AbstractEntity abstractEntity) {

        if (gravarImagemBase64(file).isEmpty()) standardUploadFile.save(abstractEntity);
        else {
            fileDB = "data:image/png;base64," + fileDB;
            standardUploadFile.save(abstractEntity, fileDB);
        }
        return gravarImagemBase64(file);
    }
}
