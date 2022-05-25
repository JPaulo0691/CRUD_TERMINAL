package application.entities;

import java.util.ArrayList;
import java.util.List;

public class Carro {
	
	private Integer id;
	private String proprietario;
	private String marca;
	private String placa;
	private int ano;	
	
	
	public Carro() {		
	}
	
	public Carro(Integer id,String proprietario, String marca, String placa, int ano) {
		this.id = id;
		this.proprietario = proprietario;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}			
	
	@Override
	public String toString() {
		return "IdCarro: " + id + "\n" +
			   "Nome: " + getProprietario() + "\n" + 
			   "Marca: " + getMarca() + "\n" +
			   "Placa: " + getPlaca() + "\n" +
			   "Ano: " + getAno() + "\n";				
	}
	
}
