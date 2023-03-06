class Rectangle(p1: Point, p2: Point) {
// TODO
    public var sommets : Array<Point>
    init{
        sommets = arrayOf(p1, (Point(p1.x,p2.y)), p2, (Point(p2.x,p1.y)) )
    }

    fun surface(): Int {
        return kotlin.math.abs(sommets[2].x - sommets[0].x) * kotlin.math.abs(sommets[2].y - sommets[0].y)
    }

    fun perimetre(): Int {
        return kotlin.math.abs(sommets[2].x - sommets[0].x) * 2 + kotlin.math.abs(sommets[2].y - sommets[0].y)*2
    }

    fun deplacer(v: Vecteur) {
        var x1 = sommets[0].x
        var x2 = sommets[2].x
        var y1 = sommets[0].y
        var y2 = sommets[2].y
        sommets[0]= Point(x1 + v.distanceX(), y1 + v.distanceY())
        sommets[1]= Point(x1+v.distanceX(),y2+v.distanceY())
        sommets[2]= Point(x2+v.distanceX(),y2+v.distanceY())
        sommets[3]= Point(x2+v.distanceX(),y1+v.distanceY())
    }

    fun translater(v: Vecteur): Rectangle {
        var x1 = sommets[0].x
        var x2 = sommets[2].x
        var y1 = sommets[0].y
        var y2 = sommets[2].y
        
        return Rectangle(Point(x1+v.distanceX(),y1+v.distanceY()),Point(x2+v.distanceX(),y2+v.distanceY()))
    }
    
    override fun toString(): String {
        return "[${sommets[0]}${sommets[1]}${sommets[2]}${sommets[3]}]"
    }
}