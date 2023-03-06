class Voiture(mod:String,coul:String) {
    private var modele:String
    private var couleur:String
    private var proprietaire:Personne?= null
    init{
        this.modele=mod
        this.couleur=coul
    }
    fun acheter(acheteur:Personne){

    }
    fun repeindre(nouvelleCouleur:String){

    }
    fun donneInformations():String{
        return " "
    }
}