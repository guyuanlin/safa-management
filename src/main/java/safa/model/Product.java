package safa.model;

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

import org.hibernate.annotations.Index;

@Entity
@Table(name="products")
/**
 * 保存單一商品資訊
 * @author guyuan
 */
public class Product {

	@EmbeddedId
	private ProductPK _key;
	
	@Index(name="index")
	private String index;
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
	protected Product() {
		index = IndexGenerator.generateIndex();
	}
	
	public Product(ProductPK key) {
		checkNotNull(key, "Cannot create product with null key.");
		index = IndexGenerator.generateIndex();
		_key = key;
	}
	
	public ProductPK getKey() {
		return _key;
	}
	
	public String getIndex() {
		return index;
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
		builder.append("Product [_key=").append(_key).append(", index=")
				.append(index).append(", name=").append(name)
				.append(", store=").append(store).append(", productNumber=")
				.append(productNumber).append(", price=").append(price)
				.append(", count=").append(count).append(", createTime=")
				.append(createTime).append(", updateTime=").append(updateTime)
				.append("]");
		return builder.toString();
	}
}
