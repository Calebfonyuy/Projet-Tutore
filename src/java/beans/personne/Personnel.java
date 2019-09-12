package beans.personne;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;

/**
 * Session Bean implementation class Personnel
 */
@Stateless
@LocalBean
@Entity
public class Personnel extends Personne implements Serializable{
       
    /**
     * @see Personne#Personne()
     */
    public Personnel() {
        super();
        // TODO Auto-generated constructor stub
    }

}
