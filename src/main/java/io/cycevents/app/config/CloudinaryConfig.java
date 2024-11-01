package io.cycevents.app.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(){
        Map config=new HashMap<>();
        config.put("cloud_name", "dn4lrl6xy");
        config.put("api_key", "316617278311164");
        config.put("api_secret", "Z8ZNSsvr1k2eSDEgG3gxgdUcdWg");
        config.put("secure", true);
        return new Cloudinary(config);
    }

}
