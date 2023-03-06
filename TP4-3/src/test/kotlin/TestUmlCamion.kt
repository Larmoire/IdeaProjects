import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlCamion {

    val uml = UMLChecker(Camion::class)

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
            "places", "kotlin.Int"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeCheck("placesOccupees", "kotlin.Int") },
            { uml.attributeCheck("remorque", "kotlin.Array<Voiture?>")}    
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodCheck("estPlein") },
            { uml.methodCheck("estVide") },
            { uml.methodCheck("charger") },
            { uml.methodCheckParams("charger", "voitureTransportee", "Voiture") },
            { uml.methodCheck("decharger") },
        )
    }


}