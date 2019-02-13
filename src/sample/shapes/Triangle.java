package sample.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {
    List<Line> lines;
    private int hypotenuseLineNumber;


    public Triangle(Point p1, Point p2, Point p3) {
        this.lines = this.createLines(p1, p2, p3);
    }

    public List<Line> createLines(Point p1, Point p2, Point p3){
        List<Line> lines = new ArrayList<Line>();
        lines.add(new Line(p1, p2));
        lines.add(new Line(p2, p3));
        lines.add(new Line(p1, p3));
        return lines;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        for(Line line:lines){
            line.drawLine(graphicsContext, getColor());
        }
    }

    @Override
    public double getSquare() {
        double ab = lines.get(2).getLength();
        double ac = lines.get(1).getLength();
        double bc = lines.get(0).getLength();
        double p = (ab+ac+bc)/2;
        return Math.sqrt((p*(p-ab)*(p-ac)*(p-bc)));
    }

    public boolean checkTriangleLinesAngle(){
        boolean have = false;
        Point l1 = new Point(lines.get(0).getP2().getX()-lines.get(0).getP1().getX(), lines.get(0).getP2().getY()-lines.get(0).getP1().getY());
        Point l2 = new Point(lines.get(1).getP2().getX()-lines.get(1).getP1().getX(), lines.get(1).getP2().getY()-lines.get(1).getP1().getY());
        Point l3 = new Point(lines.get(2).getP2().getX()-lines.get(2).getP1().getX(), lines.get(2).getP2().getY()-lines.get(2).getP1().getY());
        double angle1 = (l1.getX()*l2.getX()+l1.getY()*l2.getY())/(Math.sqrt((Math.pow(l1.getX(),2)*Math.pow(l1.getY(), 2)))*Math.sqrt((Math.pow(l2.getX(),2)*Math.pow(l2.getY(), 2))));
        double angle2 = (l1.getX()*l3.getX()+l1.getY()*l3.getY())/(Math.sqrt((Math.pow(l3.getX(),2)*Math.pow(l3.getY(), 2)))*Math.sqrt((Math.pow(l3.getX(),2)*Math.pow(l3.getY(), 2))));
        double angle3 = (l3.getX()*l2.getX()+l3.getY()*l2.getY())/(Math.sqrt((Math.pow(l3.getX(),2)*Math.pow(l3.getY(), 2)))*Math.sqrt((Math.pow(l2.getX(),2)*Math.pow(l2.getY(), 2))));
        if((angle1==0)){
            hypotenuseLineNumber = 2;
            have = true;
        }else if((angle2==0)){
            hypotenuseLineNumber = 1;
            have = true;
        }else if((angle3==0)){
            hypotenuseLineNumber = 0;
            have = true;
        }
        return have;
    }

    @Override
    public String toString() {
        if(checkTriangleLinesAngle()){
            return "Triangle\n  sides:\n   first side length: "+lines.get(0).getLength()+"\n   second side length: "+lines.get(1).getLength()+"\n   third side length: "+lines.get(2).getLength()+"\n hypotenuse is line number: "+(hypotenuseLineNumber+1)+"\n square: "+getSquare()+"\n color: "+getColorName();
        }
        else {
            return "Triangle\n  sides:\n   first side length: " + lines.get(0).getLength() + "\n   second side length: " + lines.get(1).getLength() + "\n   third side length: " + lines.get(2).getLength() + "\n square: " + getSquare() + "\n color: " + getColorName() + "\n It has no hypotenuse, because it is not a rectangular triangle";
        }
    }
}
