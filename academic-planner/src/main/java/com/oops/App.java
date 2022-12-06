package com.oops;

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
