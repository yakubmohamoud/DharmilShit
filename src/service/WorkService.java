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

import dao.WorkDao;
import model.Work;

@Path("/works")
public class WorkService {

	WorkDao dao = new WorkDao();

	@GET
	@Produces("application/json")
	public List<Work> getAllWorks() {
		return dao.findAllWork();

	}

//	@GET
//	@Produces("application/json")
//	@Path("/{workId}")
//	public Work getWorkById(@PathParam("workId") int workId) {
//		return dao.findByWorkId(workId);
//
//	}
	@GET
	@Produces("application/json")
	@Path("/{contractorId}")
	public Work findByContractorId(@PathParam("contractorId") int contractorId){
		
		return dao.findByContractorId(contractorId);
	}

	@DELETE
	@Path("/{workId}")
	public void deleteWork(@PathParam("workId") int workId) {
		dao.deleteWork(workId);
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	public void createWork(Work work) {
		dao.createWork(work);
	}

	@PUT
	@Path("/{workId}")
	@Consumes("application/json")
	public void updateWork(@PathParam("workId") int workId, Work work) {
		dao.updateWork(workId, work);
	}
}
