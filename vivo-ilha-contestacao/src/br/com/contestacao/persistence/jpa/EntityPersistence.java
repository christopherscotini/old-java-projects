package br.com.contestacao.persistence.jpa;

import java.io.Serializable;

public interface EntityPersistence extends Serializable {

	Serializable getPrimaryKey();
}
