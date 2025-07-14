//-----------------------------------------------------------------------------------------------------------
// Yazan:Eylül Aleyna Sahin
// Tarih:07/01/2021
// Açıklama: Bu sınıf kullanıcı programın main sınıfıdır, maven projesi buradan çalışmaya başlamaktadır.
// Not: src/main/resources altında bulunan 'application.properties' dosyasında Spring boot ve MongoDB 
// arasındaki bağlantı kurulması için gerekli bilgiler eklenmiştir.
//-----------------------------------------------------------------------------------------------------------
package com.korona.rest.webservices.restfulkorona;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class RestfulKoronaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulKoronaApplication.class, args);
	}

}
