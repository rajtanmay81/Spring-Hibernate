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
		p.setPid(5);
		p.setPname("Charger");
		p.setPrice(36500.00);
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		ProductDao dao=ioc.getBean(ProductDao.class);
//		dao.saveProduct(p);
//		dao.selectAllProduct();
		
//		dao.DeleteProduct(1);
//		dao.findProduct(4);
		
		Product pd = p;
		pd.setPid(5);
		pd.setPname("Cloths");
		pd.setPrice(950.00);
		dao.updateProduct(5,pd);
		
		
	}
	
	
}

