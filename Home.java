package project;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Home {
    Button reservebtn = new Button("Reserve");
    Button canclebtn = new Button("Cancel Reserve");
    Button displaybtn = new Button("Display Reservation");
    
    public Home(){
        reservebtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        canclebtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        displaybtn.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
    }
    
    public BorderPane mainInt(){
        //Right Rectangle
        Rectangle r2 = new Rectangle();
        Color c0 = Color.rgb(168, 218, 220);
        r2.setFill(c0);
        r2.setHeight(750);
        r2.setWidth(200);
       
        //Big Text
        Text t1 = new Text("Premium Halls");
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        //small Text
        Text t2 = new Text("All meeting halls and rooms are designed to"
                + " the highest standards of interior styling,\n" +
                "With SYRAVA hall, you can book meeting halls,"
                + " boardrooms and resources instantly - \n" +
                "whenever and wherever you like.");
        t2.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        //VBox for texts
        VBox vboxForTexts = new VBox(30);
        vboxForTexts.getChildren().addAll(t1,t2);
        vboxForTexts.setPadding(new Insets(30, 30, 30, 30));
        //StackPane for the rectangle and text
        StackPane topStack = new StackPane();
        topStack.getChildren().addAll(vboxForTexts);
        //Image
        Image image1 = new Image("https://i.pinimg.com/564x/e0/84/7e/e0847ee63b6ebcd57037a2237d656bb9.jpg");
        ImageView i1 = new ImageView(image1);
        i1.setX(150);
        i1.setY(1);
        i1.setFitHeight(800);
        i1.setFitWidth(500);
        i1.effectProperty();
        //Reserve button
        reservebtn.setMaxHeight(100);
        reservebtn.setMaxWidth(300);
        reservebtn.setMinHeight(100);
        reservebtn.setMinWidth(300);
        reservebtn.setFont(Font.font("Verdana", FontWeight.NORMAL,15));
        reservebtn.setStyle("-fx-background-color: rgb(255, 255, 255, 0.5)");
        //Cancel Reserve button
        canclebtn.setMaxHeight(100);
        canclebtn.setMaxWidth(300);
        canclebtn.setMinHeight(100);
        canclebtn.setMinWidth(300);
        canclebtn.setFont(Font.font("Verdana", FontWeight.NORMAL,15));
        canclebtn.setStyle("-fx-background-color: rgb(255, 255, 255, 0.5)");
        //Display Reservation
        displaybtn.setMaxHeight(100);
        displaybtn.setMaxWidth(300);
        displaybtn.setMinHeight(100);
        displaybtn.setMinWidth(300);
        displaybtn.setFont(Font.font("Verdana", FontWeight.NORMAL,15));
        displaybtn.setStyle("-fx-background-color: rgb(255, 255, 255, 0.5)");
        //VBox for buttons
        VBox vboxButtons = new VBox(10);
        vboxButtons.setPadding(new Insets(20,20, 20, 20));
        vboxButtons.getChildren().addAll( reservebtn, canclebtn, displaybtn);
        
        //StackPane for image and VBox
        StackPane stackForimage = new StackPane();
        stackForimage.getChildren().addAll(i1, vboxButtons);
        
        //Root BorderPane
        BorderPane root = new BorderPane();
        root.setTop(topStack);
        topStack.setStyle("-fx-background-color: rgb(160, 193, 185)");
        root.setStyle("-fx-background-color: rgb(160, 193, 185)");
        
        root.setCenter(stackForimage);
        

        HBox right = new HBox();
        right.setStyle("-fx-background-color: rgb(168, 218, 220)");
        right.getChildren().add(r2);
        root.setRight(right);
        return root;
    } 
}