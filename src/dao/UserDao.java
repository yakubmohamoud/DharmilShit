package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.User;

public class UserDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Y3844644");
	EntityManager em = null;

	public UserDao() {
		em = factory.createEntityManager();
	}

	public void createUser(User User) {
		em.getTransaction().begin();
		em.persist(User);
		em.getTransaction().commit();

	}

	public void updateUser(int id, User user) {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		em.merge(u);
		em.getTransaction().commit();

	}

	public void deleteUser(int id) {
		em.getTransaction().begin();
		User User = em.find(User.class, id);
		em.remove(User);
		em.getTransaction().commit();

	}

	public User findUserById(int id) {
		em.getTransaction().begin();
		Query query = em.createQuery("select u from User u where u.userId=:userId");
		query.setParameter("userId", id);
		User User = (User) query.getSingleResult();
		em.getTransaction().commit();

		return User;
	}

	public List<User> findByUsername(String username) {

		em.getTransaction().begin();
		Query query = em.createQuery("select u from User u where u.username =:username");
		query.setParameter("username", username);
		List<User> Users = (List<User>) query.getResultList();
		em.getTransaction().commit();

		return Users;

	}

	public List<User> findAllUsers() {
		em.getTransaction().begin();
		Query query = em.createQuery("select u from User u");
		List<User> Users = (List<User>) query.getResultList();
		em.getTransaction().commit();
		return Users;
	}

	public boolean loginAuthentication(String username, String password) {
		em.getTransaction().begin();

		String select = ("select u from User u where u.username = :username and u.password=:password");

		Query query = em.createQuery(select);
		query.setParameter("username", username);
		query.setParameter("password", password);

		User User = (User) query.getSingleResult();

		try {

			if (User != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			System.out.println("error is being cause by " + e);

		}
		em.getTransaction().commit();
		return false;

	}

}
