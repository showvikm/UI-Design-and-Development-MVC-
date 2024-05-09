/*
Name: Showvik Mazumdar
NSID: shm959
Student Number:11235944
Course Number: Cmpt381
 */

package com.example.assignment2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Task3View extends StackPane implements Tracker3ModelSubscriber{
    Button  back4, submit2;
    Label setTimerLabel, minuteLabel;
    Text warning;
    TextField  timerText;
    GridPane root5;
    TrackerModel model;

    public Task3View(){
        //task3
        root5 = new GridPane();
        root5.setAlignment(Pos.CENTER);
        root5.setPadding(new Insets(25));

        setTimerLabel = new Label("Set your Time: \n (in minutes)");
        root5.add(setTimerLabel,1,0);
        GridPane.setMargin(setTimerLabel, new Insets(0,0,30,0));

        timerText = new TextField();
        timerText.setPromptText("min");
        timerText.setPrefWidth(50);
        root5.add(timerText, 1,1);
        GridPane.setMargin(timerText, new Insets(0,0,30,0));
        minuteLabel= new Label("min");
        root5.add(minuteLabel,2,1);
        GridPane.setMargin(minuteLabel, new Insets(0,0,30,10));

        back4 = new Button("Go to menu");
        root5.add(back4,0,2);
        submit2 = new Button("Submit");
        root5.add(submit2,2,2);

        warning = new Text();
        root5.add(warning, 1,3);

        this.getChildren().add (root5);
    }

    public void task3SetModel(TrackerModel newModel){
        model = newModel;
    }


    public void task3SetController(TrackerController newController){
        submit2.setOnAction(e -> newController.timerCount(timerText.getText()));
    }

    @Override
    public void task3TimerModelUpdated(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = model.getTimer();
            @Override
            public void run() {
                if (counter > 0){
                    warning.setText(counter + " seconds");
                    counter--;
                }
                else{
                    warning.setText("Your time is up!");
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate (task,0,1000);

    }

}
