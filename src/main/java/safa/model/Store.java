package safa.model;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Store {
	
	@Id
	@Column(updatable=false)
	private String name;
	
	protected Store(){}
	
	public Store(String storeName) {
		checkNotNull(storeName, "Cannot create store with null name.");
		name = storeName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Store [name=").append(name).append("]");
		return builder.toString();
	}
}
