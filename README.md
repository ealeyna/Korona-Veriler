# Korona-Verileri / Corona Data

## Projenin Amacı / Project Objective  
- Açık kaynak haberlerden text halinde bilgilerin anahtar vaka sayıları, ölüm ve iyileşen sayılarını toplayıp bir ekranda grafik olarak gösteriminin yapılması ve yeni veri sisteme eklendikçe grafiğin online olarak değişmesi amaçlanmaktadır.  
- The goal is to collect key data such as confirmed cases, deaths, and recoveries from open-source news content in text format, visualize them on a chart, and update the chart live as new data is added to the system.

---

## Ön Koşullar / Prerequisites
- MongoDB  
- Spring Boot Maven Project  
- ReactJs  
- NodeJs  
- NPM  

---

## Kurulumlar / Installations
- [MongoDB](https://www.mongodb.com/try/download/community)  versiyon 4.4.3 kurulumu için linkten bilgi alabilirsiniz.  
  - MongoDB'ye MongoShell'den `use KoronaDB` komutu girilerek 'KoronaDB' adında bir veritabanı oluşturulmuştur. `db.createCollection('koronaVerileri')` komutuyla 'KoronaDB' veritabanına yeni bir collection eklenmiştir.  
  - **MongoDB 4.4.3 was installed. A database named `KoronaDB` was created using `use KoronaDB` in MongoShell, and a collection named `koronaVerileri` was added via `db.createCollection(...)`.**

- [Spring Boot](https://start.spring.io/) linkinden Maven Projesi oluşturulmuştur.  
  - Yazılım dili olarak Java versiyon 8, Spring Boot versiyonu olarak 2.4.1, packaging olarak .jar, Dependency olarak 'Spring Web' ve 'Spring Data MongoDB' seçilerek 'restful-korona' adında Spring Boot maven projesi oluşturulmuştur.  
  - Eclipse 4.9 (2018-09) versiyonu kullanılarak 'restful-korona' maven projesi import edilmiştir.  
  - Maven projesinde `application.properties` dosyasına MongoDB ile bağlantı kurulumu için `spring.data.mongodb.database=KoronaDB` ve `spring.data.mongodb.port=27017` bilgileri eklenmiştir.  
  - **A Maven project named `restful-korona` was generated using Spring Boot version 2.4.1 and Java 8. Dependencies include `Spring Web` and `Spring Data MongoDB`. The project was imported into Eclipse 4.9. MongoDB connection settings were configured in `application.properties`.**

- [NodeJs](https://nodejs.org/en/download/) versiyon 14.5 kurulumu için linkten bilgi alabilirsiniz.  
  - **Node.js version 14.5 was installed.**

- [ReactJs](https://tr.reactjs.org/docs/create-a-new-react-app.html#create-react-app) kullanıcı arayüz geliştirmeleri Visual Studio Code versiyon 1.52.1 de yapılmıştır.  
  - `npm install -g create-react-app` komutuyla create-react-app indirilmiştir. Kurulumu için linkten bilgi alabilirsiniz.  
  - `create-react-app reactkorona` komutuyla 'reactkorona' adında projenin yazılım arayüzü sınıfı yaratılmıştır.  
  - The frontend was developed using ReactJs in Visual Studio Code version 1.52.1. The `create-react-app` CLI was installed globally and used to generate the React project named `reactkorona`.**

---

### Kullanılan Kütüphaneler / Libraries Used

- [react-bootstrap](https://react-bootstrap.github.io/getting-started/introduction/)  
- [react-router-dom](https://www.npmjs.com/package/react-router-dom)  
- [axios](https://www.npmjs.com/package/axios)  
- [react-chartjs-2](https://www.npmjs.com/package/react-chartjs-2)

---
