package ru.insoft.archive.qqejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Сущность пользователя системы
 *
 * @author stikkas<stikkas@yandex.ru>
 */
@Entity
@Table(name = "ADM_USER")
@NamedQueries({
	@NamedQuery(name = "AdmUser.usersWithRule", query = 
			"SELECT NEW ru.insoft.archive.qqejb.dto.DictDto(u.id, u.displayedName) "
					+ "FROM AdmUser u JOIN u.groups g JOIN g.rules r WHERE r.ruleId = :id"),
	@NamedQuery(name = "AdmUser.userRules", query = 
			"SELECT r.ruleId FROM AdmUser u JOIN u.groups g JOIN g.rules r WHERE u.id = :id")
})
public class AdmUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID", insertable = false, updatable = false)
	private Long id;

	@Column(name = "LOGIN", insertable = false, updatable = false)
	private String login;

	@Column(name = "DISPLAYED_NAME", insertable = false, updatable = false)
	private String displayedName;

	@JoinColumn(name = "USER_TYPE_ID", referencedColumnName = "DESCRIPTOR_VALUE_ID",
			insertable = false, updatable = false)
	@ManyToOne
	private DescriptorValue userType;

	@ManyToMany(mappedBy = "users")
	private List<AdmGroup> groups;

	public AdmUser() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDisplayedName() {
		return displayedName;
	}

	public void setDisplayedName(String displayedName) {
		this.displayedName = displayedName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DescriptorValue getUserType() {
		return userType;
	}

	public void setUserType(DescriptorValue userType) {
		this.userType = userType;
	}

	public List<AdmGroup> getGroups() {
		return groups;
	}

	public void addGroup(AdmGroup group) {
		if (!groups.contains(group)) {
			groups.add(group);
			group.addUser(this);
		}
	}

}
