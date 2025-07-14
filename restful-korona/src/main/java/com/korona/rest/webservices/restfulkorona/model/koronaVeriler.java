//---------------------------------------------------------------------------------------------------------------
// Yazan:Eylül Aleyna Sahin
// Tarih:07/01/2021
// Açıklama: Bu sınıf MongoDB'de bulunan "koronaVeriler" adlı collectionında bulunan keyler için get,set 
// metodları içermektedir.
//---------------------------------------------------------------------------------------------------------------
package com.korona.rest.webservices.restfulkorona.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "koronaVeriler")
public class koronaVeriler {
	
	@Id
	private String id;
	private String tarih;
	private String il;
	private int vaka;
	private int vefat;
	private int taburcu;

	public koronaVeriler() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public int getVaka() {
		return vaka;
	}

	public void setVaka(int vaka) {
		this.vaka = vaka;
	}

	public int getVefat() {
		return vefat;
	}

	public void setVefat(int vefat) {
		this.vefat = vefat;
	}

	public int getTaburcu() {
		return taburcu;
	}

	public void setTaburcu(int taburcu) {
		this.taburcu = taburcu;
	}

	@Override
	public String toString() {
		return "koronaVeriler [id=" + id + ", tarih=" + tarih + ", il=" + il + ", vaka=" + vaka + ", vefat=" + vefat
				+ ", taburcu=" + taburcu + "]";
	}

	
}
