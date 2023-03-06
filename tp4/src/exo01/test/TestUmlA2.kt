import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA2{

 
    @Test
    fun `A2`() {
        val uml = UMLChecker(A2::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC) },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("c", "C?", KVisibility.PRIVATE) },
            { uml.methodNumber(1) },
            { uml.methodCheck("setC") },
            { uml.methodCheckParams("setC", "c", "C") },
        )
    }
}