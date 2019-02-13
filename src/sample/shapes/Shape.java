package sample.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;

public abstract class Shape {
    private Color color;
    public abstract void draw(GraphicsContext graphicsContext);
    public abstract double getSquare();
    public  void setColor(Color color){
        this.color = color;
    };
    public Color getColor(){
        return color;
    };
    public String getColorName(){
        Field[] fields = Color.class.getFields();
        for (Field field : fields) {
            if (field.getType() == Color.class) {
                try {
                    Color color = (Color) field.get(null);
                    if(color.equals(this.color)) {
                        return field.getName();
                    }
                } catch (IllegalAccessException illegalAccessEx) {
                    System.out.println("Securty Manager does not allow access of field '"
                            + field.getName() + "'.");
                }
            }
        }
        return "";
    }
}
