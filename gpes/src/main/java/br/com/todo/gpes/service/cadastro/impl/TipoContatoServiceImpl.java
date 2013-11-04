package br.com.todo.gpes.service.cadastro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.gpes.model.cadastro.AtivoInativoEnum;
import br.com.todo.gpes.model.cadastro.TipoContato;
import br.com.todo.gpes.persistence.dao.cadastro.TipoContatoDao;
import br.com.todo.gpes.service.cadastro.TipoContatoService;
import br.com.todo.gpes.service.exception.RegistroJaCadastradoException;

@Service
public class TipoContatoServiceImpl implements TipoContatoService {

	@Autowired
	private TipoContatoDao tipoContatoDao = null;
	
	public List<TipoContato> obterTipoContato(String descricao, String situacao) {
		return tipoContatoDao.findByDescricao(descricao, situacao);
	}

	public void incluirTipoContato(TipoContato tipoContato) {
		if (tipoContatoDao.findById(tipoContato.getCodigoTipoContato()) != null) {
			throw new RegistroJaCadastradoException("TipoContato");
		}

		tipoContato.setSituacao(AtivoInativoEnum.ATIVO.getCodigo());
		tipoContatoDao.insert(tipoContato);
	}
	
	public void alterarTipoContato(TipoContato tipoContato) {
		tipoContatoDao.update(tipoContato);
	}

	public TipoContatoDao getTipoContatoDao() {
		return tipoContatoDao;
	}

	public void setTipoContatoDao(TipoContatoDao tipoContatoDao) {
		this.tipoContatoDao = tipoContatoDao;
	}
	
}
