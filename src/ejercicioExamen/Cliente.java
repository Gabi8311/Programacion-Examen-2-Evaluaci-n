package ejercicioExamen;

import java.util.ArrayList;

public class Cliente {

	private String name;

	private String surname;

	private Integer accountNumber;

	private ArrayList<Peliculas> pelisCliente = new ArrayList<Peliculas>();

	private ArrayList<Series> seriesCliente = new ArrayList<Series>();

	public Cliente() {

	}

	public Cliente(String name, String surname, Integer accountNumber) {

		this.name = name;

		this.surname = surname;

		this.accountNumber = accountNumber;

	}

	public Cliente(String name, String surname, Integer accountNumber, ArrayList<Peliculas> pelisAlqCliente,ArrayList<Series> seriesAlqCliente) {

		this.name = name;

		this.surname = surname;

		this.accountNumber = accountNumber;

		this.pelisCliente = pelisAlqCliente;

		this.seriesCliente = seriesAlqCliente;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getSurname() {

		return surname;

	}

	public void setSurname(String surname) {

		this.surname = surname;

	}

	public Integer getAccountNumber() {

		return accountNumber;

	}

	public void setAcccountNumber(Integer accountNumber) {

		this.accountNumber = accountNumber;

	}

	@Override
	public String toString() {

		return "Socio: " + this.name + "; Apellido: " + this.surname + "; Num.de Socio:" + this.accountNumber;

	}

}
