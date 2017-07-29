package model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tenant {

	@Id
	private int tenantId;
	private String lastName;
	private String firstName;
	private String otherNames;
	private String email;
	private String propertyId;

	public Tenant() {
		super();
	}

	public Tenant(int tenantId) {
		super();
		this.tenantId = tenantId;
	}

	public Tenant(int tenantId, String lastName, String firstName, String otherNames, String email, String propertyId) {
		this.tenantId = tenantId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.otherNames = otherNames;
		this.propertyId = propertyId;
		this.email = email;

	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tenantId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tenant other = (Tenant) obj;
		if (tenantId != other.tenantId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", lastName=" + lastName + ", firstName=" + firstName + ", otherNames="
				+ otherNames + "]";
	}

}
