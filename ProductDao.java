package ztask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope ("prototype")
public class ProductDao {
	
	
//	@Qualifier("product")
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	@Autowired
	EntityManager em;
	public ProductDao(EntityManager em) {
		this.em=em;
		System.out.println("Constructor Dependency  of EntityManager");
	}
	
	public void saveProduct(Product p) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(p);
		et.commit();

	}
	
		
}
