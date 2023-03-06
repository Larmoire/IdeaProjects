import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlPoint {

    val uml = UMLChecker(Point::class)

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
            "x", "kotlin.Int", "y", "kotlin.Int"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeNumber(2) },
            { uml.attributeCheck("x", "kotlin.Int", KVisibility.PUBLIC) },
            { uml.attributeCheck("y", "kotlin.Int", KVisibility.PUBLIC) },
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodNumber(2) },
            { uml.methodCheck("toString", "kotlin.String", isOpenOrOverride = true) },
            { uml.methodCheckParams("toString") },
            { uml.methodCheck("translater", "Point") },
            { uml.methodCheckParams("translater", "v", "Vecteur") },
        )
    }


}