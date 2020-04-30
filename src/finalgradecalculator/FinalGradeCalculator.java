

package finalgradecalculator;

import javafx.application.Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class FinalGradeCalculator extends Application {
        TextField current = new TextField();
        TextField desired = new TextField();
        TextField worth = new TextField();
        TextField grade = new TextField();
        
    public static void main(String[] args) {
       
        Application.launch(args);
    
    }
    
    @Override
    public void start(Stage primaryStage){
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
       pane.setStyle("-fx-border-color: black; -fx-background-color: lightgrey;");
        
        Button calc = new Button("Calculate");
        GridPane.setHalignment(calc, HPos.RIGHT);
        pane.add(new Label("Current Grade: "), 0, 0);
        pane.add(current,1,0);
        pane.add(new Label("%"), 2, 0);
        pane.add(new Label("Desired Grade: "), 0, 1);
        pane.add(desired,1,1);
        pane.add(new Label("%"), 2, 1);
        pane.add(new Label("Final worth: "), 0, 2);
        pane.add(worth,1,2);
        pane.add(new Label("%"), 2, 2);
        pane.add(new Label("You Need: "), 0, 3);
        pane.add(grade,1,3);
        pane.add(new Label("%"), 2, 3);
        pane.add(calc, 1, 4);
        calc.setOnAction((ActionEvent e)->{
        getGrade();
    });
        
        Scene scene = new Scene(pane,350,250);
        primaryStage.setTitle("Final Grade Calculator");
        primaryStage.getIcons().add(new Image("https://wadethompsonortho.com/wp-content/uploads/2018/02/aplus-grade-e1518545084403.jpg"));
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void getGrade(){
        double req = Double.parseDouble(desired.getText());
        double weight = Double.parseDouble(worth.getText());
        double currentt = Double.parseDouble(current.getText());
        
        double Final_notRounded = (((req/100)-(1-(weight/100))*(currentt/100))/(weight/100))*100;
        double Final_Rounded = Math.round(Final_notRounded * 100.0) / 100.0;
        String Final_Grade = Double.toString(Final_Rounded);
        
        grade.setText(Final_Grade);
        
        
    }
    
}
