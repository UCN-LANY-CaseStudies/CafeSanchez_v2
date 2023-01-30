package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private int id;
	private String customerName;
	private Date date;
	private String status;
	private List<Orderline> orderlines;

	public static final String STATUS_NEW = "New";
	public static final String STATUS_ACTIVE = "Active";
	public static final String STATUS_FINISHED = "Finished";

	public int getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void addOrderline(Orderline ol) {
		orderlines.add(ol);
	}

	public Order() {
		super();
		this.date = new Date();
		this.status = STATUS_NEW;
		this.orderlines = new ArrayList<Orderline>();
	}

	public Order(int id) {
		super();
		this.id = id;
		this.orderlines = new ArrayList<Orderline>();
	}

	@Override
	public String toString() {
		int qty = 0;
		for (Orderline ol : orderlines) {
			qty += ol.getQuantity();
		}
		return customerName + ": " + qty + " cups";
	}

	public float getTotalPrice() {
		float result = 0;
		for (Orderline ol : orderlines) {
			result += ol.getQuantity() * ol.getProduct().getPrice();
		}
		return result;
	}
}
