package safa.model;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

/**
 * ProductStock 的 Composite Primary Key
 * @author guyuan
 */
@Embeddable
public class ProductPK implements Serializable  {
	
	private static final long serialVersionUID = 7375640561163601788L;
	
	private String productID;
	private String size;
	@OneToOne
	private Color color;
	
	/**
	 * For JPA reflection
	 */
	ProductPK() {}
	
	public ProductPK(String productID, String size, Color color) {
		checkNotNull(productID, "Product ID cannot be null.");
		checkNotNull(size, "Size cannot be null.");
		checkNotNull(color, "Color cannot be null.");
		
		this.productID = productID;
		this.size = size;
		this.color = color;
	}
	
	public String getProductID() {
		return this.productID;
	}
	
	public String getSize() {
		return size;
	}
	
	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((productID == null) ? 0 : productID.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPK other = (ProductPK) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (productID == null) {
			if (other.productID != null)
				return false;
		} else if (!productID.equals(other.productID))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}
