package model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contractor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contractorId;
	private String lastName;
	private String firstName;
	private String otherNames;
	private String email;
	
	
	  
    public Contractor(int contractorId, String lastName, String firstName, String otherNames, String email) {
		super();
		this.contractorId = contractorId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.otherNames = otherNames;
		this.email = email;
	}

	public Contractor() {
		super();
	}

    public int getcontractorId() {
        return contractorId;
    }

    public void setcontractorId(int contractorId) {
        this.contractorId = contractorId;
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

    public String getotherNames() {
        return otherNames;
    }

    public void setotherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contractorId;
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
		Contractor other = (Contractor) obj;
		if (contractorId != other.contractorId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contractor [contractorId=" + contractorId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", otherNames=" + otherNames + "]";
	}
    
	

}

