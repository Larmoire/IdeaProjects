import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA4 {

    @Test
    fun `A4`() {
        var uml = UMLChecker(A4::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC) },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("b", "B4?", KVisibility.PRIVATE) },
            { uml.methodNumber(1) },
            { uml.methodCheck("setB") },
            { uml.methodCheckParams("setB", "b", "B4") },
        )
    }

        @Test
    fun `B4`() {
        var uml = UMLChecker(B4::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC) },
            { uml.attributeNumber(0) },
            { uml.methodNumber(0) },
        )
    }

}