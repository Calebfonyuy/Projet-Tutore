package beans.sante;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Stateless
public class Maladie implements Serializable {
	@Id
	@Column(name="Name")
	private String name;
	@Column(name="Description")
	private String description;
	public Maladie() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
