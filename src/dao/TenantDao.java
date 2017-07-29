package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Tenant;
import model.Tenant;

public class TenantDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Y3844644");
	EntityManager em = null;

	public TenantDao() {
		em = factory.createEntityManager();
	}

	public void createTenant(Tenant tenant) {
		em.getTransaction().begin();
		em.persist(tenant);
		em.getTransaction().commit();

	}

	public void updateTenant(int tenantId, Tenant tenant) {
		em.getTransaction().begin();
		Tenant t = em.find(Tenant.class, tenantId);
		t.setFirstName(tenant.getFirstName());
		t.setLastName(tenant.getLastName());
		t.setOtherNames(tenant.getOtherNames());
		t.setEmail(tenant.getEmail());
		t.setPropertyId(tenant.getPropertyId());

		em.merge(t);
		em.getTransaction().commit();

	}

	public void deleteTenant(int tenantId) {
		em.getTransaction().begin();
		Tenant tenant = em.find(Tenant.class, tenantId);
		em.remove(tenant);
		em.getTransaction().commit();
	}


	public Tenant findByTenantId(int tenantId) {
		em.getTransaction().begin();
		Query query = em.createQuery("select t from Tenant t where t.tenantId=:tenantId");
		query.setParameter("tenantId", tenantId);
		Tenant tenant = (Tenant) query.getSingleResult();
		em.getTransaction().commit();

		return tenant;
	}

	public List<Tenant> findAllTenants() {
		em.getTransaction().begin();
		Query query = em.createQuery("select t from Tenant t");
		List<Tenant> tenants = (List<Tenant>) query.getResultList();
		em.getTransaction().commit();
		return tenants;
	}
}
