package com.oops;
// TODO settings?
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
