package ru.insoft.archive.qqejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Сущность сотрудника организации
 *
 * @author stikkas<stikkas@yandex.ru>
 */
@Entity
@Table(name = "ADM_EMPLOYEE")
@NamedQueries({
	@NamedQuery(name = "Employee.DepartmentByLogin", query = "SELECT e.departmentId from AdmEmployee e "
			+ "WHERE e.user.login = :login")
})
public class AdmEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMPLOYEE_ID", insertable = false, updatable = false)
	private Long id;

	@Column(name = "DEPARTMENT_ID", insertable = false, updatable = false)
	private Long departmentId;
	/*
	 @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DESCRIPTOR_VALUE_ID",
	 insertable = false, updatable = false)
	 @ManyToOne
	 private DescriptorValue department;
	 */
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID",
			insertable = false, updatable = false)
	@ManyToOne
	private AdmUser user;

	public AdmEmployee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/*
	 public DescriptorValue getDepartment() {
	 return department;
	 }

	 public void setDepartment(DescriptorValue department) {
	 this.department = department;
	 }
	 */

	public AdmUser getUser() {
		return user;
	}

	public void setUser(AdmUser user) {
		this.user = user;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
