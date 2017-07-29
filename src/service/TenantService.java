package service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.TenantDao;
import model.Tenant;

@Path("/tenants")
public class TenantService {

	TenantDao dao = new TenantDao();

	@GET
	@Produces("application/json")
	@Path("/")
	public List<Tenant> getAllTenants() {
		return dao.findAllTenants();

	}


	@GET
	@Produces("application/json")
	@Path("/{tenantId}")
	public Tenant getTenantById(@PathParam("tenantId") int tenantId) {
		return dao.findByTenantId(tenantId);

	}

	@DELETE
	@Path("/{tenantId}")
	public void deleteTenant(@PathParam("tenantId") int tenantId) {
		dao.deleteTenant(tenantId);
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	public void createTenant(Tenant tenant) {
		dao.createTenant(tenant);
	}

	@PUT
	@Path("/{tenantId}")
	@Consumes("application/json")
	public void updateTenant(@PathParam("tenantId") int tenantId, Tenant tenant) {
		dao.updateTenant(tenantId, tenant);
	}
}
