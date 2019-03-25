/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Devis;
import entite.Historique_Question;
import entite.Utilisateur_Hardis;
import facade.AgenceFacadeLocal;
import facade.Bon_De_CommandeFacadeLocal;
import facade.Condition_ContractuelleFacadeLocal;
import facade.DevisFacadeLocal;
import facade.Historique_EchangeFacadeLocal;
import facade.Historique_QuestionFacade;
import facade.Historique_QuestionFacadeLocal;
import facade.InterlocuteurFacadeLocal;
import facade.LivrableFacadeLocal;
import facade.OffreFacadeLocal;
import facade.Periode_DisponibleFacadeLocal;
import facade.PrestationFacadeLocal;
import facade.Profil_MetierFacadeLocal;
import facade.ServiceFacadeLocal;
import facade.UtilisateurFacadeLocal;
import facade.Utilisateur_HardisFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import entite.Utilisateur;
<<<<<<< HEAD
import facade.Historique_ConsultantFacadeLocal;
=======
import java.util.Date;
>>>>>>> LabranchedAlleau

/**
 *
 * @author thoma
 */
@Stateless
public class gestionHardis implements gestionHardisLocal {

    @EJB
    private Historique_ConsultantFacadeLocal historique_ConsultantFacade;

    @EJB

    private UtilisateurFacadeLocal utilisateurFacade1;

    private Historique_QuestionFacadeLocal historique_QuestionFacade;

    @EJB
    private DevisFacadeLocal devisFacade1;


    @EJB
    private Historique_EchangeFacadeLocal historique_EchangeFacade;

    @EJB
    private InterlocuteurFacadeLocal interlocuteurFacade;

    @EJB
    private LivrableFacadeLocal livrableFacade;

    @EJB
    private OffreFacadeLocal offreFacade;

    @EJB
    private Periode_DisponibleFacadeLocal periode_DisponibleFacade1;

    @EJB
    private PrestationFacadeLocal prestationFacade;

    @EJB
    private Profil_MetierFacadeLocal profil_MetierFacade;

    @EJB
    private Periode_DisponibleFacadeLocal periode_DisponibleFacade;

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @EJB
    private DevisFacadeLocal devisFacade;

    @EJB
    private Condition_ContractuelleFacadeLocal condition_ContractuelleFacade;

    @EJB
    private Bon_De_CommandeFacadeLocal bon_De_CommandeFacade;

    @EJB
    private AgenceFacadeLocal agenceFacade;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



    

    @Override
    public List listeDevis() {
        return devisFacade.listeDevis();
    }

    @Override
    public List ListeQuestion(Devis d) {
        return devisFacade.ListeQuestions(d);
    }

    @Override
    public Historique_Question RechercheQuestion(long id) {
        return historique_QuestionFacade.RechercheQuestion(id) ;
    }

    @Override
    public void setReponse(long id, String reponse) {
        historique_QuestionFacade.setReponse(id, reponse);
    }

    @Override
    public List GetUtilisateurParOffre(long idOffre) {
        List <Utilisateur> ListeUtilisateurParOffre = utilisateurFacade.GetUtilisateurParOffre(idOffre);
        return ListeUtilisateurParOffre;
    }

    @Override
<<<<<<< HEAD
    public List ListeMetier(Utilisateur User) {
        return profil_MetierFacade.ListeMetier(User);
    }

    @Override
    public List ListeToutLesMetier() {
        return profil_MetierFacade.listeProfilMetier();
    }

    @Override
    public void CreerHistoriqueConsultant(Utilisateur_Hardis gest, Devis devis, String fct) {
        historique_ConsultantFacade.CreerHistoriqueConsultant(gest, devis, fct);
    }

    @Override
    public List rechercherUtilisateurHardisNom(String Nom) {
       return utilisateur_HardisFacade.rechercherUtilisateurHardisNom(Nom);
=======
    public void creerDateDispo(Utilisateur_Hardis user, Date Datedebut, Date Daefin) {
        periode_DisponibleFacade.creerPeriode(Datedebut, Daefin, user);
>>>>>>> LabranchedAlleau
    }

    
    
}
