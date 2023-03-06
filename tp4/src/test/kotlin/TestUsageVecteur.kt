import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TestUsageVecteur {


    @ParameterizedTest
    @CsvSource(
        "10,10,20,30,10,20",
        "20,30,10,10,-10,-20",
        "20,30,-10,-10,-30,-40",
        "0,0,20,30,20,30",
        "0,0,-20,-30,-20,-30",
    )
    fun `init vecteur`(x1 :Int, y1 : Int, x2: Int, y2 : Int, dx : Int, dy : Int) {
        var v = Vecteur(Point(x1,y1),Point(x2,y2))
        assertAll(
            { assertEquals(dx, v.distanceX()) },
            { assertEquals(dy, v.distanceY()) },
            { assertEquals("|-($x1,$y1)-($x2,$y2)->", v.toString())}
        )
    }

    @ParameterizedTest
    @CsvSource(
        "20,30,20,30",
        "-20,-30,-20,-30",
    )
    fun `init vecteur Dest`(x2: Int, y2 : Int, dx : Int, dy : Int) {
        var v = Vecteur(dest = Point(x2,y2))
        assertAll(
            { assertEquals(dx, v.distanceX()) },
            { assertEquals(dy, v.distanceY()) },
            { assertEquals("|-(0,0)-($x2,$y2)->", v.toString())}
        )
    }
}