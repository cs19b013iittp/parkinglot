package com.com_spidey;


import java.io.FileWriter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;

public class DisplayBoard {
    Admin parkingLot = new Admin();
    FileWriter f2;

    {
        try {
            f2 = new FileWriter("ParkingLot.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            f2.write("Floor  Vehicle type  Registration number  Date  Time");
            f2.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run()                                    // menu driven method for customer and admin
    {
        Scanner scan = new Scanner(System.in);
        Building parkinglot = new Building();
        int n;
        while(true)
        {
            System.out.println("Please enter 1 to view display board, 2 to park your vehicle, 3 to exit, 4 to get ADMIN access and other to exit the software");
            n=scan.nextInt();
            if(n==1)
            {
                parkinglot.show_display();
            }
            else if(n==2)
            {
                String vehical_type;
                boolean isev,isvip;
                int floor_no;
                while (true) {
                    System.out.println("Enter 'bike' if your vehicle is bike");
                    System.out.println("Enter 'car' if your vehicle is car");
                    System.out.println("Enter 'truck' if your vehicle is truck");
                    vehical_type = scan.next();
                    if(parkinglot.validate(vehical_type)!=-1){
                        break;
                    }
                    else
                        System.out.println("Invalid vehicle type, try again");
                }


                System.out.println("Enter vehicle registration number without spaces: ");
                String vehicleNumber = scan.next();

                DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String date = dateTime.format(now);
                if(vehical_type.equals("truck")){
                    try {
                        f2.append("1");
                        f2.append("       ");
                        f2.append(vehical_type);
                        f2.append("       ");
                        f2.append(vehicleNumber);
                        f2.append("          ");
                        f2.append(date);
                        f2.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (vehical_type.equals("car")){
                    try {
                        f2.append("2");
                        f2.append("       ");
                        f2.append(vehical_type);
                        f2.append("         ");
                        f2.append(vehicleNumber);
                        f2.append("          ");
                        f2.append(date);
                        f2.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (vehical_type.equals("bike")){
                    try {
                        f2.append("3");
                        f2.append("       ");
                        f2.append(vehical_type);
                        f2.append("        ");
                        f2.append(vehicleNumber);
                        f2.append("          ");
                        f2.append(date);
                        f2.append("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                while (true){
                    System.out.println("If electrical vehicle, enter '1' else '0'");
                    int temp = scan.nextInt();
                    if(temp==1) {
                        isev = true;
                        break;
                    }
                    else if (temp==0) {
                        isev = false;
                        break;
                    }
                    else
                        System.out.println("Invalid input, Try again.");
                }

                while (true){
                    System.out.println("If vehicle wants VIP service, enter '1' else '0'");
                    int temp = scan.nextInt();
                    if(temp==1) {
                        isvip = true;
                        break;
                    }
                    else if (temp==0) {
                        isvip = false;
                        break;
                    }
                    else
                        System.out.println("Invalid input, Try again.");
                }

                floor_no = parkinglot.validate(vehical_type);
                if(floor_no !=-1)
                {
                    parkinglot.getFloor(vehical_type, isev, isvip);
                    parkinglot.show_display(floor_no);

                }
                else
                    System.out.println("Invalid vehicle type: bike,car,truck.");
            }
            else if(n==3)
            {
                int pay;

                System.out.println("Please enter your token number");
                String token=scan.next();
                int isvalid=parkinglot.validate(token,1);
                if(isvalid!=-1)
                {
                    System.out.println("Where do you want to pay the bill?");
                    System.out.println("Enter 1 to pay at information portal, 2 to pay at the exit");
                    pay=scan.nextInt();
                    if(pay==1)
                    {
                        int a=parkinglot.pay(token);
                        System.out.println("Please exit through gate "+a);
                        System.out.println("Thanks for using our parking lot");
                    }
                    else if(pay==2)
                    {
                        int a=parkinglot.pay(token);
                        System.out.println("Please exit through gate "+a);
                        System.out.println("Thanks for using our parking lot");
                    }

                }
                else
                {
                    System.out.println("Invalid input");
                }
            }
            else if (n==4){
                System.out.println("User name: Admin");
                System.out.print("Password: ");
                String password = scan.next();
                int chances = 5;
                while(chances-->0){
                    if(parkinglot.checkPassword(password)==1){
                        while (true){
                            System.out.println("Enter 1 for reservation and 2 for unreserving");
                            int adminSettings = scan.nextInt();
                            if(adminSettings==1){
                                parkingLot.reserve();
                                break;
                            }
                            else if(adminSettings==2){
                                parkingLot.unreserveAll();
                                break;
                            }
                            else
                                System.out.println("Invalid input, try again.");
                        }
                        break;
                    }
                    else
                        System.out.println("Wrong password, "+chances+"left");
                }
            }
            else {
                try {
                    f2.append("Total amount: ");
                    f2.append(parkinglot.getTotalEarning()+"");
                    f2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
