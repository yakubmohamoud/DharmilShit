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
import javax.ws.rs.core.Response;

import dao.UserDao;
import model.User;

@Path("/users")
public class UserService {
	UserDao dao = new UserDao();

	@GET
	@Produces("application/json")
	public List<User> getAllUsers() {
		return dao.findAllUsers();

	}

	// GET USERS BY ID
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public User getUserById(@PathParam("id") int id) {
		return dao.findUserById(id);

	}

	// GET USERS BY
	@GET
	@Path("/user/{username}")
	@Consumes("application/json")
	@Produces("application/json")
	// public User findByUsername(@PathParam("username")String username) {
	public List<User> findByUsername(@PathParam("username") String username) {
		// get User account
		return dao.findByUsername(username);
	}

	@POST
	@Path("/login")
	public Response authenticate(@FormParam("username") String username, @FormParam("password") String password) {

		return Response.status(200).entity("" + dao.loginAuthentication(username, password) + "").build();

	}

	@DELETE
	@Path("/{id}")
	public void deleteUserForId(@PathParam("id") int id) {
		dao.deleteUser(id);
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	public void createUser(User newUser) {
		dao.createUser(newUser);
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public void updateUser(@PathParam("id") int id, User newUser) {
		dao.updateUser(id, newUser);
	}

}
