package com.oops;
//TODO ADD SETTINGS AS CONSTANTS, DO ICON DESIGNS, HANDLE MESSAGEBOXES
class App{
    public static void main(String args[]){
        // Initial event (onload)
        if (Registration.userHasRegistered()){
                new LoginPanel();
        }
        else{
                new RegisterPanel();
        }
    }
}
