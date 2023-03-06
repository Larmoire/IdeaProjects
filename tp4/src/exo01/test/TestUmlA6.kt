import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA6 {

   
    @Test
    fun `A6`() {
        var uml = UMLChecker(A6::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC, "b", "B6") },
            { uml.attributeNumber(1, strict = true) },
            { uml.attributeCheck("bb", "kotlin.Array<B6?>", KVisibility.PRIVATE) },
            { uml.methodNumber(1) },
            { uml.methodCheck("addB", "kotlin.Boolean") },
            { uml.methodCheckParams("addB", "b", "B6") },
        )
    }

    @Test
    fun `B6`() {
        var uml = UMLChecker(B6::class)
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