import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class TestUsageCamion {

    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    val robin = Personne(nom = "Dick", prenom = "Grayson")
    var batmobile05 = Voiture(mod = "Batmobile Tumbler", coul = "noire")
    var batmobile66 = Voiture(mod = "Batmobile 1966", coul = "noire")
    var batmobile89 = Voiture("Burton's Batmobile", "noire")
    var batvan = Camion(places = 3)

    @BeforeEach
    fun initTest() {
        batmobile05.acheter(acheteur = batman)
        batmobile66.acheter(batman)
        batmobile89.acheter(robin)
    }

    @Test
    fun camionInit() {
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertTrue(batvan.estVide()) }
        )
    }

    @Test
    fun chargement1voiture() {
        assertTrue(batvan.charger(voitureTransportee=batmobile66))
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }



    @Test
    fun chargement1voiture2fois() {
        batvan.charger(voitureTransportee=batmobile66)
        assertFalse(batvan.charger(voitureTransportee=batmobile66))
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }

    @Test
    fun chargement2voitures() {
        batvan.charger(batmobile66)
        assertTrue(batvan.charger(batmobile89))
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }
    
    @Test
    fun chargement2voitures_1_2fois1() {
        batvan.charger(batmobile66)
        assertFalse(batvan.charger(batmobile66))
        batvan.charger(batmobile89)
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }

    @Test
    fun chargement2voitures_1_2fois2() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        assertFalse(batvan.charger(batmobile66))
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }

    @Test
    fun chargement3voitures() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        assertTrue(batvan.charger(batmobile05))
        assertAll(
            { assertTrue(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }

    @Test
    fun chargement3voitures_dechargement1() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        batvan.charger(batmobile05)
        assertEquals(batmobile05, batvan.decharger())
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }

    @Test
    fun chargement3voitures_dechargement3() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        batvan.charger(batmobile05)
        assertEquals(batmobile05, batvan.decharger())
        assertEquals(batmobile89, batvan.decharger())
        assertEquals(batmobile66, batvan.decharger())
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertTrue(batvan.estVide()) }
        )
    }

    @Test
    fun chargement3voitures_dechargement4() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        batvan.charger(batmobile05)
        assertEquals(batmobile05, batvan.decharger())
        assertEquals(batmobile89, batvan.decharger())
        assertEquals(batmobile66, batvan.decharger())
        assertNull(batvan.decharger())
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertTrue(batvan.estVide()) }
        )
    }

    @Test
    fun chargement3voitures_dechargement3_rechargement1() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        batvan.charger(batmobile05)
        batvan.decharger()
        batvan.decharger()
        batvan.decharger()
        assertTrue(batvan.charger(batmobile05))
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertFalse(batvan.estVide()) }
        )
    }

    @Test
    fun chargement3voitures_dechargement3_rechargement1_dechargement1() {
        batvan.charger(batmobile66)
        batvan.charger(batmobile89)
        batvan.charger(batmobile05)
        batvan.decharger()
        batvan.decharger()
        batvan.decharger()
        assertTrue(batvan.charger(batmobile05))
        assertEquals(batmobile05, batvan.decharger())
        assertAll(
            { assertFalse(batvan.estPlein()) },
            { assertTrue(batvan.estVide()) }
        )
    }
}