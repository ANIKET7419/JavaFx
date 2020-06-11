package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception
    {

      AnchorPane root=FXMLLoader.load(getClass().getResource("main.fxml"));
        ComboBox<String> comboBox=new ComboBox<String>();
        comboBox.setEffect(new DropShadow());
        comboBox.setPromptText("Choose Operation");
        comboBox.setMaxWidth("Choose Operation".length()*8);
        comboBox.setLayoutX(280);
        comboBox.setLayoutY(116);
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Combination.selected=observable.getValue();
            }
        });
        ObservableList<String> list= FXCollections.observableArrayList("Permutation With Repetition","Permutation Without Repetition","Combination With Repetition");
        comboBox.setItems(list);
        root.getChildren().add(comboBox);
      Scene scene=new Scene(root,600,400);
      primaryStage.setScene(scene);
      primaryStage.setMinHeight(400);
      primaryStage.setMinWidth(600);
      primaryStage.setMaxHeight(500);
      primaryStage.setMaxWidth(600);
      primaryStage.setTitle("Combination");
      primaryStage.show();




    }


    public static void main(String[] args) {

        launch(args);
    }
}
