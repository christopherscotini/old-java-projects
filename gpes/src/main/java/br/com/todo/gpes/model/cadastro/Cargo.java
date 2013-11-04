package br.com.todo.gpes.model.cadastro;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cargo")
public class Cargo {

	@Id
	@Column(name = "cdCargo")
	private Integer codigo;

	@Column(name = "nmCargo")
	private String descCargo;

	@Column(name = "vrSalarioCargo")
	private BigDecimal salario;

	@Column(name = "cdIndicadorSituacaoCargo")
	private String situacao;

	public Cargo() {
		super();
	}

	public Cargo(Cargo cargo) {
		super();
		this.codigo = cargo.getCodigo();
		this.descCargo = cargo.getDescCargo();
		this.salario = cargo.getSalario();
		this.situacao = cargo.getSituacao();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescCargo() {
		return descCargo;
	}

	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDescSituacao() {
		AtivoInativoEnum ativoInativoEnum = AtivoInativoEnum.getAtivoInativoByCodigo(situacao);
		if (ativoInativoEnum != null) {
			return ativoInativoEnum.toString();
		}
		return "";
	}
}
