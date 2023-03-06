import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.reflect.KVisibility

class TestUmlVoiture {

    val uml = UMLChecker(Voiture::class)

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
            "mod", "kotlin.String", "coul", "kotlin.String"
        )
    }

    @Test
    fun `attributs`() {
        assertAll(
            { uml.attributeCheck("modele", "kotlin.String") },
            { uml.attributeCheck("couleur", "kotlin.String") },  
            { uml.attributeCheck("proprietaire", "Personne?")}    
        )
    }

    @Test
    fun `methodes`() {
        assertAll(
            { uml.methodCheck("acheter") },
            { uml.methodCheckParams("acheter", "acheteur", "Personne") },
            { uml.methodCheck("repeindre") },
            { uml.methodCheckParams("repeindre", "nouvelleCouleur", "kotlin.String") },
            { uml.methodCheck("donneInformations") },
        )
    }


}