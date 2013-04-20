package model;

import java.sql.Timestamp;

/**
 * 進貨的單件商品資訊
 * @author guyuan
 */
public class Purchase {
	private Product product;
	private int cost;
	private double discount = 1;
	private Timestamp time;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public int getCostAfterDiscount() {
		return (int)(cost * discount);
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
