package ru.insoft.archive.qqejb.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.insoft.archive.qqejb.ejb.Store;

/**
 * Общие настройки для всех бинов доступа к сущностям
 *
 * @author stikkas<stikkas@yandex.ru>
 */
public abstract class AbstractDao {

	@PersistenceContext(unitName = "QQPU")
	protected EntityManager em;

	@Inject
	protected Store store;
}
