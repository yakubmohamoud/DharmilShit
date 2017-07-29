package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Work;

public class WorkDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Y3844644");
	EntityManager em = null;

	public WorkDao() {
		em = factory.createEntityManager();
	}
	
	public void createWork(Work work) {
		em.getTransaction().begin();
		em.persist(work);
		em.getTransaction().commit();

	}
	
	public void updateWork(int workId, Work work) {
		em.getTransaction().begin();
		Work w = em.find(Work.class, workId);
		w.setName(work.getName());
		em.merge(w);
		em.getTransaction().commit();

	}
	
	public void deleteWork(int workId) {
		em.getTransaction().begin();
		Work Work = em.find(Work.class, workId);
		em.remove(Work);
		em.getTransaction().commit();
	}

	public Work findByWorkId(int workId) {
		em.getTransaction().begin();
		Query query = em.createQuery("select w from Work w where w.workId=:workId");
		query.setParameter("workId", workId);
		Work work = (Work) query.getSingleResult();
		em.getTransaction().commit();

		return work;
	}
	public Work findByContractorId(int contractorId){
		em.getTransaction().begin();
		Query query = em.createQuery("select c from Work c where c.contractorId=:contractorId");
		query.setParameter("contractorId", contractorId);
		Work work = (Work) query.getSingleResult();
		em.getTransaction().commit();
		return work;
		
	}


	public List<Work> findAllWork() {
		em.getTransaction().begin();
		Query query = em.createQuery("select w from Work w");
		List<Work> work = (List<Work>) query.getResultList();
		em.getTransaction().commit();
		return work;
	}
}
