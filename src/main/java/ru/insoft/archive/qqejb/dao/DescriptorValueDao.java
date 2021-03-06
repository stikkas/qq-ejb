package ru.insoft.archive.qqejb.dao;

import java.util.List;
import javax.ejb.Stateless;
import ru.insoft.archive.qqejb.dto.DictDto;
import ru.insoft.archive.qqejb.dto.DictSVDto;

/**
 * Получение значений справочников
 *
 * @author stikkas<stikkas@yandex.ru>
 */
@Stateless
public class DescriptorValueDao extends AbstractDao {
	/**
	 * Возвращает значения id, полных и сокращенных значений
	 *
	 * @param groupCode код группы справочника
	 * @return справочник с тремя полями
	 */
	public List<DictSVDto> getFullShortValues(String groupCode) {
		return em.createNamedQuery("DescriptorValue.fullShortValues")
				.setParameter("groupId", store.getIdByCode(groupCode)).getResultList();
	}
	/**
	 * Возвращает значения id и полных значений
	 *
	 * @param groupCode код группы справочника
	 * @return справочник с двумя полями
	 */
	public List<DictDto> getFullValues(String groupCode) {
		return em.createNamedQuery("DescriptorValue.fullValue")
				.setParameter("groupId", store.getIdByCode(groupCode)).getResultList();
	}
	/**
	 * Возвращает значения id и ФИО пользователя с определенными правами
	 *
	 * @param ruleCode код права доступа
	 * @return справочник с двумя полями
	 */
	public List<DictDto> getUsersWithRule(String ruleCode) {
		return em.createNamedQuery("AdmAccessRule.usersWithRule")
				.setParameter("code", ruleCode).getResultList();
	}

}
