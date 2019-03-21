/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;
import facade.ClientFacadeLocal;
import entite.Devis;
import entite.Service;
import facade.ClientFacadeLocal;
import facade.DevisFacadeLocal;
import facade.Prestation_Non_StandardFacadeLocal;
import facade.Prestation_StandardFacadeLocal;
import facade.ServiceFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionClient implements gestionClientLocal {
    
    @EJB
    private ClientFacadeLocal ClientFacade;
    
    
    
        

    @EJB
    private Prestation_StandardFacadeLocal prestation_StandardFacade;

    @EJB
    private Prestation_Non_StandardFacadeLocal prestation_Non_StandardFacade;

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private DevisFacadeLocal devisFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Client> ListeClient() {
        return ClientFacade.listeClient();
    }
    public void demandeDevis(String zoneLibre, Client client, long idService) {
        Service service = serviceFacade.rechercheService(idService);
        
        //si le service fait partie de la liste des services standards, on lie le brouillon de devis à une nouvelle prestation standard
        if(service.getNom_Service().equals("prestation standard")||service.getNom_Service().equals("prestation standard 2"))
        {
            prestation_StandardFacade.creerPrestaS(service);
        }
        if(service.getNom_Service().equals("prestation non standard")||service.getNom_Service().equals("prestation non standard 2"))
        {
            prestation_Non_StandardFacade.creerPrestaNS(service);
        }
        devisFacade.demandeDevisClient(zoneLibre, client, service);
        }

    @Override
    public void affecterDevisReferentLocal(long idDevis) {
        Devis devis = devisFacade.rechercheDevis(idDevis);
        devisFacade.affecterDevisAuReferentLocal(devis);
    }

    @Override
    public Client rechercheClient(long id) {
      Client c =  clientFacade.rechercheClient(id);
      return c;
    }

    

    @Override
    public List<Devis> listeDevis() {
        return devisFacade.listeDevis();
    }

    @Override
    public Devis rechercheDevis(long idDevis) {
        return devisFacade.rechercheDevis(idDevis);
    }

    @Override
    public void modifierDevis(String zoneLibre, double montant, Devis Devis) {
        devisFacade.modifierDevis(montant, Devis, zoneLibre);
    }

    @Override
    public void accepterDevisClient(long idDevis) {
        Devis devisAccepte = devisFacade.rechercheDevis(idDevis);
        devisFacade.accepterDevis(devisAccepte);
    }

    @Override
    public void refuserDevis(long idDevis, String motif) {
        Devis devisRefuse = devisFacade.rechercheDevis(idDevis);
        devisFacade.refuserDevis(devisRefuse, motif);
    }

    @Override
    public List<Devis> devisAtraiter(long id) {
        return devisFacade.listDevisAtraiter(id);
    }
    
}
