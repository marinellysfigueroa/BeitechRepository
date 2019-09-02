package com.beitech.informamos.controller;

import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.beitech.informamos.dao.CustomerDAO;
import com.beitech.informamos.dao.OrderDAO;
import com.beitech.informamos.dao.OrderDetailDAO;
import com.beitech.informamos.dao.ProductDAO;
import com.beitech.informamos.model.Customer;
import com.beitech.informamos.model.Order;
import com.beitech.informamos.model.OrderDetail;
import com.beitech.informamos.model.Product;
import com.beitech.informamos.ws.CalculateTotalValue;
import com.beitech.informamos.ws.CalculateTotalValueImplService;

@ManagedBean(name = "orderBean")
@RequestScoped
public class OrderBean {

	private String deliveryAddress = "";
	private Integer quantity;
	private Integer productId;
	private Double subtotal = 0.0;
	private Double iva = 0.0;
	private Double total = 0.0;
	private String currency="";
	private Double valueConverter = 0.0;

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}


	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}
	
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	public Double getValueConverter() {
		return valueConverter;
	}

	public void setValueConverter(Double valueConverter) {
		this.valueConverter = valueConverter;
	}

	public void  save() {
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Customer c = (Customer) sessionMap.get("customer");

		Order order = new Order();
		order.setDeliveryAddress(deliveryAddress);
		order.setCustomerId(c.getCustomerId());
		order.setTotal(total);
		Date currentDate = new Date();
		order.setCreationDate(new java.sql.Date(currentDate.getTime()));
		OrderDAO orderDAO = new OrderDAO();
		
		
		Integer orderId=orderDAO.save(order);
		
		
		//detail order
		OrderDetail od=new OrderDetail();
		od.setOrderId(orderId);
		
		//Product
		Product p=new Product();
		p=ProductDAO.find(productId);
		od.setProductId(productId);
		od.setProductDescription(p.getProductDescription());
		od.setPrice(p.getPrice());
		od.setQuantity(quantity);
		
		OrderDetailDAO.save(od);
		
	}
	public void converter()
	{
		
		CalculateTotalValue service = 	new CalculateTotalValueImplService().getCalculateTotalValueImplPort();
		this.valueConverter=service.total(172100.00, "USD");
		System.out.println("valueConverter "+this.valueConverter);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("valueConverter", valueConverter);
		
		
	}
}
