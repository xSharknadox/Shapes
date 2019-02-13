package sample.shapes;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Trapeze extends Quadrangle {

    private Trapeze(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double getSquare() {
        double[]sides = changeSides();
        double b = sides[0];
        double c = sides[1];
        double a = sides[2];
        double d = sides[3];
        return Math.sqrt(((b+c+d-a)*(a-b+c+d)*(a-b+c-d)*(a-b-c+d)))*(0.25*((b+a)/(b-a)));
    }


    private double[] changeSides(){
        double[] sides = new double[4];
        List<Line> lines = this.getLines();
        int indexB =0;
        out:
        for(int x=0; x<lines.size(); x++){
            for(int y=x+1; y<lines.size(); y++){
                if(lines.get(x).checkParallelLines(lines.get(y))){
                    if (lines.get(x).getLength() > lines.get(y).getLength()) {
                        indexB = x;
                    } else if (lines.get(x).getLength() < lines.get(y).getLength()) {
                        indexB = y;
                    }
                    break out;
                }
            }
        }
        int y = 0;
        for(int x=indexB; x<lines.size();x++){
            sides[y] = lines.get(x).getLength();
            y++;
        }
        if(y<=3){
            for(int x=0; x<indexB; x++){
                sides[y] = lines.get(x).getLength();
                y++;
            }
        }
        return sides;
    }

    public static Trapeze createTrapeze(Point p1, Point p2, Point p3, Point p4){
        List<Line> lines = new ArrayList<>() {{add(new Line(p1, p2)); add(new Line(p2, p3)); add(new Line(p3, p4)); add(new Line(p4, p1));}};
        if(checkCrossLines(p1, p2, p3, p4)) {
            if (checkHaveTwoParallels(lines)) {
                return new Trapeze(p1, p2, p3, p4);
            }
        }
        return null;
    }

    private static int[] getVectorNumber(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2){
        int[] v = new int[4];
        v[0]=(bx2-bx1)*(ay1-by1)-(by2-by1)*(ax1-bx1);
        v[1]=(bx2-bx1)*(ay2-by1)-(by2-by1)*(ax2-bx1);
        v[2]=(ax2-ax1)*(by1-ay1)-(ay2-ay1)*(bx1-ax1);
        v[3]=(ax2-ax1)*(by2-ay1)-(ay2-ay1)*(bx2-ax1);
        return v;
    }

    private static boolean checkCrossLines(Point p1, Point p2, Point p3, Point p4){
        int[] v = getVectorNumber(p1.getX(), p1.getY(), p3.getX(), p3.getY(), p2.getX(), p2.getY(), p4.getX(), p4.getY());
        return ((v[0] * v[1]) < 0) && ((v[2] * v[3]) < 0);
    }

    private static boolean checkHaveTwoParallels(List<Line> lines){
        int count=0;
        for(int x=0; x<lines.size(); x++){
            for(int y=x+1; y<lines.size(); y++){
                if(lines.get(x).checkParallelLines(lines.get(y)))
                count++;
            }
        }
        return count == 1;
    }


    @Override
    public String toString() {
        return "Trapeze\n sides:\n  first side length: "+this.getLines().get(0).getLength()+"\n  second side length: "+this.getLines().get(1).getLength()+"\n  third side length: "+this.getLines().get(2).getLength()+"\n  fourth side length: "+this.getLines().get(3).getLength()+"\n square: "+getSquare()+"\n color: "+getColorName();
    }
}
