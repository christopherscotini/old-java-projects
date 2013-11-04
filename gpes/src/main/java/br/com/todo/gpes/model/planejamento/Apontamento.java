package br.com.todo.gpes.model.planejamento;

public class Apontamento {
	
	private String id;
	
	private String nome;

	private String elemento;

	private String data;

	private String horarioInicial;

	private String horarioFinal;

	private String atividade;

	public Apontamento() {
		super();
	}

	public Apontamento(String id, String nome, String elemento, String data, String horarioInicial,
			String horarioFinal, String atividade) {
		super();
		this.id = id;
		this.nome = nome;
		this.elemento = elemento;
		this.data = data;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		this.atividade = atividade;
	}
	
	public Apontamento(String nome, String elemento, String data, String horarioInicial,
			String horarioFinal, String atividade) {
		super();
		this.nome = nome;
		this.elemento = elemento;
		this.data = data;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		this.atividade = atividade;
	}
	
	public Apontamento(String elemento, String data, String horarioInicial,
			String horarioFinal, String atividade) {
		super();
		this.elemento = elemento;
		this.data = data;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		this.atividade = atividade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(String horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	@Override
	public String toString() {
		return "ApontamentoDTO [id=" + id + ", nome=" + nome + ", elemento="
				+ elemento + ", data=" + data + ", horarioInicial="
				+ horarioInicial + ", horarioFinal=" + horarioFinal
				+ ", atividade=" + atividade + "]";
	}

}
