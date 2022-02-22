package com.bookstore.dao;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;

	@BeforeClass
	public static void setUpClass() {

		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager = entityManagerFactory.createEntityManager();

		userDAO = new UserDAO(entityManager);

	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("javadeveloper@codejava.new");
		user1.setFullName("Não tem como");
		user1.setPassword("NTC");

		user1 = userDAO.create(user1);

		assertTrue(user1.getUserId() > 0);

	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();

		user1 = userDAO.create(user1);

		

	}
	
	@Test
	
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("nam@codejava.net");
		user.setFullName("Não tem como");
		user.setPassword("NTC");
	}

	@AfterClass
	public static void tearDownClass() {

		entityManager.close();
		entityManagerFactory.close();

	}

}
