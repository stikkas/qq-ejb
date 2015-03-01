package ru.insoft.archive.qqejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Сущность прав доступа
 *
 * @author stikkas<stikkas@yandex.ru>
 */
@Entity
@Table(name = "ADM_ACCESS_RULE")

public class AdmAccessRule implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ACCESS_RULE_ID", insertable = false, updatable = false)
	private Long id;

	@Column(name = "RULE_CODE", insertable = false, updatable = false)
	private String ruleCode;

	@JoinTable(name = "ADM_GROUP_RULE", joinColumns = {
		@JoinColumn(name = "ACCESS_RULE_ID", referencedColumnName = "ACCESS_RULE_ID")}, inverseJoinColumns = {
		@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")})
	@ManyToMany
	private List<AdmGroup> groups;

	public AdmAccessRule() {
	}

	public String getRuleCode() {
		return ruleCode;
	}

	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AdmGroup> getGroups() {
		return groups;
	}

	public void addGroup(AdmGroup group) {
		if (!groups.contains(group)) {
			groups.add(group);
			group.addRule(this);
		}
	}

}