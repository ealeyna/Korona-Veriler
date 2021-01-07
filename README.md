# Korona-Verileri
## Projenin Amacı: 
- Açık kaynak haberlerden text halinde bilgilerin anahtar vaka sayıları ölüm ve iyileşen sayılarını toplayıp bir ekranda grafik olarak gösteriminin yapılması ve yeni veri sisteme eklendikçe grafiğin online olarak değişmesi amaçlanmaktadır.
---
## Ön Koşullar
- MongoDB
- Spring Boot Maven Project
- ReactJs
- NodeJs
- NPM
---
## Kurulumlar
- [MongoDB](https://www.mongodb.com/try/download/community)  versiyon 4.4.3 kurulumu için linkten bilgi alabilirsiniz.
  - MongoDB'ye MongoShell'den use KoronaDB komutu girilerek 'KoronaDB' adında bir veritabanı oluşturulmuştur. db.createCollection('koronaVerileri') komutuyla 'KoronaDB' veritabanına yeni bir collection eklenmiştir.
- [Spring Boot](https://start.spring.io/) linkinden Maven Projesi oluşturulmuştur. 
  - Yazılım dili olarak Java versiyon 8, Spring Boot versiyonu olarak 2.4.1, packaging olarak .jar, Dependency olarak 'Spring Web' ve 'Spring Data MongoDB' seçilerek 'restful-korona' adında Spring Boot maven projesi oluşturulmuştur. 
  - Eclipse 4.9 (2018-09) versiyonu kullanılarak 'restful-korona' maven projesi import edilmiştir. 
  - Maven projesinde 'application.properties' dosyasına MongoDB ile bağlantı kurulumu için spring.data.mongodb.database=KoronaDB ve spring.data.mongodb.port=27017 bilgileri eklenmiştir.
- [NodeJs](https://nodejs.org/en/download/) versiyon 14.5 kurulumu için linkten bilgi alabilirsiniz.
- [ReactJs](https://tr.reactjs.org/docs/create-a-new-react-app.html#create-react-app) kullanıcı arayüz geliştirmeleri Visual Studio Code versiyon 1.52.1 de yapılmıştır.
  - npm install -g create-react-app komutuyla create-react-app indirilmiştir. Kurulumu için linkten bilgi alabilirsiniz.
  - create-react-app reactkorona komutuyla 'reactkorona' adında projenin yazılım arayüzü sınıfı yaratılmıştır.
---
### Kullanılan Kütüphaneler
- [react-bootstrap](https://react-bootstrap.github.io/getting-started/introduction/)
- [react-router-dom](https://www.npmjs.com/package/react-router-dom)
- [axios](https://www.npmjs.com/package/axios)
- [react-chartjs-2](https://www.npmjs.com/package/react-chartjs-2)
---
