package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.Product;

public class ProductDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	public static List<Product> findByCliente(Integer customerId) {
		List<Product> listProducts = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM CustomerProduct cp, Product p where cp.productId=p.productId and cp.customerId="+customerId);
		listProducts = q.getResultList();
		return listProducts;
	}

	public static Product find(Integer productId) {
		Product p = new Product();
		p = entity.find(Product.class, productId);
		return p;
	}

}
