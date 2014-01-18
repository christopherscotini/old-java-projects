package br.com.utmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLUBE")
public class ClubeJogador implements Serializable{

	private static final long serialVersionUID = -9060022568667921599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DS_NOME")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "LIGA_FK")
	private LigaJogador liga;
	
	public ClubeJogador() {
		// TODO Auto-generated constructor stub
	}
	
	public ClubeJogador(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LigaJogador getLiga() {
		return liga;
	}

	public void setLiga(LigaJogador liga) {
		this.liga = liga;
	}
	
}
