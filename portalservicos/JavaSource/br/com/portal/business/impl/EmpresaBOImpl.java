/**
 * 
 */
package br.com.portal.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portal.business.EmpresaBO;
import br.com.portal.business.exception.RegistroJaCadastradoException;
import br.com.portal.dao.cadastro.EmpresaDao;
import br.com.portal.dao.cadastro.UserDao;
import br.com.portal.model.EmpresaEntity;
import br.com.portal.model.UserEntity;
import br.com.portal.utils.CriptografiaUtil;
import br.com.portal.utils.ProjetoUtils;

/**
 * @author christopher.rozario
 *
 */

@Service
public class EmpresaBOImpl implements EmpresaBO{

	@Autowired
	private UserDao userDao = null;

	@Autowired
	private EmpresaDao dao = null;

	@Override
	public List<EmpresaEntity> listarTodos() {
		return dao.findAll();
	}
	
	@Override
	public EmpresaEntity buscarEmpresaPorUserID(UserEntity user) {
		return dao.findByUserId(user);
	}

	@Override
	public EmpresaEntity adicionarEntidade(EmpresaEntity entidade) {
		
		if(userDao.existsUser(entidade.getUsuario())){
			throw new RegistroJaCadastradoException("Esse usuario já esta cadastrado.");
		}		
		
		if(dao.existsEmpresa(entidade)){
			throw new RegistroJaCadastradoException("Essa empresa já esta cadastrada.");
		}
		
		entidade.getUsuario().setPassword(CriptografiaUtil.criptografar(entidade.getUsuario().getPassword()));
		entidade.setUsuario(userDao.insert(entidade.getUsuario()));
		
		return dao.insert(removerMascaras(entidade));
		
	}
	
	private EmpresaEntity removerMascaras(EmpresaEntity entity){
		if(!(entity.getCnpjString() == null || entity.getCnpjString().equals(""))){
			entity.setCnpj(Long.valueOf(ProjetoUtils.verificaStringCpfCnpjToLong(entity.getCnpjString())));
		}
		if(!(entity.getTelefone1String() == null || entity.getTelefone1String().equals(""))){
			entity.setTelefone1(ProjetoUtils.removerFormatacaoTelefone(entity.getTelefone1String()));
		}
		if(!(entity.getTelefone2String() == null || entity.getTelefone2String().equals(""))){
			entity.setTelefone2(ProjetoUtils.removerFormatacaoTelefone(entity.getTelefone2String()));
		}
		if(!(entity.getTelefone3String() == null || entity.getTelefone3String().equals(""))){
			entity.setTelefone3(ProjetoUtils.removerFormatacaoTelefone(entity.getTelefone3String()));
		}
		return entity;
	}

	@Override
	public EmpresaEntity editarEntidade(EmpresaEntity entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmpresaDao getDao() {
		return dao;
	}

	public void setDao(EmpresaDao dao) {
		this.dao = dao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
