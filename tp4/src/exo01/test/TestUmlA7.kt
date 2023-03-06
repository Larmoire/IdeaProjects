import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlABC {

    @Test
    fun `A7`() {
        var uml = UMLChecker(A7::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC) },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("b", "B7?", KVisibility.PRIVATE) },
            { uml.methodNumber(1) },
            { uml.methodCheck("setB") },
            { uml.methodCheckParams("setB", "b", "B7") },
        )
    }
   
    @Test
    fun `B7`() {
        var uml = UMLChecker(B7::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC, "a", "A7") },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("a", "A7", KVisibility.PRIVATE) },
            { uml.methodNumber(0) },
        )
    }
}