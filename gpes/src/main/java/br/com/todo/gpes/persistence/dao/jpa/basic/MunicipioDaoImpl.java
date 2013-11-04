package br.com.todo.gpes.persistence.dao.jpa.basic;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.todo.gpes.model.basic.Municipio;
import br.com.todo.gpes.persistence.dao.basic.MunicipioDao;
import br.com.todo.gpes.persistence.dao.jpa.JpaGenericDao;

@Repository
public class MunicipioDaoImpl extends JpaGenericDao<Municipio, Integer> implements MunicipioDao{
	
	public List<Municipio> findByCodigoEstado(Integer codigoEstado, Integer codigoPais) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT c FROM Municipio c ");
		query.append("WHERE c.chave.codigoEstado = " + codigoEstado + "");
		query.append("AND c.chave.codigoPais = " + codigoPais + "");
		Query queryJpa = getEntityManager().createQuery(query.toString());
		return queryJpa.getResultList();
	}
}
