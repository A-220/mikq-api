package com.qst.mikq;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.apache.tomcat.jni.Library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Mikq API", version = "1.0", description = "Docs"))
public class MikqApplication {
	public static void main(String[] args) {
		SpringApplication.run(MikqApplication.class, args);
	}

}
