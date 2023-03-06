import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA5 {

    @Test
    fun `A5`() {
        var uml = UMLChecker(A5::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC) },
            { uml.attributeNumber(1, strict = true) },
            { uml.attributeCheck("bb", "kotlin.Array<B5?>", KVisibility.PRIVATE) },
            { uml.methodNumber(1) },
            { uml.methodCheck("addB", "kotlin.Boolean") },
            { uml.methodCheckParams("addB", "b", "B5") },
        )
    }

    @Test
    fun `B5`() {
        var uml = UMLChecker(B5::class)
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