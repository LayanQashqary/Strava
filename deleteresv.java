/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nd4uu
 */
public class deleteresv //extends Application 
{

    ObservableList<reservation> obReservation = FXCollections.observableArrayList();
    ObservableList<Integer> obReservationNo = FXCollections.observableArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<reservation> rList = null;
    Button homebt = new Button("Back");

    Label label = new Label("Enter The Reservation Number :");
    Label msg = new Label("");
    Font font = Font.font("Courier New", FontWeight.BOLD, 25);

    // @Override
    public VBox dele() //throws IOException {
    {

        String style1 = "-fx-background-color: rgba(255, 255, 255, 0.5);-fx-border-color:rgba(112, 160, 175, 1); -fx-border-width:2 ";
        String style4 = "-fx-background-color: rgba(244, 232, 193, 0.5);-fx-border-color:black; -fx-border-width:1 ";

        Color c = Color.rgb(29, 53, 87);
        Color b = Color.rgb(160, 193, 185);

        label.setTextFill(c);
        label.setFont(font);

        TextField textField = new TextField();
        //Button homebt = new Button("Home");

        Label label2 = new Label("Reasons Of Cancel ?");
        TextArea n = new TextArea();
        label2.setFont(font);
        label2.setTextFill(c);
        textField.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        n.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        Button button = new Button("Cancel");
        button.setTextFill(c);
        button.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        homebt.setTextFill(c);
        homebt.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");

        button.setOnAction(event -> {
            if (textField.getText().equals("")) {
                msg.setTextFill(Color.RED);
                msg.setGraphic(null);
                msg.setText("ENTER RISERVAION NUMBER!");
            } else {
                try {
                    String rnumber = textField.getText();

                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    String queryStr = "from reservation";
                    Query query = session.createQuery(queryStr);
                    rList = query.list();
                    obReservation.setAll(rList);
                    session.getTransaction().commit();

                    for (reservation r : rList) {
                        obReservationNo.add(r.getreservationNo());
                    }

                    Integer index = obReservationNo.indexOf(Integer.parseInt(textField.getText()));

                    System.out.println("this is the: " + index);
                    
                    reservation cusreservation = obReservation.get(index);
                    session.beginTransaction();
                    session.delete(cusreservation);
                    session.getTransaction().commit();
                    msg.setTextFill(Color.rgb(0, 128, 0));
                    msg.setFont(Font.font("Courier New", FontWeight.BOLD, 20));

                    msg.setText("Your Reservaion has been successfully cancelled");

                    Image image = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917032.png");
                    Image img = new Image("https://cdn-icons-png.flaticon.com/128/3472/3472620.png");
                    ImageView ver = new ImageView(img);
                    ver.setX(50);
                    ver.setY(60);
                    msg.setGraphic(ver);
                    msg.setContentDisplay(ContentDisplay.BOTTOM);

                } catch (ArrayIndexOutOfBoundsException exception) {
                    msg.setTextFill(Color.RED);
                    msg.setGraphic(null);
                    msg.setText("RESERVAION NUMBER NOT EXIST");
                 

                }

                session.close();
                textField.clear();
                n.clear();

            }
        });

        VBox root1 = new VBox(20);
        HBox btnss = new HBox(30);
        btnss.getChildren().addAll(homebt, button);
        root1.setPadding(new Insets(39));
        root1.setBackground(new Background(new BackgroundFill(b, CornerRadii.EMPTY, Insets.EMPTY)));
        root1.setAlignment(Pos.CENTER);
        root1.getChildren().addAll(msg, label, textField, label2, n, btnss);
        return root1;

    }

    public void clearForm() {
        msg.setText("");
        msg.setGraphic(null);
    }
}