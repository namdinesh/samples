package inno.agency;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import inno.agency.model.Agency;
import inno.agency.util.HibernateUtil;

public class TestAgency {
	
	public static void createAgency() {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Agency agency = new Agency();
		agency.setAgencyName("agency name");
		session.save(agency);
		tr.commit();
		 session.flush();
		System.out.println("Successfully inserted");
		sessFact.close();
	}
	
	public static void readRecords() {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		
		CriteriaQuery<Agency> cq = session.getCriteriaBuilder().createQuery(Agency.class);
		cq.from(Agency.class);
		List<Agency> agencyList = session.createQuery(cq).getResultList();

		for (Agency agency : agencyList) {
		
			System.out.println("Name: " + agency.getAgencyName());
		}  
		

		tr.commit();
		System.out.println("Data printed");
		 session.flush();
		sessFact.close();
	}
	public static void main(String a[]) {
		createAgency();
		readRecords();
		
		
	}
	

}
