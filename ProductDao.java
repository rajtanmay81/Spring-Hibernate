package ztask;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {
	
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
		
		public void selectAllProduct() {
			EntityTransaction et = em.getTransaction();
			Query query=em.createQuery("select p from product p");
			List<Product>li=query.getResultList();
			System.out.println(li);
			
			for (Product P : li) {
				System.out.println(P.getPid()+" "+P.getPname()+" "+P.getPrice());
				
			}
		}
		
		public void DeleteProduct(int pid) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Product p=em.find(Product.class,pid);
			em.remove(p);
			
			et.commit();
			System.out.println("product deleted successfully"+p);

		}
		
		public void findProduct(int id) {
			EntityTransaction et = em.getTransaction();
			Product  p = em.find(Product.class, id);
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice());
		}
		
		public void updateProduct(int id,Product pd) {
	EntityTransaction et = em.getTransaction();
		
			et.begin();
			Product  p = em.find(Product.class, id);
			em.merge(pd);
			et.commit();
			
	}
		
}	

