import biblioj.*

class BootStrap {

    def init = { servletContext ->
		
		(new TypeDocument(intitule:"Aventure")).save()
		(new TypeDocument(intitule:"Policier")).save()
		(new TypeDocument(intitule:"Science-Fiction")).save()
		
		(new Livre(titre:"Livre_1",nombreExemplaires:5,nombreExemplairesDisponibles:3,typeDocument:TypeDocument.findByIntitule("Aventure"))).save()
		(new Livre(titre:"Livre_2",nombreExemplaires:5,nombreExemplairesDisponibles:3,typeDocument:TypeDocument.findByIntitule("Policier"))).save()
		(new Livre(titre:"Livre_3",nombreExemplaires:5,nombreExemplairesDisponibles:3,typeDocument:TypeDocument.findByIntitule("Policier"))).save()
		(new Livre(titre:"Livre_4",nombreExemplaires:5,nombreExemplairesDisponibles:3,typeDocument:TypeDocument.findByIntitule("Science-Fiction"))).save()
		(new Livre(titre:"Livre_5",nombreExemplaires:5,nombreExemplairesDisponibles:3,typeDocument:TypeDocument.findByIntitule("Science-Fiction"))).save()
		
		(new Auteur(nom:"Nom_Auteur_1", prenom: "Prenom_Auteur_1")).save()
		(new Auteur(nom:"Nom_Auteur_2", prenom: "Prenom_Auteur_2")).save()
		(new Auteur(nom:"Nom_Auteur_3", prenom: "Prenom_Auteur_3")).save()
		
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_1"),livre:Livre.findByTitre("Livre_1"))).save()
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_2"),livre:Livre.findByTitre("Livre_1"))).save()
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_3"),livre:Livre.findByTitre("Livre_1"))).save()
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_2"),livre:Livre.findByTitre("Livre_2"))).save()
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_3"),livre:Livre.findByTitre("Livre_3"))).save()
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_3"),livre:Livre.findByTitre("Livre_4"))).save()
		(new AuteurLivre(auteur:Auteur.findByNom("Nom_Auteur_3"),livre:Livre.findByTitre("Livre_5"))).save()

    }
    def destroy = {
    }
}
