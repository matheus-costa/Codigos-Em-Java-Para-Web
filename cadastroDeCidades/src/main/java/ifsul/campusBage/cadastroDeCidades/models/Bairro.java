package ifsul.campusBage.cadastroDeCidades.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bairro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigo;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Float populacao;

	public Bairro() {
	}

	
	
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Float populacao) {
		this.populacao = populacao;
	}

}
