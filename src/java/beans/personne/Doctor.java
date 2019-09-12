package beans.personne;

import javax.ejb.Stateless;
import javax.persistence.Entity;

/**
 *
 * @author suuynyuy
 * This class represents all the general doctors in the 
 * insurance society.
 */
@Entity
@Stateless
public class Doctor extends Personne{	
    public Doctor() {
        super();
    }
}
