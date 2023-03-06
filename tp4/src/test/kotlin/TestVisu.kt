import javax.swing.*;
import java.awt.*;

fun main() {
    var fenetre = Fenetre("Exercice 1  - question 2")

    var p = Point(10, 10)
    fenetre.ajouter(p)
    fenetre.ajouter(p.translater(Vecteur(Point(10,5),Point(30,15))))
    fenetre.ajouter(p.translater(Vecteur(dest = Point(30,40))))

    var r = Rectangle(Point(20,30), Point (60,50))
    fenetre.ajouter(r)
    fenetre.ajouter(r.translater(Vecteur(dest = Point(10,30))))
    fenetre.ajouter(Rectangle(Point(45,45), Point(30, 40)))

    fenetre.montrer()
}

class Fenetre (titre : String) : JFrame(titre) {

    var points = arrayListOf<Point>()
    var rectangles = arrayListOf<Rectangle>()

    init {
        getContentPane().add(Tableau(points, rectangles))
        val dim = Dimension(900, 900)
        setPreferredSize(dim)
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
    }

    fun ajouter(p : Point) {
        points.add(p)
    }

    fun ajouter(r : Rectangle) {
        rectangles.add(r)
    }

    fun montrer() {
        pack()
        setVisible(true)
    }
}

class Tableau(
        val points : ArrayList<Point>,
        val rectangles : ArrayList<Rectangle>) : JPanel() {

    init {
        setBackground(Color.WHITE)
    }

    override fun paintComponent(g : Graphics) {
        super.paintComponent(g)
        val ancienneCouleur = g.getColor()
        g.setColor(Color.LIGHT_GRAY)
        for (x in 0 until 1000 step 10) {
            g.drawLine(x, 0, x, 1000)
        }
        for (y in 0 until 1000 step 10) {
            g.drawLine(0, y, 1000, y)
        }
        g.setColor(Color.RED);
        for (r in rectangles) {
            dessinerRectangle(r, g)
        }
        g.setColor(Color.BLUE);
        for(p in points) {
            dessinerPoint(p, g)
        }
        g.setColor(ancienneCouleur);
    }


    private fun dessinerPoint(p : Point, g : Graphics) {
        val x : Int = (p.x * 10)
        val y : Int = (p.y * 10)
        g.drawLine(x-5,y,x+5,y)
        g.drawLine(x,y-5,x,y+5)
        g.drawString(p.toString(), x-10, y-10)
    }

    fun dessinerRectangle(r : Rectangle, g : Graphics) {
        dessinerPoint(r.sommets[0], g)
        g.drawLine(r.sommets[0].x *10, r.sommets[0].y *10,
            r.sommets[1].x *10, r.sommets[1].y *10)
        dessinerPoint(r.sommets[1], g)
        g.drawLine(r.sommets[1].x *10, r.sommets[1].y *10,
            r.sommets[2].x *10, r.sommets[2].y *10)
        dessinerPoint(r.sommets[2], g)
        g.drawLine(r.sommets[2].x *10, r.sommets[2].y *10,
            r.sommets[3].x *10, r.sommets[3].y *10)
        dessinerPoint(r.sommets[3], g)
        g.drawLine(r.sommets[3].x *10, r.sommets[3].y *10,
            r.sommets[0].x *10, r.sommets[0].y *10)
    }
}


