package entite;

import entite.Bon_De_Commande;
import entite.etat_Facture;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
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
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-19T18:20:53")
>>>>>>> schellen
@StaticMetamodel(Facture.class)
public class Facture_ { 

    public static volatile SingularAttribute<Facture, Double> montant_Facture;
    public static volatile ListAttribute<Facture, Bon_De_Commande> bon_De_Commandes;
    public static volatile SingularAttribute<Facture, Integer> pourcentage_paiement_Facture;
    public static volatile SingularAttribute<Facture, Long> id;
    public static volatile SingularAttribute<Facture, Date> date_Facture;
    public static volatile SingularAttribute<Facture, etat_Facture> etat_Facture;

}