package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;

import static java.lang.Float.NaN;

public class testing extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Parent pane= null;
        try {
            pane = FXMLLoader.load(getClass().getResource("testing_screen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* Group pane=new Group();
        Button b=new Button("Press Me");
        TextField field=new TextField();
        String a="Enter Your Name What do you do over here";
        field.setPromptText(a);
        field.setLayoutX(0);
        field.setLayoutY(0);
        b.setLayoutY(field.getLayoutY()+30);
        b.setLayoutX(field.getLayoutX()+30);
        ScrollBar bar=new ScrollBar();
        bar.setLayoutX(0);
        System.out.println(primaryStage.getWidth()+" , "+primaryStage.getHeight());
        bar.setLayoutY(primaryStage.getWidth()-bar.getWidth());
        field.setPrefWidth(a.length()*8);
        pane.getChiladren().addAll(field,b,bar);*/

        primaryStage.setScene(new Scene(pane,600,400));
        primaryStage.setTitle("Testing");
        primaryStage.show();

    }
}
