package ru.insoft.archive.qqejb.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import ru.insoft.archive.qqejb.dto.PageDto;
import ru.insoft.archive.qqejb.dto.SicJvkDto;
import ru.insoft.archive.qqejb.ejb.DictCodes;

/**
 * Класс для поиска ЖВК
 *
 * @author Благодатских С.
 */
@Stateless
public class JvkDao extends AbstractDao {

	public PageDto<SicJvkDto> getSicJvk(int start, int limit) {
		Long sicId = store.getIdByCode(DictCodes.Q_VALUE_MEMBER_SIC);
		Long onregId = store.getIdByCode(DictCodes.Q_VALUE_QSTAT_ONREG);
		Query query = em.createNamedQuery("SicJvk.default");
//				.setParameter("sic", sicId)
//				.setParameter("onreg", onregId);
		Query queryCount = em.createNamedQuery("SicJvk.defaultCount", Long.class);
//				.setParameter("sic", sicId)
//				.setParameter("onreg", onregId);
//		query.setFirstResult(start);
//		query.setMaxResults(limit);

//		Long count = (Long)queryCount.getSingleResult();
		List<SicJvkDto> values = query.getResultList();
		Long count = Long.valueOf(values.size());
		return new PageDto<>(count, new ArrayList<SicJvkDto>());
	}
}
