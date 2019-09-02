package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.OrderDetail;

public class OrderDetailDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	public static void save(OrderDetail orderDetail) {
		entity.getTransaction().begin();
		String sqlGetId="select max(order_detail_id) from `order_detail`";
		Query q = entity.createNativeQuery(sqlGetId);
		Integer orderDetailId=(Integer) q.getResultList().get(0)+1;
		String sqlInsert="insert into order_detail (order_detail_id,order_id,product_id,product_description,price,quantity) values ("+orderDetailId+","+orderDetail.getOrderId()+","+orderDetail.getProductId()+",'"+orderDetail.getProductDescription()+"',"+orderDetail.getPrice()+","+orderDetail.getQuantity()+")";
        entity.createNativeQuery(sqlInsert).executeUpdate();
		entity.getTransaction().commit();
		
	}

	
	
	public OrderDetail find(Long id) {
		OrderDetail od = new OrderDetail();
		od = entity.find(OrderDetail.class, id);
		return od;
	}

	
	@SuppressWarnings("unchecked")
	public List<OrderDetail> listAll() {
		List<OrderDetail> listOrderDetails = new ArrayList<>();
		Query q = entity.createQuery("SELECT od FROM OrderDetail od");
		listOrderDetails = q.getResultList();
		return listOrderDetails;
	}



	@SuppressWarnings("unchecked")
	public static List<OrderDetail> findByOrderId(Integer orderId) {
		List<OrderDetail> listOrderDetails = new ArrayList<>();
		Query q = entity.createQuery("SELECT od FROM OrderDetail od WHERE od.orderId="+orderId);
		listOrderDetails = q.getResultList();
		return listOrderDetails;
	}

}
