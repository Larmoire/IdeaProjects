class Point(var x: Int, var y: Int) {
    override fun toString(): String {
        return "($x,$y)"
    }
    fun translater(v: Vecteur): Point {
        return Point(x, y)
    }
}
