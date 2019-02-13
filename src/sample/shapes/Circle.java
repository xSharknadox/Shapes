package sample.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape{
    private Point start;
    private int radius;

    public Circle(Point start, int radius) {
        this.start = start;
        this.radius = radius;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(getColor());
        graphicsContext.strokeOval(start.getX(), start.getY(),radius, radius);
    }

    @Override
    public double getSquare() {
        return Math.PI*Math.pow(radius,2);
    }


    @Override
    public String toString() {
        return "Cicle\n radius - "+radius+"\n square - "+getSquare()+"\n color: "+getColorName();
    }
}
