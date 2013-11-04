package br.com.contestacao.persistence.jpa;

import java.util.Date;

public interface AuditEntityPersistence extends EntityPersistence {

	void setCreatedDate(Date date);

	void setUpdatedDate(Date date);
}
