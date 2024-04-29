/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import static javafx.application.Application.launch;
import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class evalo {

    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private Circle circle4;
    private Circle circle5;

    Button btnthx = new Button("submait");
    Label temp = new Label("");

    public BorderPane Eval() {
        StackPane stackPane = new StackPane();
        StackPane st = new StackPane();
        Color b = Color.rgb(160, 193, 185);
        
        String style1 = "-fx-background-color: rgba(255, 255, 255, 0.5);-fx-border-color:rgba(112, 160, 175, 1); -fx-border-width:2 ";
        String style = "-fx-background-color: rgb(112, 160, 175);-fx-border-color: rgb(112, 160, 175); -fx-border-width: 2px;-fx-text-fill: rgb(241, 250, 238);";
        Font font = Font.font("Courier New", FontWeight.BOLD, 34);
        Font font1 = Font.font("Courier New", FontWeight.BOLD, 40);
        
        btnthx.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        
        circle1 = createCircle1(Color.GRAY);
        circle2 = createCircle1(Color.GRAY);
        circle3 = createCircle1(Color.GRAY);
        circle4 = createCircle1(Color.GRAY);
        circle5 = createCircle1(Color.GRAY);
        Label hint = new Label("Press from 1 to 5 to evaluate our service");
        Label lab1 = new Label("1");
        Label lab2 = new Label("2");
        Label lab3 = new Label("3");
        Label lab4 = new Label("4");
        Label lab5 = new Label("5");
        lab1.setFont(font1);
        lab2.setFont(font1);
        lab3.setFont(font1);
        lab4.setFont(font1);
        lab5.setFont(font1);

        HBox labNo = new HBox(67);
        labNo.setPadding(new Insets(12, 10, 250, 28));
        labNo.getChildren().addAll(lab1, lab2, lab3, lab4, lab5);
        //cc.getChildren().add(lo);
        StackPane st2 = new StackPane();

        HBox HBcirc = new HBox(12);
        HBcirc.getChildren().addAll(circle1, circle2, circle3, circle4, circle5);
        st2.getChildren().addAll(HBcirc, labNo);
        
        stackPane.getChildren().addAll(st2);
        
        Label labQu = new Label("How Was The Experince", stackPane);
        labQu.setContentDisplay(ContentDisplay.BOTTOM);
        labQu.setFont(font);
        labQu.setTextFill(Color.rgb(29, 53, 87));
        hint.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        hint.setTextFill(Color.rgb(29, 53, 87));
        btnthx.setPrefSize(150, 40);
        
        VBox VboxEvalo = new VBox(5);
        VboxEvalo.getChildren().addAll(labQu,hint);
        VboxEvalo.setAlignment(Pos.CENTER);

        Image image = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917032.png");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);

        Color c0 = Color.rgb(168, 218, 220);

        btnthx.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        HBox HBbtn = new HBox();
        HBbtn.setAlignment(Pos.CENTER);
        HBbtn.setPadding(new Insets(10, 10, 10, 10));
        btnthx.setStyle(style1);
        HBbtn.getChildren().add(btnthx);

        temp.setAlignment(Pos.CENTER);
        temp.setFont(font);
        temp.setTextFill(Color.rgb(29, 53, 87));
        HBox HBmsg = new HBox();
        HBmsg.getChildren().add(temp);
        HBmsg.setPadding(new Insets(10, 10, 250, 10));
        HBmsg.setAlignment(Pos.TOP_CENTER);

        VBox VBbtmsg = new VBox(30);

        VBbtmsg.getChildren().addAll(HBbtn,HBmsg);

        VBbtmsg.setStyle(style);
        BorderPane bp = new BorderPane();
        bp.setCenter(VboxEvalo);

        bp.setBottom(VBbtmsg);

        bp.setBackground(new Background(new BackgroundFill(b, CornerRadii.EMPTY, Insets.EMPTY)));

        addKeyEventHandler(bp);

        return bp;
    }

    private Circle createCircle1(Color color) {
        Circle circle = new Circle(40);
        circle.setFill(color);
        return circle;
    }

    private void addKeyEventHandler(BorderPane bp) {
        bp.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.DIGIT1) {
                circle1.setFill(Color.RED);
                circle2.setFill(Color.GRAY);
                circle3.setFill(Color.GRAY);
                circle4.setFill(Color.GRAY);
                circle5.setFill(Color.GRAY);
                temp.setText("THANK YOU FOR YOUR TIME");
            } else if (event.getCode() == KeyCode.DIGIT2) {
                circle2.setFill(Color.CORAL);
                circle1.setFill(Color.GRAY);
                circle3.setFill(Color.GRAY);
                circle4.setFill(Color.GRAY);
                circle5.setFill(Color.GRAY);
                temp.setText("THANK YOU FOR YOUR TIME");
            } else if (event.getCode() == KeyCode.DIGIT3) {
                circle3.setFill(Color.YELLOW);
                circle2.setFill(Color.GRAY);
                circle1.setFill(Color.GRAY);
                circle4.setFill(Color.GRAY);
                circle5.setFill(Color.GRAY);
                temp.setText("THANK YOU FOR YOUR TIME");
            } else if (event.getCode() == KeyCode.DIGIT4) {
                circle4.setFill(Color.YELLOWGREEN);
                circle2.setFill(Color.GRAY);
                circle3.setFill(Color.GRAY);
                circle1.setFill(Color.GRAY);
                circle5.setFill(Color.GRAY);
                temp.setText("THANK YOU FOR YOUR TIME");
            } else if (event.getCode() == KeyCode.DIGIT5) {
                circle5.setFill(Color.GREEN);
                circle2.setFill(Color.GRAY);
                circle3.setFill(Color.GRAY);
                circle4.setFill(Color.GRAY);
                circle1.setFill(Color.GRAY);
                temp.setText("THANK YOU FOR YOUR TIME");
            }
        });
    }

}
