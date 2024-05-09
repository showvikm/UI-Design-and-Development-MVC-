/*
Name: Showvik Mazumdar
NSID: shm959
Student Number:11235944
Course Number: Cmpt381
 */

package com.example.assignment2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TimeTracker extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button workTracker, reminder, timeRestrictor;
        Label chooseTask;
        GridPane mainGrid;
        StackPane rootMenu, task1StackPane, task2StackPane, task3StackPane;

        // creates instance of the other classes
        Task1View task1View = new Task1View();
        Task2View task2View = new Task2View();
        Task3View task3View = new Task3View();

        // creates stack pane for the classes
        rootMenu = new StackPane();
        task1StackPane = new StackPane();
        task2StackPane = new StackPane();
        task3StackPane = new StackPane();

        // adds the classes to stack pane
        task1StackPane.getChildren().add(task1View);
        task2StackPane.getChildren().add(task2View);
        task3StackPane.getChildren().add(task3View);

        //creates model and controller
        TrackerModel model = new TrackerModel();
        TrackerController controller = new TrackerController();

        //connect view and model
        task1View.task1SetModel(model);
        task2View.task2SetModel(model);
        task3View.task3SetModel(model);

        //connect view and controller
        task1View.task1SetController(controller);
        task2View.task2SetController(controller);
        task3View.task3SetController(controller);

        //connect controller and model
        controller.setModel(model);

        //connect model to view
        model.task1AddSubscriber(task1View);
        model.task2AddSubscriber(task2View);
        model.task3AddSubscriber(task3View);

        //menu page
        mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);

        chooseTask = new Label("Choose a task you want to do: ");
        chooseTask.setFont(Font.font(20));
        mainGrid.add(chooseTask,0,0);
        GridPane.setMargin(chooseTask,new Insets(0,0,20,0));

        workTracker = new Button("Work Tracker");
        mainGrid.add(workTracker,0,1);
        GridPane.setMargin(workTracker,new Insets(0,0,10,90));

        reminder = new Button("Reminder");
        mainGrid.add(reminder,0,2);
        GridPane.setMargin(reminder,new Insets(0,0,10,103));

        timeRestrictor = new Button("Time Restrictor");
        mainGrid.add(timeRestrictor,0,3);
        GridPane.setMargin(timeRestrictor,new Insets(0,0,10,90));

        rootMenu.getChildren().add(mainGrid);


        // creates and configures a new scene
        Scene menuScene = new Scene(rootMenu, 500,500);
        Scene task1p1Scene = new Scene(task1StackPane,450,300);
        Scene task1p2Scene = new Scene(task1View.root3,500,500);
        Scene task2p1Scene = new Scene(task2StackPane,500,500);
        Scene task2p2Scene = new Scene(task2View.root6, 500,500);
        Scene task3Scene = new Scene(task3StackPane,400,400);

        // changes to different scenes
        //scene changes for task1
        workTracker.setOnAction((ActionEvent e) -> stage.setScene(task1p1Scene));
        task1View.back.setOnAction((ActionEvent e) -> stage.setScene(menuScene));
        task1View.next.setOnAction((ActionEvent e) -> stage.setScene(task1p2Scene));
        task1View.back2.setOnAction((ActionEvent e) -> stage.setScene(task1p1Scene));
        task1View.menu.setOnAction((ActionEvent e) -> stage.setScene(menuScene));
        //scene changes for task2
        reminder.setOnAction((ActionEvent e) -> stage.setScene(task2p1Scene));
        task2View.next.setOnAction((ActionEvent e) -> stage.setScene(task2p2Scene));
        task2View.back3.setOnAction((ActionEvent e) -> stage.setScene(menuScene));
        task2View.back.setOnAction((ActionEvent e) -> stage.setScene(task2p1Scene));
        task2View.menu.setOnAction((ActionEvent e) -> stage.setScene(menuScene));
        //scene changes for task3
        timeRestrictor.setOnAction((ActionEvent e) -> stage.setScene(task3Scene));
        task3View.back4.setOnAction((ActionEvent e) -> stage.setScene(menuScene));

        // adds the scene to stage
         stage.setScene(menuScene);
         stage.setTitle("Time Tracker");
         // shows the stage
         stage.show();
    }
}
