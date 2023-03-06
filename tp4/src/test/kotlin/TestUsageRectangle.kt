import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TestUsageRectangle {

    @ParameterizedTest
    @CsvSource(
        "10,10,20,30",
        "20,30,10,10",
        "20,30,-10,-10",
        "0,0,20,30",
        "0,0,-20,-30",
    )
    fun `init rectangle`(x1 :Int, y1 : Int, x2: Int, y2 : Int) {
        var r = Rectangle(Point(x1,y1),Point(x2,y2))
        var attendus = listOf(Point(x1,y1), Point(x1,y2),
                              Point(x2,y2), Point(x2,y1))
        for(i in 0 until 4) {
            assertAll(
                { assertEquals(attendus[i].x, r.sommets[i].x) },
                { assertEquals(attendus[i].y, r.sommets[i].y) },
            )
        }
        assertEquals("[($x1,$y1)($x1,$y2)($x2,$y2)($x2,$y1)]",r.toString())
    }

    @ParameterizedTest
    @CsvSource(
        "10,10,20,30",
        "20,30,10,10",
        "20,30,-10,-10",
        "0,0,20,30",
        "0,0,-20,-30",
    )
    fun deplaceRectangle(x1 : Int, y1 : Int,
                           x2 : Int, y2 : Int,
    ) {
        val v = Vecteur(dest = Point(x2,y2))
        var r = Rectangle(Point(x1,y1),Point(x2,y2))
        r.deplacer(v)
        var attendus = listOf(
            Point(x1+v.distanceX(),y1+v.distanceY()),
            Point(x1+v.distanceX(),y2+v.distanceY()),
            Point(x2+v.distanceX(),y2+v.distanceY()),
            Point(x2+v.distanceX(),y1+v.distanceY()))
        for(i in 0 until 4) {
            assertAll(
                { assertEquals(attendus[i].x, r.sommets[i].x) },
                { assertEquals(attendus[i].y, r.sommets[i].y) },
            )
        }
    }

    @ParameterizedTest
    @CsvSource(
        "10,10,20,30",
        "20,30,10,10",
        "20,30,-10,-10",
        "0,0,20,30",
        "0,0,-20,-30",
    )
    fun translateRectangle2(x1 : Int, y1 : Int,
                            x2 : Int, y2 : Int,
    ) {
        val v = Vecteur(dest = Point(x2,y2))
        var r = Rectangle(Point(x1,y1),Point(x2,y2))

        var r2 = r.translater(v)

        var attendus = listOf(Point(x1,y1), Point(x1,y2),
            Point(x2,y2), Point(x2,y1))
        var attendus2 = listOf(
            Point(x1+v.distanceX(),y1+v.distanceY()),
            Point(x1+v.distanceX(),y2+v.distanceY()),
            Point(x2+v.distanceX(),y2+v.distanceY()),
            Point(x2+v.distanceX(),y1+v.distanceY()))
        for(i in 0 until 4) {
            assertAll(
                { assertEquals(attendus2[i].x, r2.sommets[i].x) },
                { assertEquals(attendus2[i].y, r2.sommets[i].y) },
            )
        }
        for(i in 0 until 4) {
            assertAll(
                { assertEquals(attendus[i].x, r.sommets[i].x) },
                { assertEquals(attendus[i].y, r.sommets[i].y) },
            )
        }
    }





}