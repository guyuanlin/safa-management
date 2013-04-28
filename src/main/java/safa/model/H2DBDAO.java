package safa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.common.base.Optional;

public class H2DBDAO {
	
	private static final String PERSISTENCE_FILE = "safa.management.persistence";
	private static H2DBDAO INSTANCE = new H2DBDAO();
	
	private EntityManagerFactory entityManagerFactory;
	private Optional<ArrayList<Product>> defaultProductList;
	
	private H2DBDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_FILE);
		defaultProductList = Optional.of(new ArrayList<Product>());
	}
	
	public static H2DBDAO getInstance() {
		return INSTANCE;
	}
	
	public void addProduct(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public void upateProduct(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean containsProduct(String productID) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			em.getTransaction().begin();
			result = !(em.find(Product.class, productID) == null);
			em.getTransaction().commit();
			return result;
		} finally {
			em.close();
		}
	}
	
	public Product getProduct(String productID) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Product product = null;
		try {
			em.getTransaction().begin();
			product = em.find(Product.class, productID);
			em.getTransaction().commit();
			return product;
		} finally {
			em.close();
		}
	}
	
	public void deleteProduct(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public List<Product> getAllProducts() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Product> products = defaultProductList.get();
		try {
			em.getTransaction().begin();
			products = em.createQuery("from Product", Product.class).getResultList();
			em.getTransaction().commit();
			return products;
		} finally {
			em.close();
		}
	}
	
	public void close() {
		entityManagerFactory.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		H2DBDAO dao = H2DBDAO.getInstance();
		List<Product> products = dao.getAllProducts();
		for(Product product : products) {
			System.out.println(product);
		}
		System.out.println(dao.containsProduct("4"));
		Product product4 = dao.getProduct("4");
		product4.setName("2222");
		product4.setSize("23.5");
		dao.upateProduct(product4);
		
		products = dao.getAllProducts();
		for(Product product : products) {
			System.out.println(product);
		}
	}
}
