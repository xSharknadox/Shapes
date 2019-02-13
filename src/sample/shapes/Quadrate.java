package sample.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Quadrate extends Quadrangle {

    public Quadrate(Point p1, int sideLength) {
        super(p1, new Point(p1.getX()+sideLength, p1.getY()),new Point(p1.getX()+sideLength, p1.getY()+sideLength), new Point( p1.getX(), p1.getY()+sideLength));
    }

    @Override
    public double getSquare() {
        return Math.pow(this.getLines().get(0).getLength(), 2);
    }

    @Override
    public String toString() {
        return "Quadrate\n side length -"+this.getLines().get(0).getLength()+"\n square - "+getSquare()+"\n color: "+getColorName();
    }
}
