package ejercicioExamen;

public class Cliente {

	private String name;

	private String surname;

	private Integer accountNumber;

	public Cliente() {

	}

	public Cliente(String name, String surname, Integer accountNumber) {

		this.name = name;

		this.surname = surname;

		this.accountNumber = accountNumber;

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
