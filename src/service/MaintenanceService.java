package service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.MaintenanceDao;
import model.Maintenance;

@Path("/maintenance")
public class MaintenanceService {

	MaintenanceDao dao = new MaintenanceDao();

	@GET
	@Produces("application/json")
	public List<Maintenance> getAllMaintenances() {
		return dao.findAllMaintenance();

	}

	@GET
	@Produces("application/json")
	@Path("/{maintenanceId}")
	public Maintenance getMaintenanceById(@PathParam("maintenanceId") int maintenanceId) {
		return dao.findByMaintenanceId(maintenanceId);

	}

	@DELETE
	@Path("/{maintenanceId}")
	public void deleteMaintenance(@PathParam("maintenanceId") int maintenanceId) {
		dao.deleteMaintenance(maintenanceId);
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	public void createMaintenance(Maintenance maintenance) {
		dao.createMaintenance(maintenance);
	}

	@PUT
	@Path("/{maintenanceId}")
	@Consumes("application/json")
	public void updateMaintenance(@PathParam("maintenanceId") int maintenanceId, Maintenance maintenance) {
		dao.updateMaintenance(maintenanceId, maintenance);
	}
}
