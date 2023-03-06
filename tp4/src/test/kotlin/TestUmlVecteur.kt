import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlVecteur {

    val uml = UMLChecker(Vecteur::class)

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
            "orig", "Point", "dest", "Point"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeNumber(2) },
            { uml.attributeCheck("origine", "Point") },
            { uml.attributeCheck("destination", "Point") },
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodNumber(3) },
            { uml.methodCheck("toString", "kotlin.String", isOpenOrOverride = true) },

            { uml.methodCheck("distanceX", "kotlin.Int") },
            { uml.methodCheckParams("distanceX")},

            { uml.methodCheck("distanceY", "kotlin.Int") },
            { uml.methodCheckParams("distanceY")},
        )
    }


}