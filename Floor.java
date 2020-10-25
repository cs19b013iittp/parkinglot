package com.com_spidey;

import java.time.LocalTime;
import java.util.Scanner;

abstract class Floor {                                      // ABSTRACT CLASS USED

    protected int totalVIP = 0;
    protected int totalEV = 0;
    public int economyVacancy = 0;
    public int EVVacancy = 0;
    public int VIPVacancy = 0;
    public int current = 0;

    public int getTotalEV() {
        return totalEV;
    }

    public int getTotalVIP() {
        return totalVIP;
    }

    abstract public int getEconomyVacancies();
    abstract public int getEVVacancies();
    abstract public int getVIPVacancies();

    abstract public int getEconomy();
    abstract public int getEV();
    abstract public int getVIP();
}

class Car extends Floor{                          // INHERITANCE USED                     // Floor number = 2

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 100;    // 1-85:Economy, 86-95:EV, 96-100:VIP

    static int token=2000;

    static int[] floor2 = new int[totalSpots];
    static int[] now = new int[totalSpots];
    static int[] paid = new int[totalSpots];
    static int[] rCharge = new int[totalSpots];
    static int[] carWash = new int[totalSpots];


    Car(){

        totalVIP = 5;
        totalEV = 10;

        for(int i=0;i<totalSpots;i++){
            floor2[i] = 0;                        // 0 for vacant, 1 for filled
            now[i] = 0;
            paid[i] = 0;
            rCharge[i] = 0;
            carWash[i] = 0;
        }
    }

    public int getEconomyVacancies(){           // gets number of free economy class spots
        for(int i=0;i<85;i++){
            if(floor2[i]==0){
                economyVacancy++;
            }
        }
        return economyVacancy;
    }

    public int getEVVacancies(){                // gets number of free EV class spots
        for(int i=85;i<95;i++){
            if(floor2[i]==0){
                EVVacancy++;
            }
        }
        return EVVacancy;
    }

    public int getVIPVacancies(){               // gets number of free VIP class spots
        for(int i=95;i<100;i++){
            if(floor2[i]==0){
                VIPVacancy++;
            }
        }
        return VIPVacancy;
    }

    public int getEconomy(){                    // assigns a free spot, if available
        for(int i=0;i<85;i++){
            if(floor2[i]==0){
                floor2[i]=token++;
                current = i+1;
                EnterEconomyService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getEV(){                         // assigns a free spot, if available
        for(int i=85;i<95;i++){
            if(floor2[i]==0){
                floor2[i]=token++;
                current = i+1;
                EnterEVService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getVIP(){                        // assigns a free spot, if available
        for(int i=95;i<100;i++){
            if(floor2[i]==0){
                floor2[i]=token++;
                current = i+1;
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){                // exits car from economy service
        if(cur<1 || cur>85 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60 + tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterEconomyService(int cur){               // assigns cars into economy spots
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
    }

    private void EnterEVService(int cur){                    // enters cars into spots for electrical service
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+ tm.getMinute();
        int recharge;
        while(true) {
            System.out.println("Do you want to recharge your vehicle? (1 for yes and 0 for no) >> ");
            recharge = scan.nextInt();
            if(recharge!=0 && recharge!=1){
                System.out.println("Invalid option. Try again");
            }
            else
                break;
        }
        rCharge[cur-1]=recharge;
    }

    public int ExitEVService(int cur){                           // removes electric cars from assigned spots
        if(cur<86 || cur>95 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterVIPService(int cur){                       // assigns spots for cars opting VIP service
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
        int wash;
        while(true) {
            System.out.println("Does your vehicle need a car wash? (1 for yes and 0 for no) >> ");
            wash = scan.nextInt();
            if(wash!=0 && wash!=1){
                System.out.println("Invalid option. Try again");
            }
            else
                break;
        }
        carWash[cur-1]=wash;
    }

    public int ExitVIPService(int cur){                             // removes cars from VIP spots
        if(cur<96 || cur>100 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

}



/* ****************************************************** BIKE BIKE BIKE BIKE ************************************************************ */



class Bike extends Floor{                         // INHERITANCE USED                // Floor number = 3

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 200;    // 1-150:Economy, 151-180:EV, 181-200:VIP

    static int token=3000;

    static int[] floor3 = new int[totalSpots];
    static int[] now = new int[totalSpots];
    static int[] paid = new int[totalSpots];
    static int[] rCharge = new int[totalSpots];
    static int[] bikeWash = new int[totalSpots];


    Bike(){

        totalVIP = 5;
        totalEV = 10;

        for(int i=0;i<totalSpots;i++){
            floor3[i] = 0;                        // 0 for vacant, 1 for filled
            now[i] = 0;
            paid[i] = 0;
            rCharge[i] = 0;
            bikeWash[i] = 0;
        }
    }

    public int getEconomyVacancies(){           // gets number of free economy class spots
        for(int i=0;i<150;i++){
            if(floor3[i]==0){
                economyVacancy++;
            }
        }
        return economyVacancy;
    }

    public int getEVVacancies(){                // gets number of free EV class spots
        for(int i=150;i<180;i++){
            if(floor3[i]==0){
                EVVacancy++;
            }
        }
        return EVVacancy;
    }

    public int getVIPVacancies(){               // gets number of free VIP class spots
        for(int i=180;i<200;i++){
            if(floor3[i]==0){
                VIPVacancy++;
            }
        }
        return VIPVacancy;
    }

    public int getEconomy(){                    // assigns a free spot, if available
        for(int i=0;i<150;i++){
            if(floor3[i]==0){
                floor3[i]=token++;
                current = i+1;
                EnterEconomyService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getEV(){                         // assigns a free spot, if available
        for(int i=150;i<180;i++){
            if(floor3[i]==0){
                floor3[i]=token++;
                current = i+1;
                EnterEVService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getVIP(){                        // assigns a free spot, if available
        for(int i=180;i<200;i++){
            if(floor3[i]==0){
                floor3[i]=token++;
                current = i+1;
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){                // Gives time of being parked in economy service spot
        if(cur<1 || cur>150 || floor3[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60 + tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterEconomyService(int cur){              // Notes time at which bike enters economy service spot
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
    }

    private void EnterEVService(int cur){                  // Notes time at which bike enters EV service spot
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+ tm.getMinute();
        int recharge;
        while(true) {
            System.out.println("Do you want to recharge your vehicle? (1 for yes and 0 for no) >> ");
            recharge = scan.nextInt();
            if(recharge!=0 && recharge!=1){
                System.out.println("Invalid option. Try again");
            }
            else
                break;
        }
        rCharge[cur-1]=recharge;
    }

    public int ExitEVService(int cur){                             // Gives time of being parked in EV service spot
        if(cur<151 || cur>180 || floor3[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterVIPService(int cur){                 // Notes time at which bike enters VIP service spot
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
        int wash;
        while(true) {
            System.out.println("Does your vehicle need a car wash? (1 for yes and 0 for no) >> ");
            wash = scan.nextInt();
            if(wash!=0 && wash!=1){
                System.out.println("Invalid option. Try again");
            }
            else
                break;
        }
        bikeWash[cur-1]=wash;
    }

    public int ExitVIPService(int cur){                        // Gives time of being parked in VIP service spot
        if(cur<181 || cur>200 || floor3[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

}




/* ******************************************* TRUCK TRUCK TRUCK TRUCK **************************************************** */





class Truck extends Floor{                       // INHERITANCE USED               // Floor number = 1

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 50;    // 1-40:Economy, 41-45:EV, 46-50:VIP

    static int token=1000;

    static int[] floor1 = new int[totalSpots];
    static int[] now = new int[totalSpots];
    static int[] paid = new int[totalSpots];
    static int[] rCharge = new int[totalSpots];
    static int[] truckWash = new int[totalSpots];


    Truck(){

        totalVIP = 5;
        totalEV = 5;

        for(int i=0;i<totalSpots;i++){
            floor1[i] = 0;                        // 0 for vacant, 1 for filled
            now[i] = 0;
            paid[i] = 0;
            rCharge[i] = 0;
            truckWash[i] = 0;
        }
    }

    public int getEconomyVacancies(){           // gets number of free economy class spots
        for(int i=0;i<40;i++){
            if(floor1[i]==0){
                economyVacancy++;
            }
        }
        return economyVacancy;
    }

    public int getEVVacancies(){                // gets number of free EV class spots
        for(int i=40;i<45;i++){
            if(floor1[i]==0){
                EVVacancy++;
            }
        }
        return EVVacancy;
    }

    public int getVIPVacancies(){               // gets number of free VIP class spots
        for(int i=45;i<50;i++){
            if(floor1[i]==0){
                VIPVacancy++;
            }
        }
        return VIPVacancy;
    }

    public int getEconomy(){                    // assigns a free spot, if available
        for(int i=0;i<40;i++){
            if(floor1[i]==0){
                floor1[i]=token++;
                current = i+1;
                EnterEconomyService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getEV(){                         // assigns a free spot, if available
        for(int i=40;i<45;i++){
            if(floor1[i]==0){
                floor1[i]=token++;
                current = i+1;
                EnterEVService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getVIP(){                        // assigns a free spot, if available
        for(int i=45;i<50;i++){
            if(floor1[i]==0){
                floor1[i]=token++;
                current = i+1;
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){                       // Gives time parked in economy service spot
        if(cur<1 || cur>40 || floor1[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60 + tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterEconomyService(int cur){            // Notes time at which bike enters economy service spot
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
    }

    private void EnterEVService(int cur){               // Notes time at which bike enters EV service spot
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+ tm.getMinute();
        int recharge;
        while(true) {
            System.out.println("Do you want to recharge your vehicle? (1 for yes and 0 for no) >> ");
            recharge = scan.nextInt();
            if(recharge!=0 && recharge!=1){
                System.out.println("Invalid option. Try again");
            }
            else
                break;
        }
        rCharge[cur-1]=recharge;
    }

    public int ExitEVService(int cur){                     // Gives time parked in EV service spot
        if(cur<41 || cur>45 || floor1[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterVIPService(int cur){                     // Notes time at which bike enters VIP service spot
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
        int wash;
        while(true) {
            System.out.println("Does your vehicle need a car wash? (1 for yes and 0 for no) >> ");
            wash = scan.nextInt();
            if(wash!=0 && wash!=1){
                System.out.println("Invalid option. Try again");
            }
            else
                break;
        }
        truckWash[cur-1]=wash;
    }

    public int ExitVIPService(int cur){                              // Gives time parked in VIP service spot
        if(cur<46 || cur>50 || floor1[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

}
