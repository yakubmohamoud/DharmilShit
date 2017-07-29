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

import dao.ContractorDao;
import model.Contractor;

@Path("/contractors")
public class ContractorService {
	ContractorDao dao = new ContractorDao();

	@GET
	@Produces("application/json")
	public List<Contractor> getAllContractors() {
		return dao.findAllContractors();

	}

	@GET
	@Produces("application/json")
	@Path("/{contractorId}")
	public Contractor getContractorById(@PathParam("contractorId") int contractorId) {
		return dao.findByContractorId(contractorId);

	}

	@DELETE
	@Path("/{contractorId}")
	public void deleteContractor(@PathParam("contractorId") int contractorId) {
		dao.deleteContractor(contractorId);
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	public void createContractor(Contractor contractor) {
		dao.createContractor(contractor);
	}

	@PUT
	@Path("/{contractorId}")
	@Consumes("application/json")
	public void updateContractor(@PathParam("contractorId") int contractorId, Contractor contractor) {
		dao.updateContractor(contractorId, contractor);
	}
}
