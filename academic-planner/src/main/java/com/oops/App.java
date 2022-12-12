package com.oops;
// TODO ICON DESIGNS, HANDLE MESSAGEBOXES, colour code categories, calculate projected grade by asking for grade, using components so far and incorporating attendance
class App{
    public static void main(String args[]){
        if (Registration.userHasRegistered()){
                new LoginPanel();
        }
        else{
                new RegisterPanel();
        }
    }
}
