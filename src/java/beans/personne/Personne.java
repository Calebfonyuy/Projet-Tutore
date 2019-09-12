package beans.personne;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author suuynyuy
 * This class is the base class for all classes that represent humans in the 
 * whole program.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne implements Serializable{
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="Name")
	private String name;
	@Column(name="Surname")
	private String surname;
	@Column(name="Address")
	private String address;
	@Column(name="Contact")
	private String contact;
	@Column(name="Password")
	private String password;
	
	public Personne() {
		super();
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
        @Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", contact="
				+ contact + ", password=" + password + "]";
	}
}