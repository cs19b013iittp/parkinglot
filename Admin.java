package com.com_spidey;

import java.util.Scanner;

public class Admin extends Building {                        // INHERITANCE USED
    Scanner scan = new Scanner(System.in);
    void reserve(){                                           // reserves spots floor wise (only admin can use it)
        System.out.println("Displaying current status: ");
        show_display();
        System.out.println("Which floor do you want to reserve: ");
        int floor = scan.nextInt();
        System.out.println("Type 1 for economy, 2 for VIP, 3 for ElectricalVehicles");
        int reservationType = scan.nextInt();
        System.out.println("Number of seats to be reserved : ");
        int spotCount = scan.nextInt();
        if(floor==1 && reservationType==1){
            int spotCountChecker = 0;
            for (int i=0; i<40; i++){
                if(Truck.floor1[i]==0) {
                    spotCountChecker++;
                    Truck.floor1[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==1 && reservationType==2){
            int spotCountChecker = 0;
            for (int i=40; i<45; i++){
                if(Truck.floor1[i]==0) {
                    spotCountChecker++;
                    Truck.floor1[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==1 && reservationType==3){
            int spotCountChecker = 0;
            for (int i=45; i<50; i++){
                if(Truck.floor1[i]==0) {
                    spotCountChecker++;
                    Truck.floor1[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==2 && reservationType==1){
            int spotCountChecker = 0;
            for (int i=0; i<85; i++){
                if(Car.floor2[i]==0) {
                    spotCountChecker++;
                    Car.floor2[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==2 && reservationType==2){
            int spotCountChecker = 0;
            for (int i=85; i<95; i++){
                if(Car.floor2[i]==0) {
                    spotCountChecker++;
                    Car.floor2[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==2 && reservationType==3){
            int spotCountChecker = 0;
            for (int i=95; i<100; i++){
                if(Car.floor2[i]==0) {
                    spotCountChecker++;
                    Car.floor2[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==3 && reservationType==1){
            int spotCountChecker = 0;
            for (int i=1; i<150; i++){
                if(Bike.floor3[i]==0) {
                    spotCountChecker++;
                    Bike.floor3[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==3 && reservationType==2){
            int spotCountChecker = 0;
            for (int i=150; i<180; i++){
                if(Bike.floor3[i]==0) {
                    spotCountChecker++;
                    Bike.floor3[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        else if(floor==3 && reservationType==3){
            int spotCountChecker = 0;
            for (int i=180; i<200; i++){
                if(Bike.floor3[i]==0) {
                    spotCountChecker++;
                    Bike.floor3[i] = -1;
                }
                if(spotCountChecker==spotCount){
                    System.out.println("Reserved "+spotCount+" spots.");
                    break;
                }

            }
            if(spotCountChecker!=spotCount)
                System.out.println("Requested number of spots are not available, reserved "+spotCountChecker+" spots.");
        }
        show_display(floor);
    }
    void unreserveAll(){                               // unreserves all previous reserved spots (accessible only to admin)
        System.out.println("Enter floor number: ");
        int floor = scan.nextInt();
        if(floor==1){
            for(int i=0; i<50; i++){
                if(Truck.floor1[i]==-1){
                    Truck.floor1[i]=0;
                }
            }
        }
        else if(floor==2){
            for(int i=0; i<100; i++){
                if(Car.floor2[i]==-1){
                    Car.floor2[i]=0;
                }
            }
        }
        else if(floor==3){
            for(int i=0; i<200; i++){
                if(Bike.floor3[i]==-1){
                    Bike.floor3[i]=0;
                }
            }
        }
        show_display(floor);
    }
}
