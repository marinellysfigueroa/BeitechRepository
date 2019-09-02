package com.beitech.informamos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.Customer;
import com.beitech.informamos.model.Order;
import com.beitech.informamos.model.Product;

public class CustomerDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	public static Customer find(Integer id) {
		Customer c = new Customer();
		c = entity.find(Customer.class, id);
		List<Order> orderList = OrderDAO.findByCliente(c.getCustomerId());
		List<Product> productList = ProductDAO.findByCliente(c.getCustomerId());
		c.setOrderList(orderList);
		c.setProductList(productList);
		return c;
	}

	public static Customer findByEmail(String email) {
		Customer c = null;
		Query q = entity.createQuery("SELECT c FROM Customer c where email='"+email+"'");
		if(!q.getResultList().isEmpty())
		{
			c = new Customer();
			c=(Customer) q.getResultList().get(0);
			List<Order> orderList = OrderDAO.findByCliente(c.getCustomerId());
			List<Product> productList = ProductDAO.findByCliente(c.getCustomerId());
			c.setOrderList(orderList);
			c.setProductList(productList);
		}		
		return c;
	}
}
