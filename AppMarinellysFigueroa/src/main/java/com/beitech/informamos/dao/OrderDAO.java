package com.beitech.informamos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.beitech.informamos.model.Order;
import com.beitech.informamos.model.OrderDetail;

public class OrderDAO {
	static EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();


	public Integer save(Order order) {
		Integer orderId=0;
		entity.getTransaction().begin();
		String sqlGetId="select max(order_id) from `order`";
		Query q = entity.createNativeQuery(sqlGetId);
		orderId=(Integer) q.getResultList().get(0)+1;
        String sqlInsert="insert into `order` (order_id,creation_date,delivery_address,customer_id,total) values ("+orderId+",now(),'"+order.getDeliveryAddress()+"',"+order.getCustomerId()+","+order.getTotal()+")";
        entity.createNativeQuery(sqlInsert).executeUpdate();
		entity.getTransaction().commit();
		return orderId;
	}


	public static List<Order> findByCliente(Integer customer_id) {
		
		List<Order> listOrders = new ArrayList<>();
		Query q = entity.createNativeQuery("select order_id, \n" + "creation_date, delivery_address, \n"
				+ "total from `order` where customer_id=" + customer_id );

		for (Object obj : q.getResultList()) {
			Object[] object = (Object[]) obj;
			Order o = new Order();
			Integer orderId=Integer.valueOf(object[0].toString());
			o.setOrderId(orderId);
			o.setCreationDateString(object[1].toString());
			o.setDeliveryAddress(object[2].toString());
			o.setTotal(Double.parseDouble(object[3].toString()));
			
			List<OrderDetail> orderDetailList= new ArrayList<>();
			orderDetailList=OrderDetailDAO.findByOrderId(orderId);
			o.setOrderDetailList(orderDetailList);
			listOrders.add(o);
		}
		return listOrders;
	}

}
