package br.com.utmanager.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TB_PARTIDA")
public class Partida implements Serializable{

	private static final long serialVersionUID = -9060022568667921599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DS_TIME_CASA")
	private String timeCasa;

	@Column(name = "DS_TIME_VISITANTE")
	private String timeVisitante;

	@Column(name = "NU_GOLS_TIME_CASA")
	private Integer golsTimeCasa;
	
	@Column(name = "NU_GOLS_TIME_VISITANTE")
	private Integer golsTimeVisitante;
	
	@Column(name = "VL_GANHO_PARTIDA")
	private BigDecimal valorGanhoPartida;

	@Column(name = "DT_DATA_PARTIDA")
	private Date dataPartida;
	
	public Partida() {

	}
	
	public Partida(Long id) {
		super();
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(String timeCasa) {
		this.timeCasa = timeCasa;
	}

	public String getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(String timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Integer getGolsTimeCasa() {
		return golsTimeCasa;
	}

	public void setGolsTimeCasa(Integer golsTimeCasa) {
		this.golsTimeCasa = golsTimeCasa;
	}

	public Integer getGolsTimeVisitante() {
		return golsTimeVisitante;
	}

	public void setGolsTimeVisitante(Integer golsTimeVisitante) {
		this.golsTimeVisitante = golsTimeVisitante;
	}

	public BigDecimal getValorGanhoPartida() {
		return valorGanhoPartida;
	}

	public void setValorGanhoPartida(BigDecimal valorGanhoPartida) {
		this.valorGanhoPartida = valorGanhoPartida;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	
	@Transient
	public String getDescricaoPartida(){
		return timeCasa+" "+golsTimeCasa+" X "+golsTimeVisitante+" "+timeVisitante+" ";
	}
	
}
