import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA3 {

    @Test
    fun `A3`() {
        var uml = UMLChecker(A3::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC,"b", "B3") },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("b", "B3", KVisibility.PRIVATE) },
            { uml.methodNumber(0) },
        )
    }

    @Test
    fun `B3`() {
        var uml = UMLChecker(B3::class)
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