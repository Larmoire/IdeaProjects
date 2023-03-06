import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*

class TestUsageVoiture {
    
    val batman = Personne(nom = "Wayne", prenom = "Bruce")
    lateinit var batmobile : Voiture

    @Test
    fun batmobile_init() {
        batmobile = Voiture(mod = "Batmobile Tumbler", coul = "noire")
        assertEquals("Voiture Batmobile Tumbler de couleur noire", 
                    batmobile.donneInformations())
    }

    @Test
    fun batmobile_rose() {
        batmobile = Voiture(mod = "Batmobile Tumbler", coul = "noire")
        batmobile.repeindre("rose")
        assertEquals("Voiture Batmobile Tumbler de couleur rose", 
                    batmobile.donneInformations())
    }

    @Test
    fun batmobile_batman() {
        batmobile = Voiture(mod = "Batmobile Tumbler", coul = "noire")
        batmobile.acheter(batman)
        assertEquals("Voiture Batmobile Tumbler de couleur noire, propriété de Bruce WAYNE", 
                    batmobile.donneInformations())
    }

    @Test
    fun batmobile_joker_rose() {
        batmobile = Voiture(mod = "Batmobile Tumbler", coul = "noire")
        batmobile.acheter(batman)
        batmobile.acheter(Personne("Joker", "The"))
        batmobile.repeindre("rose")
        assertEquals("Voiture Batmobile Tumbler de couleur rose, propriété de The JOKER", 
                    batmobile.donneInformations())
    }

}