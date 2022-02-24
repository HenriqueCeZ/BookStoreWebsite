package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	private UserDAO userDAO;

	public UserServices() {

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);

	}

	public void listUser(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();

		request.setAttribute("listUsers", listUsers);
		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

	}

	public void createUser(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");

		// response.getWriter().println("Email: " + email );
		// response.getWriter().println("Fullname: " + fullname );
		// response.getWriter().println("password: " + password );
		Users newUser = new Users(email, fullname, password);

		userDAO.create(newUser);
	}

}