package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Maintenance;

public class MaintenanceDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Y3844644");
	EntityManager em = null;

	public MaintenanceDao() {
		em = factory.createEntityManager();
	}
	
	public void createMaintenance(Maintenance maintenance) {
		em.getTransaction().begin();
		em.persist(maintenance);
		em.getTransaction().commit();

	}
	
	public void updateMaintenance(int maintenanceId, Maintenance maintenance) {
		em.getTransaction().begin();
		Maintenance m = em.find(Maintenance.class, maintenanceId);
		m.setTenantId(maintenance.getTenantId());
		m.setType(maintenance.getType());
		m.setStatus(maintenance.isStatus());
		m.setDescription(maintenance.getDescription());
		em.merge(m);
		em.getTransaction().commit();

	}
	
	public void deleteMaintenance(int maintenanceId) {
		em.getTransaction().begin();
		Maintenance Maintenance = em.find(Maintenance.class, maintenanceId);
		em.remove(Maintenance);
		em.getTransaction().commit();
	}

	public Maintenance findByMaintenanceId(int maintenanceId) {
		em.getTransaction().begin();
		Query query = em.createQuery("select m from Maintenance m where m.maintenanceId=:maintenanceId");
		query.setParameter("maintenanceId", maintenanceId);
		Maintenance maintenance = (Maintenance) query.getSingleResult();
		em.getTransaction().commit();

		return maintenance;
	}


	public List<Maintenance> findAllMaintenance() {
		em.getTransaction().begin();
		Query query = em.createQuery("select m from Maintenance m");
		List<Maintenance> maintenance = (List<Maintenance>) query.getResultList();
		em.getTransaction().commit();
		return maintenance;
	}
}
