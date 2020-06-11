package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class testing_controller {
    @FXML
    Button ro;
    static  int count=0;
public  void action(ActionEvent event)
{
             int value=(90*(++count));
             if(count==4)
             {
                 count=0;
             }
             if(value>180)
             {
                 ro.rotateProperty().set(value-360);


             }
             else
             {
                 ro.rotateProperty().set(value);
             }
}


}
