package sample.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Line {
    private Point p1, p2;
    private double length;


    public Line(Point p1, Point p2) {
        this.p1 = new Point(p1.getX(), p1.getY());
        this.p2 = new Point(p2.getX(), p2.getY());
        this.length = calculateLength(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    private double calculateLength(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
    }

    public double getLength() {
        return BigDecimal.valueOf(length).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void drawLine(GraphicsContext gc, Color color){
        gc.setStroke(color);
        gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public boolean checkParallelLines(Line line){
        int s = (this.getP1().getY()-this.getP2().getY())*(line.getP2().getX()-line.getP1().getX())-(line.getP1().getY()-line.getP2().getY())*(this.getP2().getX()-this.getP1().getX());
        return s == 0;
    }
}
