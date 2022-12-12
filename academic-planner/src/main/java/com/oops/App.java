package com.oops;
//TODO ADD SETTINGS AS CONSTANTS, DO ICON DESIGNS, HANDLE MESSAGEBOXES, restructure backend, colour code categories, ADD LIMITS TO SCROLL DATES
class App{
    public static void main(String args[]){
        // Initial event (onload)
        new SQL();

        if (Registration.userHasRegistered()){
                new LoginPanel();
        }
        else{
                new RegisterPanel();
        }
    }
}
