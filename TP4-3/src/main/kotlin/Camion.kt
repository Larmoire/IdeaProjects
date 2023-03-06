class Camion(places:Int=0) {
    private var remorque:Array<Voiture?>
    private var placesOccupees:Int
    init{
        this.placesOccupees=places
        this.remorque = arrayOfNulls(places)
    }
    fun estPlein():Boolean{
        for (element in remorque){
            if (element == null){
                return false
            }
        }
        return true
    }
    fun estVide():Boolean{
        for (element in remorque){
            if (element !=null){
                return false
            }
        }
        return true
    }
    fun charger(voitureTransportee:Voiture):Boolean{
        if (this.estPlein()){
            return false
        }
        for (element in remorque){
            if (element == voitureTransportee){
                return false
            }
        }
        for (i in remorque.indices){
            if (remorque[i] == null){
                remorque[i] = voitureTransportee
                return true
            }
        }
        return false
    }
    fun decharger():Voiture?{
        if (this.estVide()){
            return null
        }
        for (i in remorque.size-1 downTo 0) {
            if (remorque[i] != null) {
                val voit: Voiture? = remorque[i]
                remorque[i] = null
                return voit
            }
        }
    return null
    }
    // TODO
}