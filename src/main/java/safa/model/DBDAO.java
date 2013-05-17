package safa.model;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.common.base.Optional;

public class DBDAO {
	
	private static final String PERSISTENCE_FILE = "safa.management.persistence";
	private static DBDAO INSTANCE = new DBDAO();
	
	private EntityManagerFactory entityManagerFactory;
	private Optional<ArrayList<Product>> defaultProductList;
	private Optional<ArrayList<Color>> defaultColorList;
	private Optional<ArrayList<Store>> defaultStoreList;
	
	private Logger logger;
	
	private DBDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_FILE);
		defaultProductList = Optional.of(new ArrayList<Product>());
		defaultColorList = Optional.of(new ArrayList<Color>());
		defaultStoreList = Optional.of(new ArrayList<Store>());
		
		logger = Logger.getLogger(getClass());
		logger.info("DB data access object construct success.");
	}
	
	public static DBDAO getInstance() {
		return INSTANCE;
	}
	
	public void addProduct(Product product) {
		logger.info(format("Add product: %s.", product));
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
		logger.info(format("Update product: %s.", product));
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean containsProduct(ProductPK key) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			em.getTransaction().begin();
			result = !(em.find(Product.class, key) == null);
			em.getTransaction().commit();
			return result;
		} finally {
			em.close();
		}
	}
	
	public Product getProduct(ProductPK key) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Product product = null;
		try {
			em.getTransaction().begin();
			product = em.find(Product.class, key);
			em.getTransaction().commit();
			return product;
		} finally {
			em.close();
		}
	}
	
	public void deleteProduct(Product product) {
		logger.info(format("Delete product: %s.", product));
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
	
	public void addColor(Color color) {
		logger.info(format("Add color: %s.", color));
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(color);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean containsColor(String colorName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			em.getTransaction().begin();
			result = !(em.find(Color.class, colorName) == null);
			em.getTransaction().commit();
			return result;
		} finally {
			em.close();
		}
	}
	
	public Color getColor(String colorName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Color color = null;
		try {
			em.getTransaction().begin();
			color = em.find(Color.class, colorName);
			em.getTransaction().commit();
			return color;
		} finally {
			em.close();
		}
	}
	
	public List<Color> getAllColors() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Color> colors = defaultColorList.get();
		try {
			em.getTransaction().begin();
			colors = em.createQuery("from Color", Color.class).getResultList();
			em.getTransaction().commit();
			return colors;
		} finally {
			em.close();
		}
	}
	
	public void addStore(Store store) {
		logger.info(format("Add store: %s.", store));
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(store);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean containsStore(String storeName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			em.getTransaction().begin();
			result = !(em.find(Store.class, storeName) == null);
			em.getTransaction().commit();
			return result;
		} finally {
			em.close();
		}
	}
	
	public Store getStore(String storeName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Store store = null;
		try {
			em.getTransaction().begin();
			store = em.find(Store.class, storeName);
			em.getTransaction().commit();
			return store;
		} finally {
			em.close();
		}
	}
	
	public List<Store> getAllStores() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Store> stores = defaultStoreList.get();
		try {
			em.getTransaction().begin();
			stores = em.createQuery("from Store", Store.class).getResultList();
			em.getTransaction().commit();
			return stores;
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
		PropertyConfigurator.configure("conf/log4j.properties");
		DBDAO dao = DBDAO.getInstance();
		
		dao.addColor(new Color("紅色"));
		dao.addColor(new Color("黑色"));
		
		dao.addStore(new Store("店家 A"));
		dao.addStore(new Store("店家 B"));
		
		ProductPK key = new ProductPK("1234", "23.5", dao.getColor("紅色"));
		Product product = new Product(key);
		dao.addProduct(product);
		
		System.out.println(dao.getProduct(key));
		
		product.setName("球鞋");
		product.setPrice(3000);
		product.setStore(dao.getStore("店家 A"));
		dao.upateProduct(product);
		System.out.println(dao.getProduct(key));
		
//		System.out.println(dao.containsProduct("1"));
//		Product product4 = dao.getProduct("1");
//		product4.setName("2222");
//		dao.upateProduct(product4);
//		
//		colors = dao.getAllProducts();
//		for(Product product : colors) {
//			System.out.println(product);
//		}
		
//		dao.addProduct(new Product(new ProductPK("1", "23.5", new Color("紅色"))));
//		
//		List<Product> products = dao.getAllProducts();
//		for(Product product : products) {
//			System.out.println(product);
//		}
//		System.out.println(dao.containsProduct("1"));
//		Product product4 = dao.getProduct("1");
//		product4.setName("2222");
//		dao.upateProduct(product4);
//		
//		products = dao.getAllProducts();
//		for(Product product : products) {
//			System.out.println(product);
//		}
	}
}
