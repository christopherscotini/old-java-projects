package br.com.portal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SOLICITACAO")
public class SolicitacaoEntity  implements Serializable {

	private static final long serialVersionUID = 3868163866373433713L;

	@Column(name = "DESC_SOLICITACAO")
	private String descricaoSolicitacao;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_FK")
	private ClienteEntity clienteSolicitante;

	@ManyToOne
	@JoinColumn(name = "EMPRESA_FK")
	private EmpresaEntity empresaPrestadoraServico;

	@Column(name = "DT_SOLICITACAO")
	private Date dataSolicitacao;

	@Column(name = "DT_RESPOSTA_FORNECEDOR")
	private Date dataRespostaFornecedor;

	@Column(name = "FL_STATUS")
	private Integer status;
	
	public SolicitacaoEntity() {
		// TODO Auto-generated constructor stub
	}

	public SolicitacaoEntity(String descricaoSolicitacao,
			ClienteEntity clienteSolicitante,
			EmpresaEntity empresaPrestadoraServico, Date dataSolicitacao,
			Date dataRespostaFornecedor) {
		super();
		this.descricaoSolicitacao = descricaoSolicitacao;
		this.clienteSolicitante = clienteSolicitante;
		this.empresaPrestadoraServico = empresaPrestadoraServico;
		this.dataSolicitacao = dataSolicitacao;
		this.dataRespostaFornecedor = dataRespostaFornecedor;
	}

	public String getDescricaoSolicitacao() {
		return descricaoSolicitacao;
	}

	public void setDescricaoSolicitacao(String descricaoSolicitacao) {
		this.descricaoSolicitacao = descricaoSolicitacao;
	}

	public ClienteEntity getClienteSolicitante() {
		return clienteSolicitante;
	}

	public void setClienteSolicitante(ClienteEntity clienteSolicitante) {
		this.clienteSolicitante = clienteSolicitante;
	}

	public EmpresaEntity getEmpresaPrestadoraServico() {
		return empresaPrestadoraServico;
	}

	public void setEmpresaPrestadoraServico(
			EmpresaEntity empresaPrestadoraServico) {
		this.empresaPrestadoraServico = empresaPrestadoraServico;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataRespostaFornecedor() {
		return dataRespostaFornecedor;
	}

	public void setDataRespostaFornecedor(Date dataRespostaFornecedor) {
		this.dataRespostaFornecedor = dataRespostaFornecedor;
	}

	public String getStatusDescricao() {
		return StatusSolicitacao.getStatusSolicitacaoByCodigo(status).toString();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TB_CD_ID_PK")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		SolicitacaoEntity other = (SolicitacaoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
