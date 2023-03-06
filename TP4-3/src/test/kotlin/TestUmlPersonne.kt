import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlPersonne {

    val uml = UMLChecker(Personne::class)

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
            "nom", "kotlin.String", "prenom", "kotlin.String"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeCheck("nom", "kotlin.String") },
            { uml.attributeCheck("prenom", "kotlin.String") },  
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodCheck("donneNomComplet", "kotlin.String") },
        )
    }


}