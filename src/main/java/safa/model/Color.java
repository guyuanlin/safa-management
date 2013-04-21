package safa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Color {
	
	@Id
	@Column(updatable=false)
	private String name;
	
	public Color() {}
	
	public Color(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Color [name=").append(name).append("]");
		return builder.toString();
	}
}
