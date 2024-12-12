package com.DatuAtzipena.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class erabiltzailea {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String izena;

	@Column
	private String abizena;

	public erabiltzailea(String izena, String abizena) {
		this.izena = izena;
		this.abizena = abizena;
	}

	@Override
	public String toString() {
		return "erabiltzailea [ izena=" + izena + ", abizena=" + abizena + "]";
	}

}
