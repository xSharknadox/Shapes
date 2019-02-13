package sample.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Quadrangle extends Shape {
    private List<Line> lines = new ArrayList<>();

    protected Quadrangle(Point p1, Point p2, Point p3, Point p4) {
        this.lines.add(new Line(p1, p2));
        this.lines.add(new Line(p2, p3));
        this.lines.add(new Line(p3, p4));
        this.lines.add(new Line(p4, p1));
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        for(Line line:this.getLines()){
            line.drawLine(graphicsContext, getColor());
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
