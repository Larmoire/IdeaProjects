import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlParking {

    val uml = UMLChecker(Parking::class)

    @Test
    fun `bases`() {
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
        )
    }

    @Test
    fun `constructeur`() {
        uml.constructorCheck(
            KVisibility.PUBLIC,
            "placesMax", "kotlin.Int"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeNumber(1) },
            { uml.attributeCheck("stationnement", "kotlin.Array<Voiture?>") },    
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodNumber(6) },
            { uml.methodCheck("nombreDePlacesLibres", "kotlin.Int") },
            { uml.methodCheck("nombreDePlacesTotales", "kotlin.Int") },
            { uml.methodCheck("placeLibre", "kotlin.Boolean") },
            { uml.methodCheckParams("placeLibre", "numeroPlace", "kotlin.Int") },
            { uml.methodCheck("donnePremierePlaceLibre", "kotlin.Int?") },
            { uml.methodCheck("stationner", "kotlin.Boolean") },
            { uml.methodCheckParams("stationner", "numeroPlace", "kotlin.Int", "voitureStationnee", "Voiture") },
            { uml.methodCheck("libererPlace", "kotlin.Boolean") },
            { uml.methodCheckParams("libererPlace", "voitureGaree", "Voiture") }
        )
    }


}