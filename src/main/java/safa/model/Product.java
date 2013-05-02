package safa.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="products")
public class Product {

	@Id
	private String id;
	
	private String name;
	
	@OneToOne
	private Store store;
	
	@OneToOne
	private Color color;
	
	private String size;
	
	/* The product serial number */
	private String productNumber;
	
	@Column(updatable=false, nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createTime;
	
	@Column(nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date updateTime;
	
	public Product(){}
	
	public Product(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	
	@PrePersist
	protected void onCreate() {
		createTime = new Timestamp(System.currentTimeMillis());
		onUpdate();
	}

	@PreUpdate
	protected void onUpdate() {
		updateTime = new Timestamp(System.currentTimeMillis());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", name=")
				.append(name).append(", color=").append(color)
				.append(", size=").append(size).append(", productNumber=")
				.append(productNumber).append(", createTime=")
				.append(createTime).append(", updateTime=").append(updateTime)
				.append("]");
		return builder.toString();
	}
}
