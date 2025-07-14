//-----------------------------------------------------------------------------------------------------------
// Yazan:Eylül Aleyna Sahin
// Tarih:07/01/2021
// Açıklama: 'koronaVerilerRepository' bir interface'dir. Kullanıcının girdiği korona haberlerini MongoDB'ye 
// eklemede ya da verileri kullanıcı arayüzünde göstermek için gerekli metodları kullanmamızı sağlar.
//-----------------------------------------------------------------------------------------------------------
package com.korona.rest.webservices.restfulkorona.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.korona.rest.webservices.restfulkorona.model.koronaVeriler;

public interface koronaVerilerRepository extends MongoRepository<koronaVeriler, String>{

}
