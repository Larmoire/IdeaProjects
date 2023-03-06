import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA8 {

       @Test
    fun `A8`() {
        var uml = UMLChecker(A8::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC, "b", "B8") },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("b", "B8", KVisibility.PRIVATE) },
            { uml.methodNumber(0) },
        )
    }

    @Test
    fun `B8`() {
        var uml = UMLChecker(B8::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC) },
            { uml.attributeNumber(1, strict = true) },
            { uml.attributeCheck("aa", "kotlin.Array<A8?>", KVisibility.PRIVATE) },
            { uml.methodNumber(1) },
            { uml.methodCheck("addA", "kotlin.Boolean") },
            { uml.methodCheckParams("addA", "a", "A8") },
        )
    }
}