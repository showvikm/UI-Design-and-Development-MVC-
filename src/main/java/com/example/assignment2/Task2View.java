/*
Name: Showvik Mazumdar
NSID: shm959
Student Number:11235944
Course Number: Cmpt381
 */

package com.example.assignment2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;


public class Task2View extends StackPane implements Tracker2ModelSubscriber{
     Button back3, submit, next, back, menu;
    Label projectLabel, dueDateLabel, dueTimeLabel;
    TextField  projectText, dueTimeText;
    DatePicker dueDate;
    GridPane root4, root6;
    ListView<String> reminderLog;
    TrackerModel model;

    public Task2View(){
        //task2 page1
        root4 = new GridPane();
        root4.setAlignment(Pos.CENTER);
        root4.setPadding(new Insets(25));

        projectLabel = new Label(" Project       \nName: ");
        root4.add(projectLabel,0,0);
        GridPane.setMargin(projectLabel, new Insets(0,0,30,0));
        projectText = new TextField();
        projectText.setPromptText("Enter project name");
        projectText.setPrefWidth(200);
        root4.add(projectText,1,0);
        GridPane.setMargin(projectText, new Insets(0,0,30,0));

        dueDateLabel = new Label("Due Date:\n(yyyy-mm-dd)");
        root4.add(dueDateLabel, 0,1);
        GridPane.setMargin(dueDateLabel, new Insets(0,0,30,0));
        dueDate = new DatePicker();
        dueDate.setPromptText("yyyy-mm-dd");
        root4.add(dueDate,1,1);
        GridPane.setMargin(dueDate, new Insets(0,0,30,0));

        dueTimeLabel = new Label("Due Time:\n(24 hour format)");
        root4.add(dueTimeLabel,0,2);
        GridPane.setMargin(dueTimeLabel, new Insets(0,0,30,0));
        dueTimeText = new TextField();
        dueTimeText.setPromptText("hr : min");
       root4.add(dueTimeText,1,2);
        GridPane.setMargin(dueTimeText, new Insets(0,0,30,0));


        back3 = new Button("Back");
        root4.add(back3,0,3);
        submit = new Button("Submit");
        root4.add(submit,1,3);
        GridPane.setMargin(submit, new Insets(0,0,0,60));
        next = new Button("Next");
        root4.add(next, 2,3);

        //task2 page2
        root6 = new GridPane();
        root6.setAlignment(Pos.CENTER);
        root6.setPadding(new Insets(25));

        reminderLog = new ListView<>();
        reminderLog.setPrefWidth(350);
        root6.add(reminderLog,0,0);
        GridPane.setMargin(reminderLog, new Insets(0,0,30,0));

        back = new Button("Back");
        root6.add( back, 0,1);
        menu = new Button("Go to menu");
        root6.add(menu,1,1);

        this.getChildren().add (root4);

    }

    public  String toString(){
        return "Get working on your " + projectText.getText()+ " it is due two days from " + model.getReminderDate() +
                "\n at " + dueTimeText.getText();
    }

    public void task2SetModel(TrackerModel newModel){
        model = newModel;
    }

    public void task2SetController(TrackerController newController){
        submit.setOnAction(e -> newController.task2Submit(dueDate.getValue()));
    }

    @Override
    public void task2ReminderModelUpdated(){
        reminderLog.getItems().add(toString());

    }
}
