/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Agence;
import entite.Consentement_RGPD;
import entite.Entreprise;
import entite.Offre;
import entite.Service;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionAdminLocal {

    public void creationUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif);

    public void modificationUtilisateurHardis(long id, String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif);

    public List<Utilisateur_Hardis> affichageUtilisateursHardis();

    public Utilisateur_Hardis rechercherUtilisateurHardisMail(String mail);

    public List<Utilisateur_Hardis> rechercherUtilisateurHardisNom(String nom);

    public List<Utilisateur_Hardis> recherchercherUtilisateurHardisId(long id);

    public void suppressionUtilisateurHardis(long id);

    public List<Entreprise> affichageEntreprises();

    public Entreprise rechercherEntrepriseParSiret(String siret);

    public Utilisateur rechercherUtilisateurHardisParId(long id);

    public void creationEntreprise(String cp, String nom, String siret, String rue, String ville, Agence agence);

    public Agence rechercherAgenceParVille(String ville);

    public List<Agence> affichageAgences();

    public List<Agence> rechercherAgenceParId(long id);

    public List<Entreprise> rechercherEntrepriseParNom(String nom);

    public List<Entreprise> rechercherEntrepriseParId(long id);

    public void suppressionEntreprise(long id);

    public void modificationEntreprise(long id, String nom, String siret, String cp, String adresse, String ville, Agence agence);

    public void creationAgence(String cp, String pays, String adresse, String ville);

    public void suppressionAgence(long id);

    public List<Entreprise> rechercherEntrepriseParAgence(Agence agence);

    public void modificationAgence(long id, String cp, String pays, String adresse, String ville);

    public List<Service> affichageServices();

    public List<Offre> affichageOffres();

    public List<Offre> rechercherOffreParId(long id);

    public void creationService(String description, String nom, double cout, Offre offre);

    public List<Service> rechercherServiceParId(long id);

    public void modificationService(long id, String nom, String description, double cout, Offre offre);

}