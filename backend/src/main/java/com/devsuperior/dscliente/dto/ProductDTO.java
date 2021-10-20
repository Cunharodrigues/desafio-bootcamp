package com.devsuperior.dscliente.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dscliente.entities.Client;

//import com.devsuperior.dsProducte.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birtDate;
	private Integer children;

	public ProductDTO() {

	}

	public ProductDTO(Long id, String name, String cpf, Double income, Instant birtDate, Integer children) {

		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birtDate = birtDate;
		this.children = children;

	}

	public ProductDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birtDate = entity.getBirtDate();
		this.children = entity.getChildren();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(Instant birtDate) {
		this.birtDate = birtDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
