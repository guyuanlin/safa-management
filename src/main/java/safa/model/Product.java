package safa.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="products")
/**
 * 保存單一商品資訊
 * @author guyuan
 */
public class Product {

	@EmbeddedId
	private ProductPK _key;
	
	private String name;
	
	@OneToOne
	private Store store;
	
	/* The product serial number */
	private String productNumber;
	private int price;
	private int count;
	
	@Column(updatable=false, nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createTime;
	
	@Column(nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date updateTime;
	
	/**
	 * For JPA Reflection
	 */
	protected Product() {}
	
	public Product(ProductPK key) {
		checkNotNull(key, "Cannot create product with null key.");
		_key = key;
	}
	
	public Product(String productID, String size, String color) {
		ProductPK key = new ProductPK(productID, size, color);
		_key = key;
	}
	
	public String getID() {
		return _key.getProductID();
	}
	
	public String getColor() {
		return _key.getColor();
	}
	
	public String getSize() {
		return _key.getSize();
	}
	
	public ProductPK getKey() {
		return _key;
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
	
	public String getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		checkArgument(count >= 0, "Count 不能小於 0");
		this.count = count;
	}
	
	public void increaseCount() {
		count++;
	}
	
	public void decreaseCount() {
		count--;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public int getTotalPrice() {
		return price * count;
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
		builder.append("Product [_key=").append(_key).append(", name=").append(name)
				.append(", store=").append(store).append(", productNumber=")
				.append(productNumber).append(", price=").append(price)
				.append(", count=").append(count).append(", createTime=")
				.append(createTime).append(", updateTime=").append(updateTime)
				.append("]");
		return builder.toString();
	}
}
