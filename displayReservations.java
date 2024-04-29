/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.hibernate.Query;
import org.hibernate.Session;

public class displayReservations {

    Label revNo = new Label("Enter your Reservation Number: ");
    TextField TFreservationNo = new TextField();
    Button DisplayReserveBtn = new Button("Display");
    Button DisplayHomebtn = new Button("Home Page");
    Label invoice = new Label();

    ObservableList<reservation> obReservation = FXCollections.observableArrayList();
    ObservableList<Integer> obReservationNo = FXCollections.observableArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<reservation> rList = null;

    public displayReservations() {
        Image image = new Image("https://cdn-icons-png.flaticon.com/128/3917/3917032.png");
        ImageView iv = new ImageView(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        DisplayHomebtn.setGraphic(iv);
        DisplayHomebtn.setContentDisplay(ContentDisplay.TOP);
        DisplayHomebtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        DisplayHomebtn.setAlignment(Pos.CENTER);

    }

    public BorderPane displayInvoice() {

        BorderPane invoiceDetails = new BorderPane();

        HBox HBoxforbtnl = new HBox(10);
        HBoxforbtnl.getChildren().addAll(revNo, TFreservationNo, DisplayReserveBtn);
        HBoxforbtnl.setAlignment(Pos.TOP_LEFT);
        HBoxforbtnl.setPadding(new Insets(30, 30, 30, 30));

        invoiceDetails.setTop(HBoxforbtnl);
        invoiceDetails.setCenter(invoice);
        invoiceDetails.setPadding(new Insets(60, 60, 60, 60));
        invoiceDetails.setBottom(DisplayHomebtn);
        //Styling
        DisplayReserveBtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        DisplayHomebtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        TFreservationNo.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        HBoxforbtnl.setStyle("-fx-background-color: rgb(112, 160, 175)");
        invoiceDetails.setStyle("-fx-background-color: rgb(160, 193, 185)");

        invoice.setTextFill(Color.rgb(29, 53, 87));
        invoice.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        invoice.setAlignment(Pos.BASELINE_LEFT);
        return invoiceDetails;
    }

    public void valdateReser() {
//     TFreservationNo.clear();
//      invoice.setText("Enter the number to display the Reservation Details");
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String queryStr = "from reservation";
        Query query = session.createQuery(queryStr);
        rList = query.list();
        obReservation.setAll(rList);
        session.close();

        for(reservation r : rList) {
            obReservationNo.add(r.getreservationNo());
        }
        try{
        Integer index = obReservationNo.indexOf(Integer.parseInt(TFreservationNo.getText()));

        System.out.println("this is the: " + index);
        reservation cusreservation = obReservation.get(index);


        String invo = "Reservation Details: \nOrnaization Name: " + cusreservation.getOrganizationName()
                + "\nReservation Number: " + cusreservation.getreservationNo()
                + "\nConference Type: " + cusreservation.getConferenceType()
                + "\nGuests No: " + cusreservation.getGuestsNo()
                + "\nDate: " + cusreservation.getDate()
                + "\nHall No: " + cusreservation.getHallNo()
                + "\nservices: " + cusreservation.getservices()
                + "\nTotal Price: " + cusreservation.getTotalPrice();

        invoice.setText(invo);

        }
         catch(ArrayIndexOutOfBoundsException exception){
                   invoice.setText("RESERVAION NUMBER NOT EXIST");
                   invoice.setTextFill(Color.RED);
         }
    }
    public void clearForm() {
        invoice.setText("");
        TFreservationNo.clear();

    }
}