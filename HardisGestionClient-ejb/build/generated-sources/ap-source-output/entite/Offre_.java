package entite;

import entite.Devis;
import entite.Profil_Metier;
import entite.Service;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T16:47:31")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T11:01:56")

=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T17:10:48")
>>>>>>> schellen
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T09:42:31")
>>>>>>> schellen
@StaticMetamodel(Offre.class)
public class Offre_ { 

    public static volatile SingularAttribute<Offre, String> description_Offre;
    public static volatile ListAttribute<Offre, Profil_Metier> profil_Metiers;
    public static volatile SingularAttribute<Offre, String> nom_Offre;
    public static volatile ListAttribute<Offre, Devis> lesDevis;
    public static volatile ListAttribute<Offre, Service> services;
    public static volatile SingularAttribute<Offre, Long> id;

}