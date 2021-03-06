package biblioj

import java.sql.Timestamp

class Auteur {
	
	String	nom
	String	prenom
	Timestamp version
	
	static hasMany = [auteurLivres : AuteurLivre]
		
    static constraints = {
		nom nullable : false, blank : false
		prenom nullable : true, blank : false
    }
	
	public String toString() {
		return "" + nom + " " + prenom
	}
}
