package com.oops;
// TODO ICON DESIGNS, colour code categories
// TODO colour based geatures front end
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
