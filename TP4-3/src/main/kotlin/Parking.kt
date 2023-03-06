class Parking(placesMax:Int) {
    private var stationnement:Array<Voiture?>
    init {
        this.stationnement = arrayOfNulls(placesMax)
    }
    fun nombreDePlacesLibres():Int{
        var count:Int = 0
        for (i in (0..stationnement.size-1)){
            if (stationnement[i]==null){
                count++
            }
        }
        return count
    }
    fun nombreDePlacesTotales():Int{
        return stationnement.size
    }
    fun placeLibre(numeroPlace:Int):Boolean{
        if (numeroPlace < stationnement.size && (numeroPlace>=0)){
            return (stationnement[numeroPlace]==null)
        }
        return false
    }
    fun donnePremierePlaceLibre():Int?{
        for (i in (0..stationnement.size-1)){
            if (stationnement[i]==null){
                return i
            }
        }
        return null
    }
    fun stationner(numeroPlace: Int,voitureStationnee: Voiture):Boolean {
        if (!stationnement.contains(voitureStationnee)) {
            if (placeLibre(numeroPlace)) {
                stationnement[numeroPlace] = voitureStationnee
                return true
            }
            return false
        }
        return false
    }
    fun libererPlace(voitureGaree: Voiture):Boolean{
        for (i in (0..stationnement.size-1)){
            if (stationnement[i]==voitureGaree){
                stationnement[i]=null
                return true
            }
        }
        return false
    }
}