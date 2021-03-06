package biblioj

import jxl.*

class LoadDataService extends Exception{

	def openExelData(){
		def myFile = new File("./web-app/data/Les 1000 titres les plus recherches en 2012.csv")
		def size = 0
		myFile.splitEachLine(';')  { fields ->
			if(size != 0){
				size++
				def type = fields[1]
				def titre = fields[3]
				def auteur = fields[4]
				def randomTotal = Math.abs(new Random().nextInt() % 10 + 1)
				def randomDispo = Math.abs(new Random().nextInt() % 10 + randomTotal)
				int min = 0;
				int max = 10;
				randomDispo = min + Math.random() * (max - min)
				randomTotal = randomDispo + Math.random() * (max - randomDispo)


				if(!(TypeDocument.findByIntitule(type)))
					(new TypeDocument(intitule:type)).save()

				def typeDoc = TypeDocument.findByIntitule(type)

				if(type != null)
					(new Livre(titre:titre,nombreExemplaires:randomTotal,nombreExemplairesDisponibles:randomDispo,typeDocument:TypeDocument.findByIntitule(type))).save()
				else
					(new Livre(titre:titre,nombreExemplaires:randomTotal,nombreExemplairesDisponibles:randomDispo)).save()

				if(auteur != null){
					def emplacement = auteur.indexOf(',')
					if(emplacement == -1){
						if (!Auteur.findByNom(auteur))
							(new Auteur(nom:auteur)).save()
						(new AuteurLivre(auteur:Auteur.findByNom(auteur),livre:Livre.findByTitreAndTypeDocument(titre, typeDoc))).save()
					}
					else{
						def nom = auteur.substring(0, emplacement)
						def prenom = auteur.substring(emplacement+1,auteur.length())
						if (!Auteur.findByNomAndPrenom(nom, prenom))
							(new Auteur(nom: nom, prenom:prenom)).save()
						(new AuteurLivre(auteur:Auteur.findByNom(auteur.substring(0, emplacement)),livre:Livre.findByTitreAndTypeDocument(titre, typeDoc))).save()
					}
				}
			}
			size++
		}

	}
}
