/*
Name: Showvik Mazumdar
NSID: shm959
Student Number:11235944
Course Number: Cmpt381
 */

package com.example.assignment2;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class TrackerController {
    TrackerModel model;

    public void setModel(TrackerModel newModel){
        model = newModel;
    }

    public void task1Date(ActionEvent event) {
        model.addDate();
    }

    public void task1StartTime (ActionEvent event) {
        model.addDate();
        model.addStartTime();
    }

    public void task1EndTime(ActionEvent event) {
        model.addDate();
        model.addEndTime();
    }

    public void task1AddList(ActionEvent event) {
        model.calcTimeWorked();
    }

    public void task2Submit(LocalDate date) {
        model.task2ReminderDate(date);
    }

    public void timerCount(String time) {
        model.setTimer(time);
    }
}
