package ru.insoft.archive.qqejb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Общие настройки для всех бинов доступа к сущностям
 *
 * @author stikkas<stikkas@yandex.ru>
 */
class AbstractDao {
	@PersistenceContext(unitName = "QQPU")
	protected EntityManager em;
}
