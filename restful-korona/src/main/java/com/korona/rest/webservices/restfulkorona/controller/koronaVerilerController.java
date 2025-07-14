//---------------------------------------------------------------------------------------------------------------
// Yazan:Eylül Aleyna Sahin
// Tarih:07/01/2021
// Açıklama: Bu sınıf REST API-GET, POST metodlarını içermektedir. Kullanıcının ReactJS arayüzünden yaptığı 
// isteklere göre koronaVerilerRepository sınıfında olan metodlar ile MongoDB'ye veri eklenip/veri çekilmektedir.
//---------------------------------------------------------------------------------------------------------------
package com.korona.rest.webservices.restfulkorona.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korona.rest.webservices.restfulkorona.model.koronaVeriler;
import com.korona.rest.webservices.restfulkorona.repository.koronaVerilerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class koronaVerilerController {

	@Autowired
	koronaVerilerRepository koronaRepository;

	// MongoDB'ye yeni korona verisi eklenmektedir. 
	@PostMapping("/yeniKoronaVerisi")
	public koronaVeriler createKoronaVerisi2(@RequestBody koronaVeriler yeniVeriCümlesi) {
		return koronaRepository.save(yeniVeriCümlesi);
	}

	@GetMapping("/ilVeriler/{il}")
	public List<koronaVeriler> getKoronaVerisiByİl(@PathVariable String il) throws ParseException {
		//------------------------------------------------------------------------------------------------
		// Özet: Raporlama ekranında seçilen ilin korona verileri tarihe göre sıralanarak getirilmektedir.
		// Amaç: Kullanıcı arayüzündeki raporlama ekranında belirli bir ilin Korona verileri grafikte
		// görüntülenmek isteniyorsa GetMapping ile bu ilin verileri kullanıcıya sunulmaktadır.
		// Açıklama: Aynı tarihte korona haberi olan illerin vaka, vefat, taburcu bilgileri toplanıp, fazladan 
		// olan MongoDb'den silinmektedir. Ayrıca MongoDB'de tarih key'i String formatında tutulduğu için
		// öncelikle bütün tarihler Date formatına getirilmiş, geçmişten günümüze olarak sıralanarak veriler 
		// kullanıcı arayüzüne gönderilmiştir.
		//------------------------------------------------------------------------------------------------
		DateFormat format;
		Date date;
		String tempTarih;
		int tempVeri;
		List<koronaVeriler> DBKoronaVerileri = koronaRepository.findAll();
		List<koronaVeriler> istenilenİlVerileri = new ArrayList<koronaVeriler>();
		List<koronaVeriler> sıralanmışİlVerileri = new ArrayList<koronaVeriler>();
		List<Date> tarihArr = new ArrayList<Date>();
		List<Date> temptarihArr = new ArrayList<Date>();

		for(int i = 0; i < DBKoronaVerileri.size(); i++) {
			if(DBKoronaVerileri.get(i).getIl().equals(il)) {
				istenilenİlVerileri.add(DBKoronaVerileri.get(i));
				sıralanmışİlVerileri.add(DBKoronaVerileri.get(i));
			}
		}

		//Birden fazla aynı tarihte haberi olan ilin vaka, vefat, taburcu verileri toplanıp bir araya getiriliyor.
		//Duplicate olan haberler silinmektedir.
		for(int i = 0; i < istenilenİlVerileri.size(); i++) {
			for(int j = i+1; j < istenilenİlVerileri.size(); j++) {
				if(istenilenİlVerileri.get(i).getTarih().equals(istenilenİlVerileri.get(j).getTarih())) {
					tempVeri = istenilenİlVerileri.get(i).getVaka() + istenilenİlVerileri.get(j).getVaka();
					istenilenİlVerileri.get(i).setVaka(tempVeri);
					sıralanmışİlVerileri.get(i).setVaka(tempVeri);

					tempVeri = istenilenİlVerileri.get(i).getVefat() + istenilenİlVerileri.get(j).getVefat();
					istenilenİlVerileri.get(i).setVefat(tempVeri);
					sıralanmışİlVerileri.get(i).setVefat(tempVeri);

					tempVeri = istenilenİlVerileri.get(i).getTaburcu() + istenilenİlVerileri.get(j).getTaburcu();
					istenilenİlVerileri.get(i).setTaburcu(tempVeri);
					sıralanmışİlVerileri.get(i).setTaburcu(tempVeri);

					koronaRepository.delete(istenilenİlVerileri.get(j));
					koronaRepository.save(istenilenİlVerileri.get(i));

					istenilenİlVerileri.remove(j);
					sıralanmışİlVerileri.remove(j);
				}
			}
		}

		//İstenilen ilin updatelenen verileri bastırma
		for(int i = 0; i < istenilenİlVerileri.size(); i++) {
			tempTarih = istenilenİlVerileri.get(i).getTarih();
			format = new SimpleDateFormat("dd.MM.yyyy");
			date = format.parse(tempTarih);
			tarihArr.add(date);
			temptarihArr.add(date);
		}	

		Collections.sort(tarihArr);

		//İstenilen ilin verilerinin tarihe göre sıralama
		for(int i = 0; i < temptarihArr.size(); i++) {
			for(int j = 0; j < tarihArr.size(); j++) {
				if(temptarihArr.get(i).compareTo(tarihArr.get(j)) == 0) {
					sıralanmışİlVerileri.set(j, istenilenİlVerileri.get(i));
				}
			}
		}
		return sıralanmışİlVerileri;
	}



	@GetMapping("/bütünVeriler")
	public List<koronaVeriler> getbütünKoronaVerisi() throws ParseException {
		//------------------------------------------------------------------------------------------------
		// Özet: Raporlama ekranında Türkiye genelindeki verilerin kümülatif olarak tarihe göre sıralanarak 
		// alınıyor.
		// Amaç: Kullanıcı arayüzündeki raporlama ekranında Türkiye genelindeki Korona verilerini kümülatif
		// grafik olarak görüntülenmek isteniyorsa GetMapping ile bu veriler kullanıcıya sunulmaktadır.
		// Açıklama: Aynı tarihte korona haberi olan bütün illerin vaka, vefat, taburcu bilgileri toplan
		// kümülatif bir şekilde kuulanıcı arayüzüne gönderilmiştir. Ayrıca MongoDB'de tarih key'i String 
		// formatında tutulduğu için öncelikle bütün tarihler Date formatına getirilerek geçmişten günümüze 
		// olarak sıralanmış veriler kullanıcı arayüzüne bu şekilde gönderilmiştir.
		//------------------------------------------------------------------------------------------------
		DateFormat format;
		Date date;
		String tempTarih;
		int tempVeri;
		List<koronaVeriler> DBKoronaVerileri = koronaRepository.findAll();
		List<koronaVeriler> istenilenİlVerileri = new ArrayList<koronaVeriler>();
		List<koronaVeriler> sıralanmışİlVerileri = new ArrayList<koronaVeriler>();
		List<Date> tarihArr = new ArrayList<Date>();
		List<Date> temptarihArr = new ArrayList<Date>();

		for(int i = 0; i < DBKoronaVerileri.size(); i++) {
			istenilenİlVerileri.add(DBKoronaVerileri.get(i));
			sıralanmışİlVerileri.add(DBKoronaVerileri.get(i));
		}

		//Duplicate olan tarihler silinmektedir
		for(int i = 0; i < istenilenİlVerileri.size(); i++) {
			for(int j = i+1; j < istenilenİlVerileri.size(); j++) {
				if(istenilenİlVerileri.get(i).getTarih().equals(istenilenİlVerileri.get(j).getTarih())) {
					tempVeri = istenilenİlVerileri.get(i).getVaka() + istenilenİlVerileri.get(j).getVaka();
					istenilenİlVerileri.get(i).setVaka(tempVeri);
					sıralanmışİlVerileri.get(i).setVaka(tempVeri);

					tempVeri = istenilenİlVerileri.get(i).getVefat() + istenilenİlVerileri.get(j).getVefat();
					istenilenİlVerileri.get(i).setVefat(tempVeri);
					sıralanmışİlVerileri.get(i).setVefat(tempVeri);

					tempVeri = istenilenİlVerileri.get(i).getTaburcu() + istenilenİlVerileri.get(j).getTaburcu();
					istenilenİlVerileri.get(i).setTaburcu(tempVeri);
					sıralanmışİlVerileri.get(i).setTaburcu(tempVeri);

					istenilenİlVerileri.remove(j);
					sıralanmışİlVerileri.remove(j);
				}
			}
		}

		for(int i = 0; i < istenilenİlVerileri.size(); i++) {
			tempTarih = istenilenİlVerileri.get(i).getTarih();
			format = new SimpleDateFormat("dd.MM.yyyy");
			date = format.parse(tempTarih);
			tarihArr.add(date);
			temptarihArr.add(date);
		}	

		Collections.sort(tarihArr);

		//Bütün verilerinin tarihe göre sıralaması
		for(int i = 0; i < temptarihArr.size(); i++) {
			for(int j = 0; j < tarihArr.size(); j++) {
				if(temptarihArr.get(i).compareTo(tarihArr.get(j)) == 0) {
					sıralanmışİlVerileri.set(j, istenilenİlVerileri.get(i));
				}
			}
		}
		return sıralanmışİlVerileri;
	}
}
