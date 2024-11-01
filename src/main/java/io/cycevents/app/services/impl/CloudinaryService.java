package io.cycevents.app.services.impl;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {
    private final Cloudinary cloudinary;
    public String uploadImage(MultipartFile multipartFile){
        try {
            Map data= (Map) this.cloudinary.uploader().upload(multipartFile.getBytes(), Map.of());
            return (String) data.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
