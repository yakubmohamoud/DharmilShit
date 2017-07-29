package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Work {
	
	@Id
	private int workId;
	private String name;
	private int contractorId;
	
	public Work(){}
	
	Work(int workId, String name, int contractorId ){
		this.workId = workId;
		this.name = name;
		this.contractorId = contractorId;
	}

	public int getContractorId() {
		return contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + workId;
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
		Work other = (Work) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (workId != other.workId)
			return false;
		return true;
	}
	
	

}
