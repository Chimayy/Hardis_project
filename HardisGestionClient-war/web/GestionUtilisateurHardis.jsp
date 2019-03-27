
<%-- 
    Document   : GestionUtilisateurHardis
    Created on : 14 mars 2019, 10:36:58
    Author     : Utilisateur
--%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeUser" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
       
        <%@include file="jsp_reused/style.jsp" %>
        <title>Utilisateurs Hardis</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Menu Administrateur</h1>
                    </div>

                    <hr class="my-6">

                    <h2>Liste des utilisateurs Hardis</h2>
                    <hr class="my-4">

                    <form method ="get" action="ServletAdmin" class="form-inline">
                        <div class="form-group mb-2">
                            <label for="Nom User" class="sr-only">Nom de l'utilisateur</label>
                            <input type="text" readonly class="form-control-plaintext" value="Nom de l'utilisateur">
                        </div>
                        <div class="form-group mx-sm-3 mb-2">
                            <label for="input nom" class="sr-only">Nom</label>
                            <input type ="text"  name="nom" class="form-control"  >
                        </div>
                        <button type="submit" class="btn btn-indigo mb-2">Valider</button>
                        <input type ="hidden" name="action" value="RechercherUtilisateurHardis"/>  
                    </form>
                     <% String attribut = (String) request.getAttribute("message");
                    if (!attribut.equals("")){
                    
                    %>
                    <div class="alert alert-info">
              
                      <% out.println(attribut);
                       %>
                       <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                       </div>
                       <%}%>

                    <p>
                        <a href = "ServletAdmin?action=CreationUtilisateurHardis"style="margin-bottom: 20px" class='btn btn-outline-light-green right'> Créer un nouvel utilisateur </a>
                    </p>
                    <table class='table table-bordered'>
                        <thead >
                            <tr>
                                <th>Id</th>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Mail</th>
                                <th>Mot de passe</th>
                                <th>Plafond de délégation</th>
                                <th>Profil technique</th>
                                <th>Agence</th>
                                <th>Profils métier</th>
                            </tr>
                        </thead>
                        <% List<Utilisateur_Hardis> lesUser = listeUser;
                            for (Utilisateur_Hardis user : lesUser) {%>
                        <tr> <td Width=15%><%=user.getId()%></td>
                            <td Width=15%><%=user.getNom_Utilisateur()%></td>
                            <td Width=15%><%=user.getPrenom_Utilisateur()%></td>
                            <td Width=15%><%=user.getMail_Connexion()%></td>
                            <td Width=15%><%=user.getMot_De_Passe()%></td>
                            <td Width=15%><%=user.getPlafond_Delegation()%></td>
                            <td Width=15%><%=user.getProfil_Technique()%></td>
                            <td Width=15%><%=user.getlAgence().getVille_Agence()%></td>
                            <td Width=15%><a style="color:grey"href="ServletAdmin?action=AfficherProfilsMetier&idUser=<%=user.getId()%>" >Gérer</a>
                            <td Width=15%><a style="color:grey"href="ServletAdmin?action=ModifierUtilisateurHardis&idUser=<%=user.getId()%>" >Modifier</a>
                            <td Width=15%><a style="color:grey"href="ServletAdmin?action=SupprimerUtilisateurHardis&idUser=<%=user.getId()%>">Supprimer</a>
                                <%}%>
                    </table>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="ServletAdmin" value="retour"> Retour </a>    
                   
                    
                </div>              
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>

