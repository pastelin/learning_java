package com.course.challenge.smart.kitchen;

public class DishWasher {

    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes() {
        if(hasWorkToDo) {
            System.out.println("Doing Coffee");
            hasWorkToDo = false;
        }
    }
}
