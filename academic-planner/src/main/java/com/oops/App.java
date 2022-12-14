package com.oops;
// TODO add max possible attendacne
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
