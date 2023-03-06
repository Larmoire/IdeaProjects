import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlRectangle {

    val uml = UMLChecker(Rectangle::class)

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
            "p1", "Point", "p2", "Point"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeNumber(1) },
            { uml.attributeCheck("sommets", "kotlin.Array<Point>", KVisibility.PUBLIC) },
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodNumber(5) },
            { uml.methodCheck("toString", "kotlin.String", isOpenOrOverride = true) },
            { uml.methodCheckParams("toString") },
            { uml.methodCheck("perimetre", "kotlin.Int") },
            { uml.methodCheckParams("perimetre") },
            { uml.methodCheck("surface", "kotlin.Int") },
            { uml.methodCheckParams("surface") },
            { uml.methodCheck("deplacer") },
            { uml.methodCheckParams("deplacer", "v", "Vecteur") },
            { uml.methodCheck("translater", "Rectangle") },
            { uml.methodCheckParams("translater", "v", "Vecteur") },

        )
    }


}