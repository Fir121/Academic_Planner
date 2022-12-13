package com.oops;
// TODO ICON DESIGNS, HANDLE MESSAGEBOXES, colour code categories, calculate projected grade by asking for grade, using components so far and incorporating attendance
// TODO ADD SET GRADE, CURRENT GARE, SETTINGS, LINK OPTIONPANE TO FRAME, restrict datepicker, colour based geatures front end
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
