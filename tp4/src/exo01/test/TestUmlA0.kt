import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlA0 {

    @Test
    fun `A0`() {
        val uml = UMLChecker(A0::class)
        assertAll(
            { uml.isAbstract(false) },
            { uml.isOpen(false) },
            { uml.extendNothing() },
            { uml.constructorCheck(KVisibility.PUBLIC,"c", "C") },
            { uml.attributeNumber(1) },
            { uml.attributeCheck("c", "C", KVisibility.PRIVATE) },
        )
    }


}