package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sample.shapes.ShapesGenerator;

public class Controller {
    @FXML
    Button newShapesButton;

    @FXML
    ScrollPane drawScrollPane;

    private int countOfShapes;

    public void generateNewShapes(){
        countOfShapes = (int)(1+Math.random()*5);
        Canvas canvas = new Canvas(500, 10+125*countOfShapes);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(2);
        gc.setFont(Font.font("TimesNewRoman", FontWeight.EXTRA_LIGHT, 11));
        ShapesGenerator shapesGenerator = new ShapesGenerator();
        int shape;
        for(int x=0; x<countOfShapes; x++){
            shape = (int)(Math.random()*5);
            Color shapeColor = getColorObject((int)(Math.random()*(ColorEnum.values().length)));
            shapesGenerator.getShapeInformation(x,shape, shapeColor, gc);
        }
        drawScrollPane.setContent(canvas);
    }

    enum ColorEnum{
        RED(Color.RED), BLUE(Color.BLUE), Gold(Color.GOLD), Aquamarine(Color.AQUAMARINE), Green(Color.GREEN), Hotpink(Color.HOTPINK), Violet(Color.VIOLET);
        private Color color;
        ColorEnum(Color color){
            this.color = color;
        }
    }

    private Color getColorObject(int colorNumber){
        return ColorEnum.values()[colorNumber].color;
    }
}
