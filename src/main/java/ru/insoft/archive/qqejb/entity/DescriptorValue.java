package ru.insoft.archive.qqejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Сущность справочника
 *
 * @author stikkas<stikkas@yandex.ru>
 */
@Entity
@Table(name = "DESCRIPTOR_VALUE")
@NamedQueries({
	@NamedQuery(name = "DescriptorValue.fullShortValues",
			query = "SELECT NEW ru.insoft.archive.qqejb.dto.DictSVDto(d.id, d.fullValue, d.shortValue) "
			+ "from DescriptorValue d JOIN d.group g WHERE g.groupCode = :code"),
	@NamedQuery(name = "DescriptorValue.fullValue",
			query = "SELECT NEW ru.insoft.archive.qqejb.dto.DictDto(d.id, d.fullValue) "
			+ "from DescriptorValue d JOIN d.group g WHERE g.groupCode = :code")
})
public class DescriptorValue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DESCRIPTOR_VALUE_ID", insertable = false, updatable = false)
	private Long id;

	@Column(name = "FULL_VALUE", insertable = false, updatable = false)
	private String fullValue;

	@Column(name = "SHORT_VALUE", insertable = false, updatable = false)
	private String shortValue;

	@Column(name = "VALUE_CODE", insertable = false, updatable = false)
	private String valueCode;

	@Column(name = "SORT_ORDER", insertable = false, updatable = false)
	private long sortOrder;

	@OneToMany(mappedBy = "parent")
	private List<DescriptorValue> children;

	@JoinColumn(name = "PARENT_VALUE_ID", referencedColumnName = "DESCRIPTOR_VALUE_ID",
			insertable = false, updatable = false)
	@ManyToOne
	private DescriptorValue parent;

	@JoinColumn(name = "DESCRIPTOR_GROUP_ID", referencedColumnName = "DESCRIPTOR_GROUP_ID",
			insertable = false, updatable = false)
	@ManyToOne
	private DescriptorGroup group;

	public DescriptorValue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DescriptorValue> getChildren() {
		return children;
	}

	public void addChild(DescriptorValue child) {
		if (!children.contains(child)) {
			children.add(child);
			DescriptorValue parent = child.getParent();
			if (parent != this) {
				if (parent != null) {
					parent.children.remove(child);
				}
				child.setParent(this);
			}
		}
	}

	public DescriptorValue getParent() {
		return parent;
	}

	public void setParent(DescriptorValue parent) {
		this.parent = parent;
	}

	public DescriptorGroup getGroup() {
		return group;
	}

	public void setGroup(DescriptorGroup group) {
		this.group = group;
	}

	public String getFullValue() {
		return fullValue;
	}

	public void setFullValue(String fullValue) {
		this.fullValue = fullValue;
	}

	public String getShortValue() {
		return shortValue;
	}

	public void setShortValue(String shortValue) {
		this.shortValue = shortValue;
	}

	public String getValueCode() {
		return valueCode;
	}

	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}

	public long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(long sortOrder) {
		this.sortOrder = sortOrder;
	}

}
