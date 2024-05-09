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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Task1View extends StackPane implements TrackerModelSubscriber {
    Button  addDate, startWork, endWork, back , addList, next, back2, menu, clear;
    Label nameLabel, dateLabel, currentDate, hoursWorkedLabel, startWorkLabel, toLabel, endWorkLabel;
    TextField  nameText;
    ListView <String> workLog;
    GridPane  root3, root2;
    TrackerModel model;

    public Task1View(){
        //task1 page1
        root2 = new GridPane();
        root2.setAlignment(Pos.CENTER);
        root2.setPadding(new Insets(25));

        nameLabel = new Label("Project Name: ");
        root2.add(nameLabel,0,0);
        GridPane.setMargin(nameLabel, new Insets(0,0,30,0));
        nameText = new TextField();
        nameText.setPromptText("Enter your name");
        nameText.setPrefWidth(110);
        root2.add(nameText,1,0);
        GridPane.setMargin(nameText, new Insets(0,0,30,0));


        dateLabel = new Label("Date: ");
        root2.add(dateLabel,0,1);
        GridPane.setMargin(dateLabel, new Insets(0,0,30,0));
        currentDate = new Label("yyyy-mm-dd");
        root2.add(currentDate,1,1);
        GridPane.setMargin(currentDate ,new Insets(0,0,30,0));
        addDate = new Button("Add date");
        root2.add(addDate,2,1);
        GridPane.setMargin(addDate, new Insets(0,0,30,0));


        hoursWorkedLabel = new Label("Work Time: ");
        root2.add(hoursWorkedLabel,0,2);
        GridPane.setMargin(hoursWorkedLabel, new Insets(0,0,30,0));
        startWorkLabel = new Label("start work");
        root2.add(startWorkLabel,1,2);
        GridPane.setMargin(startWorkLabel, new Insets(0,0,30,30));
        toLabel = new Label("to");
        root2.add(toLabel,2,2);
        GridPane.setMargin(toLabel, new Insets(0,0,30,25));
        endWorkLabel = new Label("end work");
        root2.add(endWorkLabel,3,2);
        GridPane.setMargin(endWorkLabel, new Insets(0,0,30,0));

        startWork = new Button("Start Work");
        root2.add(startWork,1,3);
        GridPane.setMargin(startWork, new Insets(0,0,30,20));
        endWork = new Button("End Work");
        root2.add(endWork,3,3);
        GridPane.setMargin(endWork, new Insets(0,0,30,0));

        back = new Button("Back");
        root2.add(back,0,4);
        addList = new Button("Add to List");
        root2.add(addList,1,4);
        GridPane.setMargin(addList, new Insets(0,0,0,20));
        next = new Button("Next");
        root2.add(next, 3,4);
        GridPane.setMargin(next, new Insets(0,0,0,10));

        this.getChildren().add(root2);

        //task1 page2
        root3 = new GridPane();
        root3.setAlignment(Pos.CENTER);
        root3.setPadding(new Insets(25));

        workLog = new ListView<>();
        workLog.setPrefWidth(350);
        root3.add(workLog,0,0);
        GridPane.setMargin(workLog, new Insets(0,0,30,0));

        back2 = new Button("Back");
        root3.add( back2, 0,1);
        menu = new Button("Go to menu");
        root3.add(menu,1,1);

    }

    public  String toString(){
        return (nameText.getText() + ", " + model.getDate() + ", " + model.getTotalHour() + "hr " + model.getTotalMin()
        + "min " + model.getTotalSec() +  "sec");
    }

    public void task1SetModel(TrackerModel newModel){
        model = newModel;
    }

    public void task1SetController(TrackerController newController){
        addDate.setOnAction(newController :: task1Date);
        startWork.setOnAction(newController :: task1StartTime);
        endWork.setOnAction(newController :: task1EndTime);
        addList.setOnAction(newController :: task1AddList);
    }

    @Override
    public void task1DateModelUpdated(){
        currentDate.setText(model.getDate());
    }

    @Override
    public void task1StartWorkModelUpdated(){
        startWorkLabel.setText(model.getStartTime());
    }

    @Override
    public void task1EndWorkModelUpdated(){
        endWorkLabel.setText(model.getEndTime());
    }

    @Override
    public void task1AddListModelUpdated(){
        workLog.getItems().add(toString());
    }

}
