package br.com.todo.gpes.model.cadastro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cdCliente")
	private Integer codigoCliente;
	
	@Column(name = "cdCpfCnpj")
	private Long numeroCnpj;
	
	@Column(name = "cdFilialCnpj")
	private Integer filialCnpj;
	
	@Column(name = "cdControleCpfCnpj")
	private Integer controleCnpj;
	
	@Column(name = "nmCliente")
	private String descCliente;
	
	@Column(name = "nmRazaoSocialCliente")
	private String descRazaoSocial;
	
	@Column(name = "cdIndicadorSituacaoCliente")
	private String situacao;
	
	@Column(name = "dtAtivacaoCliente")
	private Date dtAtivacao;
	
	@Column(name = "dtInativacaoCliente")
	private Date dtInativacao;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumns ({
        @JoinColumn(name="cdCliente", nullable=false)
    })
	private List<EnderecoCliente> enderecos = new ArrayList<EnderecoCliente>();
	
	public Cliente() {
		super();
	}
	
	public Cliente(Integer codigoCliente, Long numeroCnpj, Integer filialCnpj,
			Integer controleCnpj, String descCliente, String descRazaoSocial,
			String situacao, Date dtAtivacao, Date dtInativacao) {
		super();
		this.codigoCliente = codigoCliente;
		this.numeroCnpj = numeroCnpj;
		this.filialCnpj = filialCnpj;
		this.controleCnpj = controleCnpj;
		this.descCliente = descCliente;
		this.descRazaoSocial = descRazaoSocial;
		this.situacao = situacao;
		this.dtAtivacao = dtAtivacao;
		this.dtInativacao = dtInativacao;
	}

	public Long getNumeroCnpj() {
		return numeroCnpj;
	}
	
	public void setNumeroCnpj(Long numeroCnpj) {
		this.numeroCnpj = numeroCnpj;
	}
	
	public Integer getFilialCnpj() {
		return filialCnpj;
	}
	
	public void setFilialCnpj(Integer filialCnpj) {
		this.filialCnpj = filialCnpj;
	}
	
	public Integer getControleCnpj() {
		return controleCnpj;
	}
	
	public void setControleCnpj(Integer controleCnpj) {
		this.controleCnpj = controleCnpj;
	}
	
	public String getDescCliente() {
		return descCliente;
	}
	
	public void setDescCliente(String descCliente) {
		this.descCliente = descCliente;
	}
	
	public String getDescRazaoSocial() {
		return descRazaoSocial;
	}
	
	public void setDescRazaoSocial(String descRazaoSocial) {
		this.descRazaoSocial = descRazaoSocial;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Date getDtAtivacao() {
		return dtAtivacao;
	}

	public void setDtAtivacao(Date dtAtivacao) {
		this.dtAtivacao = dtAtivacao;
	}

	public Date getDtInativacao() {
		return dtInativacao;
	}

	public void setDtInativacao(Date dtInativacao) {
		this.dtInativacao = dtInativacao;
	}

	public List<EnderecoCliente> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoCliente> enderecos) {
		this.enderecos = enderecos;
	}

}
