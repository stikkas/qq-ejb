package ru.insoft.archive.qqejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * класс для ЖВК СИЦ
 *
 * @author Благодатских С.
 */
@Entity
@Table(name = "SIC_QUESTION")
@NamedQueries({
	@NamedQuery(name = "SicJvk.default", query
			= "SELECT NEW ru.insoft.archive.qqejb.dto.SicJvkDto("
			+ "j.id, j.litera.shortValue, CONCAT(CONCAT(j.numPrefix, '/'), j.numSufix), "
			+ "j.regDate, j.controlDate, j.planDate, "
			+ "COALESCE(j.organization, CONCAT(CONCAT(CONCAT(CONCAT(NULLIF(j.famaly,''), ' '), "
			+ "NULLIF(j.name,'')), ' '), NULLIF(j.otchestvo, ''))), j.status.fullValue, "
			+ "j.executor.displayedName, j.notificationStatus.fullValue, "
			+ "j.execOrganization.shortValue) from SicJvk j "
//			+ "WHERE j.literaId = :sic OR (j.literaId != :sic AND j.statusId != :onreg) ORDER BY j.regDate DESC"),
			+ " ORDER BY j.regDate DESC"),
	@NamedQuery(name = "SicJvk.defaultCount", query
			= "SELECT COUNT(j.id) from SicJvk j "
//			+ "WHERE j.literaId = :sic OR (j.literaId != :sic AND j.statusId != :onreg)")
			+ "")

})
public class SicJvk extends Jvk implements Serializable {

	@Column(name = "NOTI_STATUS_ID", insertable = false, updatable = false)
	private Long notificationStatusId;

	@Column(name = "EXEC_ORG_ID", insertable = false, updatable = false)
	private Long execOrgId;

	@JoinColumn(name = "NOTI_STATUS_ID", referencedColumnName = "DESCRIPTOR_VALUE_ID",
			insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private DescriptorValue notificationStatus;

	@JoinColumn(name = "EXEC_ORG_ID", referencedColumnName = "DESCRIPTOR_VALUE_ID",
			insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private DescriptorValue execOrganization;

	public Long getNotificationStatusId() {
		return notificationStatusId;
	}

	public void setNotificationStatusId(Long notificationStatusId) {
		this.notificationStatusId = notificationStatusId;
	}

	public Long getExecOrgId() {
		return execOrgId;
	}

	public void setExecOrgId(Long execOrgId) {
		this.execOrgId = execOrgId;
	}

	public DescriptorValue getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(DescriptorValue notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public DescriptorValue getExecOrganization() {
		return execOrganization;
	}

	public void setExecOrganization(DescriptorValue execOrganization) {
		this.execOrganization = execOrganization;
	}
}
