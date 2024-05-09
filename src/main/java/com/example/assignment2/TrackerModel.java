/*
Name: Showvik Mazumdar
NSID: shm959
Student Number:11235944
Course Number: Cmpt381
 */

package com.example.assignment2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TrackerModel {
    LocalDate presentDate, reminderDate, displayDate, dueDate;
    LocalTime startWorkTime, endWorkTime;
    long totalHour, totalMin, totalSec ;
    int timeInMilliSec;
    ArrayList<TrackerModelSubscriber> subs, subs2, subs3, subs4;
    ArrayList <Tracker2ModelSubscriber> subs5;
    ArrayList <Tracker3ModelSubscriber> subs6;

    public TrackerModel(){
        subs = new ArrayList<>();
        subs2 = new ArrayList<>();
        subs3 = new ArrayList<>();
        subs4 = new ArrayList<>();
        subs5 = new ArrayList<>();
        subs6 = new ArrayList<>();
    }

    public void task1AddSubscriber(TrackerModelSubscriber newSub) {
        subs.add(newSub);
        subs2.add(newSub);
        subs3.add(newSub);
        subs4.add(newSub);
    }

    public void task2AddSubscriber (Tracker2ModelSubscriber newSub){
        subs5.add(newSub);
    }

    public void task3AddSubscriber (Tracker3ModelSubscriber newSub){
        subs6.add(newSub);
    }


    private void notifySubscribers() {
        subs.forEach(TrackerModelSubscriber::task1DateModelUpdated);
    }
    private void notifySubscribers2() {
        subs2.forEach(TrackerModelSubscriber::task1StartWorkModelUpdated);
    }
    private void notifySubscribers3() {
        subs3.forEach(TrackerModelSubscriber::task1EndWorkModelUpdated);
    }
    private void notifySubscribers4() {
        subs4.forEach(TrackerModelSubscriber::task1AddListModelUpdated);
    }
    private void notifySubscribers5() {
        subs5.forEach(Tracker2ModelSubscriber:: task2ReminderModelUpdated);
    }
    private void notifySubscribers6() {
        subs6.forEach(Tracker3ModelSubscriber::  task3TimerModelUpdated);
    }


    public void addDate() {
        presentDate = LocalDate.now();


        notifySubscribers();
    }

    public String getDate(){
        return String.valueOf(presentDate);
    }


    public void addStartTime(){
        startWorkTime = LocalTime.now();
        notifySubscribers2();
    }

    public String getStartTime(){
        return String.valueOf(startWorkTime) ;
    }

    public void addEndTime() {
        endWorkTime = LocalTime.now();
        notifySubscribers3();
    }

    public String getEndTime(){
        return String.valueOf(endWorkTime);
    }

    public void calcTimeWorked() {
        totalHour = Duration.between(startWorkTime, endWorkTime).toHours();
        totalMin = Duration.between(startWorkTime, endWorkTime).toMinutes();
        totalSec = Duration.between(startWorkTime, endWorkTime).toSeconds();
       notifySubscribers4();
    }
    public String getTotalHour(){
        return String.valueOf(totalHour);
    }

    public String getTotalMin(){
        return String.valueOf(totalMin);
    }

    public String getTotalSec(){
        return String.valueOf(totalSec);
    }

    public void task2ReminderDate(LocalDate dDate) {
        reminderDate =  dDate.minusDays(2);
        if (LocalDate.of(dDate.getYear(),dDate.getMonth(),dDate.getDayOfMonth()).equals(reminderDate)){
            displayDate = reminderDate;
        }
        notifySubscribers5();
    }
     public String getReminderDate(){
        return String.valueOf(reminderDate);

     }

    public void setTimer(String time) {
        int intTime = Integer.parseInt(time);
        timeInMilliSec = intTime * 60;
        notifySubscribers6();
    }

    public int getTimer(){
        return timeInMilliSec;
    }
}
