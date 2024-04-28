package com.example.shapesliderapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // Stage declaration
    Stage window;

    // Scenes
    Scene scene1, scene2, scene3;

    @Override
    public void start(Stage stage) throws IOException
    {
        // initializing stage to the window
        window = stage;

        // Triangle
        Polygon triangle = new Polygon(100,200,300,200,200,100);
        triangle.setFill(Color.BLUE);
        // setting an id
        triangle.setId("triangle");

        // Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(150);
        rectangle.setHeight(100);
        rectangle.setFill(Color.GREEN);
        rectangle.setId("rectangle");

        // Circle
        Circle circle = new Circle();
        circle.setCenterX(110);
        circle.setCenterY(110);
        circle.setRadius(55);
        circle.setFill(Color.YELLOW);
        circle.setId("circle");

        // button that change color
        Button colorBtn = new Button("Change color");

        // Controls
        Button btn1 = new Button("Next");
        Button btn2 = new Button("Previous");
        // Events Handling
        btn1.setOnAction(event -> window.setScene(scene2));
        btn2.setOnAction(event -> window.setScene(scene3));
        // Layouts
        BorderPane borderPane = new BorderPane();
        // adding shapes to the layout
        borderPane.setCenter(triangle);
        borderPane.setRight(btn1);
        borderPane.setLeft(btn2);
        borderPane.setBottom(colorBtn);

        //Linking the file
        borderPane.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // button click
        colorBtn.setOnAction(event -> {
            // Set a random background color for the shape with ID Shape1
            scene1.lookup("#triangle").setStyle("-fx-fill: " + getRandomColor());
        });

        // making triangle draggable(by reference)
        borderPane.getChildren().forEach(this::Draggable);

        // adding layout to the scene
        scene1 = new Scene(borderPane, 600, 450);

        // color
        Button colorBtn1 = new Button("Change color");

        // Controls
        Button btn3 = new Button("Next");
        Button btn4 = new Button("Previous");
        // Events Handling
        btn3.setOnAction(event -> window.setScene(scene3));
        btn4.setOnAction(event -> window.setScene(scene1));
        // Layouts
        BorderPane borderPane1 = new BorderPane();
        // adding shapes to the layout
        borderPane1.setCenter(rectangle);
        borderPane1.setRight(btn3);
        borderPane1.setLeft(btn4);
        borderPane1.setBottom(colorBtn1);

        //Linking the file
        borderPane1.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // button click
        colorBtn1.setOnAction(event -> {
            // Set a random background color for the shape with ID Shape1
            scene2.lookup("#rectangle").setStyle("-fx-fill: " + getRandomColor());
        });

        // making triangle draggable(by reference)
        borderPane1.getChildren().forEach(this::Draggable);

        // adding layout to the scene
        scene2 = new Scene(borderPane1, 600, 450);

        // color changing
        Button colorBtn2 = new Button("Change color");

        // Controls
        Button btn5 = new Button("Next");
        Button btn6 = new Button("Previous");
        // Events Handling
        btn5.setOnAction(event -> window.setScene(scene1));
        btn6.setOnAction(event -> window.setScene(scene2));
        // Layouts
        BorderPane borderPane2 = new BorderPane();
        // adding shapes to the layout
        borderPane2.setCenter(circle);
        borderPane2.setRight(btn5);
        borderPane2.setLeft(btn6);
        borderPane2.setBottom(colorBtn2);

        //Linking the file
        borderPane2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // button click
        colorBtn2.setOnAction(event -> {
            // Set a random background color for the shape with ID Shape1
            scene3.lookup("#circle").setStyle("-fx-fill: " + getRandomColor());
        });

        // making a triangle draggable(by reference)
        borderPane2.getChildren().forEach(this::Draggable);

        // adding layout to the scene
        scene3 = new Scene(borderPane2, 600, 450);

        // Draggable
        triangle.setTranslateX(50);
        triangle.setTranslateY(50);

        rectangle.setTranslateX(50);
        rectangle.setTranslateX(50);

        circle.setTranslateX(50);
        circle.setTranslateY(50);

        // stage properties Default scene
        window.setTitle("Shape Slider App");
        window.setScene(scene1);
        window.show();
    }

    // declaring start values
    private  double startX;
    private  double startY;
    // node is a super class of everything
    private  void Draggable (Node node){
        // mouse when pressed
        node.setOnMousePressed(event ->{
            // a = b - c
            startX = event.getSceneX() - node.getTranslateX();
            startY = event.getSceneY() - node.getTranslateY();
        } );

        // mouse when is dragged
        node.setOnMouseDragged(event -> {
            // c = b - a
            node.setTranslateX(event.getSceneX() - startX);
            node.setTranslateY(event.getSceneY() - startY);
        });
    }

    private String getRandomColor() {
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        return String.format("#%02x%02x%02x", red, green, blue);
    }



    public static void main(String[] args) {
        launch();
    }
}