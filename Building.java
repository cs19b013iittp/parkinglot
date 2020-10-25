package com.com_spidey;

import java.util.Scanner;

public class Building {
    private String  RegisteredPassword = "admin";            // password declared private to protect it from malicious users.
    private int totalEarning=0;
    Scanner input = new Scanner(System.in);
    Car c = new Car();
    Bike bk = new Bike();
    Truck tr = new Truck();
    public void show_display(int floorNumber){              // shows current spot occupancy of a particular floor.
        if(floorNumber==2){
            for(int i=0; i<100; i++){
                if(i%10==0)
                    System.out.println("");
                if(Car.floor2[i]>0)
                    System.out.print("1 ");
                else if (Car.floor2[i]<0)
                    System.out.print("8 ");
                else
                    System.out.print("0 ");
            }
            System.out.println("");
        }
        else if(floorNumber==1){
            for(int i=0; i<50; i++){
                if(i%10==0)
                    System.out.println("");
                if(Truck.floor1[i]>0)
                    System.out.print("1 ");
                else if (Truck.floor1[i]<0)
                    System.out.print("8 ");
                else
                    System.out.print("0 ");
            }
            System.out.println("");
        }
        else if(floorNumber==3){
            for(int i=0; i<200; i++){
                if(i%10==0)
                    System.out.println("");
                if(Bike.floor3[i]>0)
                    System.out.print("1 ");
                else if (Bike.floor3[i]<0)
                    System.out.print("8 ");
                else
                    System.out.print("0 ");
            }
            System.out.println("");
        }
    }
    public void show_display(){                  // POLYMORPHISM USED             // shows current spot occupancy of all 3 floors.
        System.out.println("Floor 1 status:");
        for(int i=0; i<50; i++){
            if(i%10==0)
                System.out.println("");
            if(Truck.floor1[i]>0)
                System.out.print("1 ");
            else if (Truck.floor1[i]<0)
                System.out.print("8 ");
            else
                System.out.print("0 ");
        }
        System.out.println("");

        System.out.println("Floor 2 status:");

        for(int i=0; i<100; i++){
            if(i%10==0)
                System.out.println("");
            if(Car.floor2[i]>1)
                System.out.print("1 ");
            else if (Car.floor2[i]<0)
                System.out.print("8 ");
            else
                System.out.print("0 ");
        }
        System.out.println("");
        System.out.println("Floor 3 status:");
        for(int i=0; i<200; i++){
            if(i%10==0)
                System.out.println("");
            if(Bike.floor3[i]>0)
                System.out.print("1 ");
            else if (Bike.floor3[i]<0)
                System.out.print("8 ");
            else
                System.out.print("0 ");
        }
        System.out.println("");
    }
    public int validate(String vehicleType){                            // Validates vehicle type(Whether truck or car or bike)
        if(vehicleType.toLowerCase().equals("truck"))
            return 1;
        else if (vehicleType.toLowerCase().equals("car"))
            return 2;
        else if (vehicleType.toLowerCase().equals("bike"))
            return 3;
        else
            return -1;
    }
    public int validate(String s,int x)        // POLYMORPHISM USED                          // Validates assigned token number given to customer and derives floor number and spot number from it.
    {

        int floorNo=s.charAt(0)-'0';
        int token=0;
        for(int i=2;i<s.length();i++)
        {
            token*=10;
            token+=s.charAt(i)-'0';
        }
        if(token==0){
            return -1;
        }
        if(s.charAt(1)!='.')
            return -1;
        if(floorNo==1)
        {
            int i;
            for(i=0;i<50;i++)
            {
                if(Truck.floor1[i]==token)
                    break;
            }
            if(i==50)
                return -1;
            else
                return 1;
        }
        else if(floorNo==2)
        {
            int i;
            for(i=0;i<100;i++)
            {
                if(Car.floor2[i]==token)
                    break;
            }
            if(i==100)
                return -1;
            else
                return 1;
        }
        else if(floorNo==3)
        {
            int i;
            for(i=0;i<200;i++)
            {
                if(Bike.floor3[i]==token)
                    break;
            }
            if(i==200)
                return -1;
            else
                return 1;
        }
        else
            return -1;
    }
    public int getFloor(String vehicle, boolean ev, boolean vip){                              // Assigns floor number and spot number to customer as per vehicle type and additional features(Electrical or VIP or additional services)
        if(vehicle.toLowerCase().equals("truck")){
            if(ev){
                int spot = tr.getEV();
                if (spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 1");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 1."+Truck.floor1[spot-1] );
                }
            }
            else if(vip){
                int spot = tr.getVIP();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 1");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 1."+Truck.floor1[spot-1] );
                }
            }
            else {
                int spot = tr.getEconomy();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 1");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 1."+Truck.floor1[spot-1] );
                }
            }
        }
        else if (vehicle.toLowerCase().equals("car")){
            if(ev){
                int spot = c.getEV();
                if (spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 2");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 2."+Car.floor2[spot-1] );
                }
            }
            else if(vip){
                int spot = c.getVIP();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 2");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 2."+Car.floor2[spot-1] );
                }
            }
            else {
                int spot = c.getEconomy();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 2");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 2."+Car.floor2[spot-1] );
                }
            }
        }
        else if (vehicle.toLowerCase().equals("bike")){
            if(ev){
                int spot = bk.getEV();
                if (spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 3");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 3."+Bike.floor3[spot-1] );
                }
            }
            else if(vip){
                int spot = bk.getVIP();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 3");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 3."+Bike.floor3[spot-1] );
                }
            }
            else {
                int spot = bk.getEconomy();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                else
                {
                    System.out.println("Please proceed to floor 3");
                    System.out.println("Assigned spot: " + spot);
                    System.out.println("Please remember this token number : 3."+Bike.floor3[spot-1] );
                }
            }
        }
        else
            return -1;
        return 0;
    }
    public int pay(String s){                                       // Final billing to customer
        int floorNumber=s.charAt(0)-'0';
        int token=0,spotNumber=0;
        if(floorNumber==1){
            for(int i=2;i<s.length();i++)
            {
                token*=10;
                token+=s.charAt(i)-'0';
            }
            int time,amount=0;
            for(int i=0;i<50;i++)
            {
                if(token==Truck.floor1[i])
                {
                    spotNumber=i+1;
                }
            }
            if (spotNumber>=1 && spotNumber <=40) {
                time = tr.ExitEconomyService(spotNumber);
                System.out.println("Time : " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Truck.floor1[spotNumber - 1] = 0;
                totalEarning+=amount;
                return 1;
            }
            else if(spotNumber>=41 && spotNumber <=45){
                time = tr.ExitEVService(spotNumber);
                System.out.println("Time: " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Truck.floor1[spotNumber-1]=0;
                totalEarning+=amount;
                return 2;
            }
            else if(spotNumber>=46 && spotNumber <=50){
                time = tr.ExitVIPService(spotNumber);
                System.out.println("Time: " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Truck.floor1[spotNumber-1]=0;
                totalEarning+=amount;
                return 2;
            }
        }
        else if (floorNumber==2){
            for(int i=2;i<s.length();i++)
            {
                token*=10;
                token+=s.charAt(i)-'0';
            }
            int time,amount=0;
            for(int i=0;i<100;i++)
            {
                if(token==Car.floor2[i])
                {
                    spotNumber=i+1;
                }
            }
            if (spotNumber>=1 && spotNumber <=85) {
                time = c.ExitEconomyService(spotNumber);
                System.out.println("Time : " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Car.floor2[spotNumber - 1] = 0;
                totalEarning+=amount;
                return 1;
            }
            else if(spotNumber>=86 && spotNumber <=95){
                time = c.ExitEVService(spotNumber);
                System.out.println("Time: " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Car.floor2[spotNumber-1]=0;
                totalEarning+=amount;
                return 2;
            }
            else if(spotNumber>=96 && spotNumber <=100){
                time = c.ExitVIPService(spotNumber);
                System.out.println("Time: " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Car.floor2[spotNumber-1]=0;
                totalEarning+=amount;
                return 2;
            }

        }
        else{
            for(int i=2;i<s.length();i++)
            {
                token*=10;
                token+=s.charAt(i)-'0';
            }
            int time,amount=0;
            for(int i=0;i<200;i++)
            {
                if(token==Bike.floor3[i])
                {
                    spotNumber=i+1;
                }
            }
            if (spotNumber>=1 && spotNumber <=150) {
                time = bk.ExitEconomyService(spotNumber);
                System.out.println("Time : " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Bike.floor3[spotNumber - 1] = 0;
                totalEarning+=amount;
                return 1;
            }
            else if(spotNumber>=151 && spotNumber <=180){
                time = bk.ExitEVService(spotNumber);
                System.out.println("Time: " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Bike.floor3[spotNumber-1]=0;
                totalEarning+=amount;
                return 2;
            }
            else if(spotNumber>=181 && spotNumber <=200){
                time = bk.ExitVIPService(spotNumber);
                System.out.println("Time: " + time);
                amount = timeToCash(time,floorNumber,spotNumber);
                System.out.println("Amount: "+amount);
                paymentOptions(floorNumber, spotNumber);
                System.out.println("Please visit again.");
                Bike.floor3[spotNumber-1]=0;
                totalEarning+=amount;
                return 2;
            }
        }
        return -1;
    }

    public void paymentOptions(int floor, int spot){                        // Asks for cash or credit options to customer
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 1 for cash and press 2 for credit card payment >> ");
        int cr = scan.nextInt();
        String card="";
        while (true) {
            if (cr != 1 && cr != 2) {
                System.out.println("Invalid option. Try again");
            } else if(cr==1){
                if(floor==1)
                    Truck.paid[spot - 1] = 1;
                else if(floor==2)
                    Car.paid[spot-1] = 1;
                else
                    Bike.paid[spot-1] = 1;
                System.out.println("Payment successful");
                break;
            }
            else{
                System.out.println("Enter four digit credit card number: ");
                card = scan.next();
                while (true){
                    if(card.length()!=4){
                        System.out.println("Invalid card number: Try again.");
                        System.out.println("Enter four digit credit card number: ");
                        card = scan.next();
                    }
                    else
                        break;
                }
                if(floor==1)
                    Truck.paid[spot - 1] = 1;
                else if(floor==2)
                    Car.paid[spot-1] = 1;
                else
                    Bike.paid[spot-1] = 1;
                System.out.println("Amount paid successfully");
                break;
            }
        }
    }

    public int timeToCash(int time, int floor, int spot){                // Gives monetary value to total parking time and additional services
        int amount=0;
        if(floor==1){
            if (time <= 60) {
                amount = 60;
            } else if (time > 60 && time <= 180) {
                amount = 80;
            } else {
                amount = 80 + 20 * ((time - 180) / 60);
            }
            if (Truck.rCharge[spot - 1] == 1) {
                amount += 40;                                     // additional charges for washing the vehicle
            }
            if(Truck.truckWash[spot-1]==1)
            {
                amount+=100;
            }
        }
        else if(floor==2) {
            if (time <= 60) {
                amount = 30;
            } else if (time > 60 && time <= 180) {
                amount = 40;
            } else {
                amount = 40 + 10 * ((time - 180) / 60);
            }
            if (Car.rCharge[spot - 1] == 1) {
                amount += 20;                                     // additional charges for washing the vehicle
            }
            if(Car.carWash[spot-1]==1)
            {
                amount+=50;
            }
        }
        else {
            if (time <= 60) {
                amount = 15;
            } else if (time > 60 && time <= 180) {
                amount = 20;
            } else {
                amount = 20 + 5 * ((time - 180) / 60);
            }
            if (Bike.rCharge[spot - 1] == 1) {
                amount += 10;                                     // additional charges for washing the vehicle
            }
            if(Bike.bikeWash[spot-1]==1)
            {
                amount+=25;
            }
        }
        return amount;
    }

    public int getTotalEarning(){                                // returns total earning(admin perspective) to a file in parking lot system
        return totalEarning;
    }
    
    public int checkPassword(String password){                  // checks password entered by admin in parking lot system.
        if(password.equals(RegisteredPassword))
            return 1;
        else
            return -1;
    }
}
