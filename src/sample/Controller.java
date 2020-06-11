package sample;

import javafx.application.Preloader;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
class Combination {
    String array[];
    int positions;
    static  String selected=null;
    int counter = 0;
    String result[];
    ListView<String> listView;
    Rectangle rect;
 public  Combination()
 {

 }
    public Combination(String array[], int positions, ListView<String> listView, Rectangle rect) {
        this.array = array;
        this.positions = positions;
        this.listView = listView;
        result = array;
        this.rect = rect;


    }

    String main_result = "";



   public void permutationwithrep()
   {
       if(main_result.length()==positions)
       {
           counter++;
           listView.getItems().add(main_result);
           return;
       }


       for(int i=0;i<array.length;i++)
       {
           main_result+=array[i];
           permutationwithrep();
           main_result=main_result.substring(0,main_result.length()-1);
       }
   }
   public  void permutationwithoutrep(int index)
   {
       if(index==positions)
       {

           counter++;
           String data = "(";
           for (int i = 0; i < positions; i++) {
               data += result[i] + ",";

           }
           data += ")";
           listView.getItems().add(data);
           return;
       }
       for(int i=index;i<result.length;i++)
       {

           String temp=result[i];
           result[i]=result[index];
           result[index]=temp;
          permutationwithoutrep(index+1);
           String temp1=result[i];
           result[i]=result[index];
           result[index]=temp1;


       }
   }
   public  void combinationwithrep(int op)
   {
       if (main_result.length() == positions) {
           counter++;
           listView.getItems().add(main_result);
           return;
       }

       for (int i = op; i < array.length; i++) {

           main_result += array[i];
           combinationwithrep(i);
           main_result = main_result.substring(0, main_result.length() - 1);
       }
   }
}
public class Controller {
@FXML
    TextField n;
@FXML
TextField p;
@FXML
ComboBox  <String>combo;
@FXML
    ListView <String> listview;
@FXML
    ProgressBar progress;
@FXML
    Rectangle rect;
@FXML
    Label counter;
public void triggered(ActionEvent event)
{

    listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    if(n.getText().equals("")||p.getText().equals("")||p.getText().equals("Enter Data")||p.getText().equals("Enter Data"))
    {
        n.setText("Enter Data");
        p.setText("Enter Data");
        listview.setStyle("-fx-background-color:white");
        rect.setFill(Color.BLACK);
        progress.setVisible(false);
    }
    else {
 Combination main=null;
        if (Combination.selected==null)
        {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Hey, Select Your Choice First !!! ",new ButtonType("Okay"));
            alert.show();
        }
        else {


            listview.setStyle("-fx-background-color:yellow");
            LinearGradient gradient=new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE,new Stop(0, Color.RED),new Stop(0.6,Color.YELLOW));
            rect.setFill(gradient);
            String array[]=n.getText().split(",");
            int positions=Integer.parseInt(p.getText());
            main=new Combination(array,positions,listview,rect);
            progress.setVisible(true);

            if(Combination.selected.equals("Permutation With Repetition"))
            {
            main.permutationwithrep();
            counter.setText("# Of Outcomes : "+main.counter);

            }
            else if(Combination.selected.equals("Permutation Without Repetition"))
            {
                main.permutationwithoutrep(0);
                counter.setText("# Of Outcomes : "+main.counter);

            }
            else
            {
               main.combinationwithrep(0);
               counter.setText("# Of Outcomes : "+main.counter);
            }
        }

    }

}
public void clear(ActionEvent event)
{

    ObservableList<String> list=FXCollections.observableArrayList();
    listview.setItems(list);
    listview.setStyle("-fx-background-color:white");
    rect.setFill(Color.BLACK);
    counter.setText("# Of Outcomes : NA");
    progress.setVisible(false);
}

}
