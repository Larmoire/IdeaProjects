import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class TestUsageParking {

    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    val robin = Personne(nom = "Dick", prenom = "Grayson")

    lateinit var batmobile : Voiture
    lateinit var batmobile66 : Voiture
    lateinit var batmobile89 : Voiture
    lateinit var batcave : Parking

    @BeforeEach
    fun initTest() {
        batmobile = Voiture(mod = "Batmobile Tumbler", coul = "noire")
        batmobile.acheter(acheteur = batman)
        batmobile66 = Voiture(mod = "Batmobile 1966", coul = "noire")
        batmobile66.acheter(batman)
        batmobile89 = Voiture("Burton's Batmobile", "noire")
        batmobile89.acheter(robin)
        batcave = Parking(placesMax = 2)
    }
    
    @Test
    fun initbatcave() {
        assertAll(
            { assertEquals(2, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertTrue(batcave.placeLibre(numeroPlace = 1)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 2)) },
            { assertFalse(batcave.placeLibre(numeroPlace = -10)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 10)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }

    @Test
    fun batcave1voiturePlace1() {
        assertTrue(batcave.stationner(voitureStationnee = batmobile, numeroPlace = 1))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }

        @Test
    fun batcave1voiturePlace0() {
        assertTrue(batcave.stationner(voitureStationnee = batmobile, numeroPlace = 0))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 1)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 0)) },
            { assertEquals(1, batcave.donnePremierePlaceLibre()) }
        )
    }

   @Test
    fun batcave1voitureKO() {
        assertFalse(batcave.stationner(voitureStationnee = batmobile, numeroPlace = 10))
        assertAll(
            { assertEquals(2, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertTrue(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }


   @Test
    fun batcave1voitureKO2() {
        assertFalse(batcave.stationner(voitureStationnee = batmobile, numeroPlace = -10))
        assertAll(
            { assertEquals(2, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertTrue(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }



    @Test
    fun batcave1voiture2foisMemePlace() {
        assertTrue(batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertFalse(batcave.stationner(voitureStationnee = batmobile, numeroPlace = 1))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }

    @Test
    fun batcave1voiture2fois2PlacesDiff() {
        assertTrue(batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertFalse(batcave.stationner(numeroPlace = 0, voitureStationnee = batmobile))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }

    @Test
    fun batcave2voituresMemePlace() {
        assertTrue(batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertFalse(batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile89))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }

    @Test
    fun batcave2voitures2places() {
        assertTrue(batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile))
        assertTrue(batcave.stationner(numeroPlace = 0, voitureStationnee = batmobile89))
        assertAll(
            { assertEquals(0, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertFalse(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertNull(batcave.donnePremierePlaceLibre()) }
        )
    }

    @Test
    fun batcave2voitures2places1placeLibereeKo() {
        batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile)
        batcave.stationner(numeroPlace = 0, voitureStationnee = batmobile89)
        assertFalse(batcave.libererPlace(batmobile66))
        assertAll(
            { assertEquals(0, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertFalse(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertNull(batcave.donnePremierePlaceLibre()) }
        )
    }

    @Test
    fun batcave2voitures2places1placeLiberee1() {
        batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile)
        batcave.stationner(numeroPlace = 0, voitureStationnee = batmobile89)
        assertTrue(batcave.libererPlace(batmobile))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertFalse(batcave.placeLibre(numeroPlace = 0)) },
            { assertTrue(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(1, batcave.donnePremierePlaceLibre()) }
        )
    }

        @Test
    fun batcave2voitures2places1placeLiberee0() {
        batcave.stationner(numeroPlace = 1, voitureStationnee = batmobile)
        batcave.stationner(numeroPlace = 0, voitureStationnee = batmobile89)
        assertTrue(batcave.libererPlace(batmobile89))
        assertAll(
            { assertEquals(1, batcave.nombreDePlacesLibres()) },
            { assertEquals(2, batcave.nombreDePlacesTotales()) },
            { assertTrue(batcave.placeLibre(numeroPlace = 0)) },
            { assertFalse(batcave.placeLibre(numeroPlace = 1)) },
            { assertEquals(0, batcave.donnePremierePlaceLibre()) }
        )
    }

}