package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Contractor;

public class ContractorDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Y3844644");
	EntityManager em = null;

	public ContractorDao() {
		em = factory.createEntityManager();
	}
	
	public void createContractor(Contractor contractor) {
		em.getTransaction().begin();
		em.persist(contractor);
		em.getTransaction().commit();

	}
	
	public void updateContractor(int contractorId, Contractor contractor) {
		em.getTransaction().begin();
		Contractor c = em.find(Contractor.class, contractorId);
		c.setFirstName(contractor.getFirstName());
		c.setLastName(contractor.getLastName());
		c.setEmail(contractor.getEmail());
		c.setotherNames(contractor.getotherNames());
		em.merge(c);
		em.getTransaction().commit();

	}
	
	public void deleteContractor(int contractorId) {
		em.getTransaction().begin();
		Contractor contractor = em.find(Contractor.class, contractorId);
		em.remove(contractor);
		em.getTransaction().commit();
	}

	public Contractor findByContractorId(int contractorId) {
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Contractor c where c.contractorId=:contractorId");
		query.setParameter("contractorId", contractorId);
		Contractor contractor = (Contractor) query.getSingleResult();
		em.getTransaction().commit();

		return contractor;
	}
	
	


	public List<Contractor> findAllContractors() {
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Contractor c");
		List<Contractor> contractors = (List<Contractor>) query.getResultList();
		em.getTransaction().commit();
		return contractors;
	}
}
