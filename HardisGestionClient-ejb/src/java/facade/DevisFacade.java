/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entite.Agence;
import entite.Client;
import entite.Devis;
import entite.Historique_Consultant;

import entite.Historique_Question;

import entite.Prestation;
import entite.statut_Devis;
import entite.Service;
import entite.Utilisateur_Hardis;
import entite.statut_Devis;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class DevisFacade extends AbstractFacade<Devis> implements DevisFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevisFacade() {
        super(Devis.class);
    }

    @Override
    public List<Devis> listeDevis() {
        String txt = "SELECT d FROM Devis AS d";
        Query req = getEntityManager().createQuery(txt);
        List<Devis> liste = req.getResultList();
        return liste;
    }
    
    

    @Override
    public void demandeDevisClient(String zoneLibre, Client Client, Service service) {
        Devis brouillonDevisClient = new Devis();
        brouillonDevisClient.setLeClient(Client);
        brouillonDevisClient.setFormulaire_Client(zoneLibre);
        brouillonDevisClient.setStatut(statut_Devis.a_affecter);

        em.persist(brouillonDevisClient);
    }

    @Override
    public void affecterDevisAuReferentLocal(Devis devis) {
        Agence agenceDuClient = devis.getLeClient().getlEntreprise().getlAgence();
        double delegationMax = 0;
        double temp = 0;
        List<Utilisateur_Hardis> consultantDeLAgence = agenceDuClient.getLesUtilisateur_Hardis();
        Utilisateur_Hardis consultantEnCours = null;
        Utilisateur_Hardis referentLocal = null;
        for (int i=0; i<consultantDeLAgence.size(); i++)
        {
            consultantEnCours = consultantDeLAgence.get(i);
            temp = consultantEnCours.getPlafond_Delegation();
            if( temp>delegationMax)
            {
                referentLocal = consultantEnCours;
                delegationMax = temp;
            }
        }
        Historique_Consultant referent = new Historique_Consultant();
        referent.setLeDevis(devis);
        referent.setLeConsultant(referentLocal);
        referent.setFonctionConsultant("chef de projet");
        devis.getLaPrestation().setNom_Responsable(referentLocal.getNom_Utilisateur());
        devis.getLaPrestation().setMail_Responsable(referentLocal.getMail_Connexion());
        em.persist(referent);
        em.merge(devis);
    }

    @Override
    public Devis rechercheDevis(long id) {
        Devis result;
        String txt = "SELECT d FROM Devis AS d WHERE d.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Devis)req.getSingleResult();
        return result;
    }


    @Override
    public List ListeQuestions(Devis d) {
        List<Historique_Question> result;
        String txt = "SELECT ql FROM Historique_Question AS ql WHERE ql.leDevis=:d";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("d", d);
        result = req.getResultList();
        return result;
    }

    @Override
    public void ModifDevisA_traiter(long id, int montant) {
        Devis d = rechercheDevis(id);
        d.setMontant_Devis(montant);
        d.setStatut(statut_Devis.envoye);
        em.merge(d);
    }

    @Override
    public void ModifDevisEn_negociation(long id, int montant, Date dateinter) {
        Devis d = rechercheDevis(id);
        d.setMontant_Devis(montant);
        d.setDate_Intervention(dateinter);
        d.setStatut(statut_Devis.valide);
        em.merge(d);
    
    }
   
    @Override
    public void modifierDevis(double montant, Devis d, String zoneLibre) {
        if(d.getMontant_Devis() != montant || d.getFormulaire_Client() != zoneLibre)
        {
            d.setMontant_Devis(montant);
            d.setFormulaire_Client(zoneLibre);
            d.setMotif_Refus(zoneLibre);
            d.setStatut(statut_Devis.en_negociation);
            em.merge(d);
        }
    }

    @Override
    public void accepterDevis(Devis Devis) {
        Devis.setStatut(statut_Devis.valide);
        em.merge(Devis);
    }

    @Override
    public List<Devis> listDevisAtraiter(long id) {
        String txt = "SELECT h FROM Historique_Consultant h JOIN h.leDevis d JOIN d.leClient c WHERE d.statut =:statut AND c.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        req = req.setParameter("statut", statut_Devis.envoye);
        List<Devis> liste = req.getResultList();
        return liste;
    }
 
    @Override
    public void refuserDevis(Devis Devis, String motif) {
        Devis.setMotif_Refus(motif);
        Devis.setStatut(statut_Devis.refuse);
        em.merge(Devis);    
    }

    @Override
    public void proposerDateetConsultants(Devis devis, Date DateIntervention, List listeConsultants) {
    }

    @Override
    public List ListeDevisNonAttribue() {
        List<Devis> ListeDevisNonAttribue;
        statut_Devis sd = statut_Devis.a_affecter;
        String txt="SELECT d FROM Devis AS d WHERE d.statut =:sd ";
        Query req =getEntityManager().createQuery(txt);
        req=req.setParameter("sd", sd);
        ListeDevisNonAttribue = req.getResultList();
        return ListeDevisNonAttribue;
    }

    @Override
    public void AffecterDevis(Devis Devis) {
        Devis.setStatut(statut_Devis.a_traiter);
        em.merge(Devis);
    }
    
    }

    

    
    
    
