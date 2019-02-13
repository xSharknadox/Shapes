package sample.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class ShapesGenerator {


    public void getShapeInformation(int shapeNumber, int shape, Color shapeColor, GraphicsContext gc){
        gc.setLineWidth(2);
        switch (shape){
            case 0: Circle circle = generateCircle(shapeNumber, shapeColor); circle.draw(gc); gc.setStroke(Color.BLACK); gc.setLineWidth(0.7); gc.strokeText(circle.toString(),160, 10+shapeNumber*125);break;
            case 1: Quadrate quadrate = generateQuadrate(shapeNumber, shapeColor); quadrate.draw(gc); gc.setStroke(Color.BLACK); gc.setLineWidth(0.7); gc.strokeText(quadrate.toString(),160, 10+shapeNumber*125);break;
            case 2: Triangle triangle = generateTriangle(shapeNumber, shapeColor); triangle.draw(gc); gc.setStroke(Color.BLACK); gc.setLineWidth(0.7);gc.strokeText(triangle.toString(),160, 10+shapeNumber*125);break;
            case 3: Triangle triangle2 = generateRectangularTriangle(shapeNumber, shapeColor); triangle2.draw(gc); gc.setStroke(Color.BLACK); gc.setLineWidth(0.7);gc.strokeText(triangle2.toString(),160, 10+shapeNumber*125);break;
            case 4: Trapeze trapeze = generateTrapeze(shapeNumber, shapeColor); trapeze.draw(gc); gc.setStroke(Color.BLACK); gc.setLineWidth(0.7); gc.strokeText(trapeze.toString(),160, 10+shapeNumber*125);break;
            default: System.out.println("incorrect shape\n");
        }
    }

    private Circle generateCircle(int shapeNumber, Color shapeColor){
        boolean ls = true;
        int radius = 20;
        while (ls){
            radius = (int)(1+(Math.random()*120));
            if(radius>=20){
                ls = false;
            }
        }
        Point center =  new Point(5,5+shapeNumber*125);
        Circle circle = new Circle(center, radius);
        circle.setColor(shapeColor);
        return circle;
    }

    private Quadrate generateQuadrate(int shapeNumber, Color shapeColor){
        boolean ls = true;
        Quadrate quadrate = null;
        while (ls) {
            Point start = new Point(5, 5 + shapeNumber * 125);
            quadrate = new Quadrate(start, (int) (1 + (Math.random() * 120)));
            if(checkLinesLength(quadrate.getLines())){
                ls=false;
            }
        }
        quadrate.setColor(shapeColor);
        return quadrate;
    }

    private Triangle generateTriangle(int shapeNumber, Color shapeColor){
        boolean ls = true;
        Triangle triangle = null;
        while (ls) {
            triangle = new Triangle(new Point((int) (5 + (Math.random() * 120)), ((int) (1 + (Math.random() * 120))) + (5 + shapeNumber * 125)), new Point((int) (5 + (Math.random() * 120)), ((int) (1 + (Math.random() * 120))) + (5 + shapeNumber * 125)), new Point((int) (5 + (Math.random() * 120)), ((int) (1 + (Math.random() * 120))) + (5 + shapeNumber * 125)));
            if(checkLinesLength(triangle.lines))
                ls = false;
        }
        triangle.setColor(shapeColor);
        return triangle;
    }

    private Triangle generateRectangularTriangle(int shapeNumber, Color shapeColor){
        boolean ls = true;
        Triangle triangle = null;
        while (ls) {
            triangle = new Triangle(new Point((int) (5 + (Math.random() * 120)), ((int) (1 + (Math.random() * 120))) + (5 + shapeNumber * 125)), new Point((int) (5 + (Math.random() * 120)), ((int) (1 + (Math.random() * 120))) + (5 + shapeNumber * 125)), new Point((int) (5 + (Math.random() * 120)), ((int) (1 + (Math.random() * 120))) + (5 + shapeNumber * 125)));
            if(checkLinesLength(triangle.lines))
                if(triangle.checkTriangleLinesAngle())
                ls = false;
        }
        triangle.setColor(shapeColor);
        System.out.println("Rectangular triangle generated");
        return triangle;
    }

    private Trapeze generateTrapeze(int shapeNumber, Color shapeColor){
        Point[] points = new Point[4];
        boolean ls = true;
        Trapeze trapeze = null;
        while (ls){
            points[0] = new Point((int)(5+(Math.random()*120)), ((int)(1+(Math.random()*120)))+(5+shapeNumber*125));
            points[1] = new Point((int)(5+(Math.random()*120)), ((int)(1+(Math.random()*120)))+(5+shapeNumber*125));
            points[2] = new Point((int)(5+(Math.random()*120)), ((int)(1+(Math.random()*120)))+(5+shapeNumber*125));
            points[3] = new Point((int)(5+(Math.random()*120)), ((int)(1+(Math.random()*120)))+(5+shapeNumber*125));
            trapeze = Trapeze.createTrapeze(points[0], points[1], points[2], points[3]);
            if(trapeze!=null){
                if(checkLinesLength(trapeze.getLines()))
                ls=false;
            }
        }
        trapeze.setColor(shapeColor);
        return trapeze;
    }

    private boolean checkLinesLength(List<Line> lines){
            for(Line line:lines){
                if(line.getLength()<20) return false;
            }
            return true;
    }

}
