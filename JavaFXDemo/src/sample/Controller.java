package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.util.Random;

public class Controller {

    @FXML
    Canvas _canvas;

    @FXML
    ColorPicker _colorPicker;

    int shape = 0;
    Color color = Color.BLUE;
    Random random = new Random();

    public void initialize() {
        GraphicsContext graphicsContext = _canvas.getGraphicsContext2D();
        _canvas.setOnMouseDragged(event -> {
            double size = 18;
            double x = event.getX() - size / 2;
            double y = event.getY() - size / 2;

            color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            graphicsContext.setFill(color);
            switch (shape){
                case 0: graphicsContext.fillOval(x, y, size, size); break;
                case 1: graphicsContext.fillRect(x, y, size, size); break;
            }

        });
    }

    public void clear(ActionEvent actionEvent) {
        GraphicsContext graphicsContext = _canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.clearRect(0, 0, _canvas.getWidth(), _canvas.getHeight());
    }


    public void onShapeChange(ActionEvent actionEvent) {
        String geometry = ((Button)actionEvent.getSource()).getText();

        if (geometry.equals("Oval")){
            shape = 0;
        }else if(geometry.equals("Rectangle")){
            shape = 1;
        }

    }

    public void onExitClick(ActionEvent actionEvent) {

        System.exit(0);

    }
}
