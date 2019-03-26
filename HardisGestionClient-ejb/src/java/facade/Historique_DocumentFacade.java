/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Devis;
import entite.Historique_Document;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class Historique_DocumentFacade extends AbstractFacade<Historique_Document> implements Historique_DocumentFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Historique_DocumentFacade() {
        super(Historique_Document.class);
    }

    @Override
    public void creerDocument(String path, Devis leDevis) {
        Historique_Document Histo = new Historique_Document();
        Histo.setPath_Document(path);
        Histo.setLeDevis(leDevis);
        em.persist(Histo);
    }
    
    @Override
    public Historique_Document rechercheDocument(long id) {
         Historique_Document result;
        String txt = "SELECT hd FROM Historique_Document AS hd  WHERE hd.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Historique_Document)req.getSingleResult();
        return result;
    }
}
    
