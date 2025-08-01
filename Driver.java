package ztask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import ztask.DemoConfiguration;
import ztask.Product;

public class Driver {
	public static void main(String[] args) {
		
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		Product p = ioc.getBean(Product.class);
		p.setPid(2);
		p.setPname("Perfume");
		p.setPrice(8500.00);
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		ProductDao dao=ioc.getBean(ProductDao.class);
		dao.saveProduct(p);
		
		
		
//		EntityManager em = emf.createEntityManager();		
//		EntityTransaction et = em.getTransaction();
		
//		Product p1 = new Product();
//		p1.setPid(1);
//		p1.setPname("Ram");
//		p1.setPrice(8500.00);
//		
//		et.begin();
//
////		em.persist(h1);
////		em.persist(b1);
//		em.persist(p1);
//
//		et.commit();

		
	}
	
	
}
