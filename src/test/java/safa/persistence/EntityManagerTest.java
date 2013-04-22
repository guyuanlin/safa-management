/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package safa.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import safa.model.Product;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 *
 * @author Steve Ebersole
 */
public class EntityManagerTest {
	private EntityManagerFactory entityManagerFactory;

	@Before
	public void setUp() throws Exception {
		// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
		// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
		entityManagerFactory = Persistence.createEntityManagerFactory( "safa.management.persistence" );
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testBasicUsage() {
		EntityManager entityManager = null;
		
		// create a couple of events...
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(new Product("2"));
		entityManager.getTransaction().commit();
		entityManager.close();

		// now lets pull events from the database and list them
//		entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		List<Product> products = entityManager.createQuery("from Product", Product.class).getResultList();
//		for(Product product : products) {
//			System.out.println(product);
//		}
//        entityManager.getTransaction().commit();
//        entityManager.close();
		
		System.out.println(200);
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Product product = entityManager.find(Product.class, "1");
		System.out.println(product);
		product.setName("短靴");
		System.out.println(product);
        entityManager.getTransaction().commit();
        entityManager.close();
	}
}
