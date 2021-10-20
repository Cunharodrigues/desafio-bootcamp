package com.devsuperior.dscliente.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private double income;
	private Instant birtDate;
	private Integer children;

	@Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
			private Instant createdAt;
			
	@Column (columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
			private Instant updatedAt;
	
	@ManyToMany
	@JoinTable (name = "tb_product_client",
		joinColumns = @JoinColumn (name = "product_id"),
		inverseJoinColumns = @JoinColumn (name = "client_id"))
	Set<Client> clienties = new HashSet<>();
	

	public Client() {

	}

	public Client(Long id, String name, String cpf, Double income, Instant birtDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birtDate = birtDate;
		this.children = children;
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

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
