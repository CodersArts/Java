package sample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {

    @FXML
    HBox hBox1;
    @FXML
    HBox hBox2;
    @FXML
    Pane pane1;
    @FXML
    Pane pane2;
    @FXML
    Pane pane3;
    @FXML
    VBox vBox1;
    @FXML
    VBox vBox2;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;

    private Rectangle rectangle;
    private Circle circle;
    private PathTransition transition;


    public void initialize()
    {
        hBox1.setSpacing(20);
        hBox2.setSpacing(20);
        ToggleGroup tg = new ToggleGroup();

        Label label = new Label("");
        Label label1 = new Label("");

        RadioButton r1 = new RadioButton("Filled");
        RadioButton r2 = new RadioButton("Unfilled");

        ToggleGroup tg0 = new ToggleGroup();

        RadioButton x1 = new RadioButton("Filled");
        RadioButton x2 = new RadioButton("Unfilled");


        r2.setSelected(true);
        x2.setSelected(true);
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        x1.setToggleGroup(tg0);
        x2.setToggleGroup(tg0);

        RadioButton p1 = new RadioButton("Red");
        RadioButton p2 = new RadioButton("Blue");
        RadioButton p3 = new RadioButton("Green");
        RadioButton p4 = new RadioButton("Yellow");

        p1.setSelected(true);

        ToggleGroup tg1 = new ToggleGroup();
        p1.setToggleGroup(tg1);
        p2.setToggleGroup(tg1);
        p3.setToggleGroup(tg1);
        p4.setToggleGroup(tg1);


        RadioButton t = new RadioButton("Red");
        RadioButton t2 = new RadioButton("Blue");
        RadioButton t3 = new RadioButton("Green");
        RadioButton t4 = new RadioButton("Yellow");

        t.setSelected(true);

        ToggleGroup tg2 = new ToggleGroup();
        t.setToggleGroup(tg2);
        t2.setToggleGroup(tg2);
        t3.setToggleGroup(tg2);
        t4.setToggleGroup(tg2);

        hBox1.getChildren().addAll(r1,r2);
        hBox2.getChildren().addAll(x1,x2);

        hBox1.setVisible(false);
        hBox2.setVisible(false);
        vBox1.getChildren().addAll(p1,p2,p3,p4,label1);
        vBox2.getChildren().addAll(t,t2,t3,t4,label);

        vBox1.setVisible(false);
        vBox2.setVisible(false);

        button3.setDisable(true);
        button4.setDisable(true);


        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rectangle = new Rectangle(100,100);
                rectangle.setTranslateX(0);
                rectangle.setTranslateY(0);
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                hBox2.setVisible(true);
                pane2.getChildren().add(rectangle);
                button1.setDisable(true);

                if(button1.isDisable()&&button2.isDisable()) {
                    button3.setDisable(false);
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circle = new Circle(50);
                circle.setTranslateX(50);
                circle.setTranslateY(50);
                circle.setFill(Color.TRANSPARENT);
                circle.setStroke(Color.BLACK);
                hBox1.setVisible(true);

                pane1.getChildren().add(circle);
                button2.setDisable(true);

                if(button1.isDisable()&&button2.isDisable()) {
                    button3.setDisable(false);
                }
            }
        });

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioButton = (RadioButton) t1.getToggleGroup().getSelectedToggle();
                if(radioButton.getText().equals("Filled")) {
                    vBox1.setVisible(true);
                }
                else {
                    p1.setSelected(true);
                    circle.setFill(Color.TRANSPARENT);
                    circle.setStroke(Color.BLACK);
                    vBox1.setVisible(false);
                }
             }
        });

        tg0.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioButton = (RadioButton) t1.getToggleGroup().getSelectedToggle();
                if(radioButton.getText().equals("Filled")) {
                    vBox2.setVisible(true);
                }
                else {
                    t.setSelected(true);
                    rectangle.setFill(Color.TRANSPARENT);
                    rectangle.setStroke(Color.BLACK);
                    vBox2.setVisible(false);
                }
            }
        });

        tg2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

                RadioButton radioButton = (RadioButton) t1.getToggleGroup().getSelectedToggle();

                if(radioButton.getText().equals("Red")) {
                    rectangle.setFill(Color.RED);
                    label.setText("Red Square");
                }
                else if(radioButton.getText().equals("Blue")) {
                    rectangle.setFill(Color.BLUE);
                    label.setText("Blue Square");
                }
                else if(radioButton.getText().equals("Green")) {
                    rectangle.setFill(Color.GREEN);
                    label.setText("Green Square");
                }
                else {
                    rectangle.setFill(Color.YELLOW);
                    label.setText("Yellow Square");
                }

            }
        });

        tg1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

                RadioButton radioButton = (RadioButton) t1.getToggleGroup().getSelectedToggle();

                if(radioButton.getText().equals("Red")) {
                    label1.setText("Red Circle");
                    circle.setFill(Color.RED);
                }
                else if(radioButton.getText().equals("Blue")) {
                    label1.setText("Blue Circle");
                    circle.setFill(Color.BLUE);

                }
                else if(radioButton.getText().equals("Green")) {
                    label1.setText("Green Circle");
                    circle.setFill(Color.GREEN);
                }
                else {
                    label1.setText("Yellow Circle");
                    circle.setFill(Color.YELLOW);
                }

            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ellipse ellipse = new Ellipse();
                 ellipse.setCenterX(rectangle.getTranslateX());
                 ellipse.setCenterY(rectangle.getTranslateY());
                ellipse.setRadiusX(rectangle.getBoundsInLocal().getWidth() / 2.0 + 0.8971388 * 170);
                ellipse.setRadiusY(rectangle.getBoundsInLocal().getHeight() / 2.0 + 0.6029134 * 170);
                rectangle.setLayoutY(-20);
                rectangle.setLayoutX(-20);

                transition = new PathTransition();
                transition.setPath(ellipse);
                transition.setNode(circle);
                transition.setInterpolator(Interpolator.LINEAR);
                transition.setDuration(Duration.seconds(10.000017421));
                transition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                transition.setCycleCount(Timeline.INDEFINITE);
                transition.play();

                ellipse.setVisible(false);

                StackPane root = new StackPane();
                StackPane pane = new StackPane();
                pane.setBackground(new Background(new BackgroundFill(Color.WHITE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
                pane.translateXProperty().bind(circle.translateXProperty());
                pane.translateYProperty().bind(circle.translateYProperty());
                pane.setMaxSize(300, 300);
                pane.setStyle("-fx-background-color: #FFFFFF;");

                pane3.getChildren().add(rectangle);
                pane3.setLayoutX(400);
                pane3.setLayoutY(200);
                pane3.getChildren().add(pane);
                pane3.getChildren().add(ellipse);
                pane3.getChildren().add(circle);
                pane3.setVisible(true);
                button3.setDisable(true);
                button4.setDisable(false);

            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                transition.stop();
                pane3.setVisible(false);
                rectangle.setTranslateX(20);
                rectangle.setTranslateY(20);
                circle.setTranslateX(50);
                circle.setTranslateY(50);
                pane2.getChildren().add(rectangle);
                pane1.getChildren().add(circle);
                button3.setDisable(false);
                button4.setDisable(true);
            }
        });



    }
}
