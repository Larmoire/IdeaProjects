class Voiture(mod:String,coul:String) {
    private var modele:String
    private var couleur:String
    private var proprietaire:Personne?= null
    private var parking:Parking?=null
    init{
        this.modele=mod
        this.couleur=coul
    }
    fun acheter(acheteur:Personne){
        proprietaire = acheteur
    }
    fun repeindre(nouvelleCouleur:String){
        couleur = nouvelleCouleur
    }
    fun donneInformations():String{
        if (proprietaire==null)  {
            return "Voiture $modele de couleur $couleur"
        }
        else return "Voiture $modele de couleur $couleur, propriété de ${proprietaire!!.donneNomComplet()}"
    }
    fun estGaree():Boolean{
        return parking != null
    }
    fun garerDans(unParking: Parking):Boolean{
        if (parking==null){
            var place:Int? = unParking.donnePremierePlaceLibre()
            if (place!=null){
                parking = unParking
                unParking.stationner(place,this)
                return true
            }
            return false
        }
        return false
    }
    fun quitterStationnement():Boolean{
        if (parking!=null){
            parking!!.libererPlace(this)
            parking = null
            return true
        }
        return false
    }
}