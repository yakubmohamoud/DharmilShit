package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Maintenance {
	
	@Id
	private int maintenanceId;
	private int tenantId;
	private Work type;
	private boolean status;
	private String description;
	
	public Maintenance(){}
	
	public Maintenance(int maintenanceId, int tenantId, Work type, boolean status, String description){
		
		this.maintenanceId = maintenanceId;
		this.tenantId = tenantId;
		this.type = type;
		this.status = status;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public Work getType() {
		return type;
	}

	public void setType(Work type) {
		this.type = type;
	}
	

}
