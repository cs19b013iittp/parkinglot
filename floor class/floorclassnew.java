import java.util.Scanner;
import java.time.LocalTime;

public class FloorClass {
    public static void main(String[] args) {            // driver code
        Scanner scan = new Scanner(System.in);
        Car c = new Car();
        Bike bk = new Bike();
//        int spot1 = c.getEconomy();
//        int spot2 = c.getEconomy();
//        System.out.println(spot1);
//        System.out.println(spot2);
//        int s3= c.getEconomy();
//        System.out.println(s3);
//        c.ExitEconomyService(spot2);
//        int s4=c.getEconomy();
//        System.out.println(s4);
        Building b = new Building();
        System.out.println("Enter floor number");
        b.getFloor(scan.nextLine());
        System.out.println("Enter floor number");
        b.getFloor(scan.nextLine());
        c.display();
        b.exit(2, 1);
        c.display();
        System.out.println("Enter floor number");
        b.getFloor(scan.nextLine());
        System.out.println("Enter floor number");
        b.getFloor(scan.nextLine());
        bk.display();
        b.exit(3, 2);
        bk.display();
        c.display();
    }
}

class DisplayBoard{

}

class Building {

    Scanner input = new Scanner(System.in);

    Car c = new Car();
    Bike bk = new Bike();
    Truck tr = new Truck();

    public int getFloor(String vehicle, boolean ev, boolean vip){
        if(vehicle.toLowerCase().equals("truck")){
            isEV(tr);
        }
        else if (vehicle.toLowerCase().equals("car")){
            if(ev)
                isEV(c);
            else if(vip)
                isVIP(c);
            else
                isEconomy(c);
        }
        else if (vehicle.toLowerCase().equals("bike")){
            isEV(bk);
        }
        else
            return -1;
        return 0;
    }

    public void isEV(Floor t){
        while(true) {
            if (isEV.toLowerCase().equals("yes")) {
                int spot = t.getEV();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                break;
            }
            else if(isEV.toLowerCase().equals("no")){
                isNotEV(t);
                break;
            }
            else {
                System.out.println("Invalid input: Type yes/no");
            }
        }

    }

    public void isNotEV(Floor t){
        System.out.println("Do you want VIP service: Type yes/no");
        String isVIP = input.nextLine();
        int spot;
        while(true) {
            if (isVIP.toLowerCase().equals("yes")) {
                spot = t.getVIP();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                break;
            }
            else if(isVIP.toLowerCase().equals("no")){
                spot = t.getEconomy();
                if(spot==-1){
                    System.out.println("No vacant spots available, come back later.");
                }
                System.out.println(spot);
                break;
            }
            else {
                System.out.println("Invalid input: Type yes/no");
            }
        }
    }

    public int exit(int floorNumber, int spotNumber){
        if(floorNumber==1){
        }
        else if(floorNumber==2){
            int pay;
            if (spotNumber>=1 && spotNumber <=85){
                pay = c.ExitEconomyService(spotNumber);
                if(pay==1){

                    System.out.println("Payed at toll gate");
                    Car.paid[spotNumber-1]=1;
                }
            }
            else if(spotNumber>=86 && spotNumber <=95){
                c.ExitEVService(spotNumber);
            }
            else if(spotNumber>=96 && spotNumber <=100){
                c.ExitVIPService(spotNumber);
            }
            else
                return -1;
            return 0;
        }
        else if(floorNumber==3){
            int pay;
            if (spotNumber>=1 && spotNumber <=85){
                pay = bk.ExitEconomyService(spotNumber);
                if(pay==1){
                    System.out.println("Payed at toll gate");
                    Bike.paid[spotNumber-1]=1;
                }
            }
            else if(spotNumber>=86 && spotNumber <=95){
                bk.ExitEVService(spotNumber);
            }
            else if(spotNumber>=96 && spotNumber <=100){
                bk.ExitVIPService(spotNumber);
            }
            else
                return -1;
            return 0;
        }
        return 0;
    }

}

/* **************************************************************************************************************** */

abstract class Floor{
    abstract public int getTotalSpots();
    abstract public int getTotalEV();
    abstract public int getTotalVIP();
    abstract public int getEconomyVacancies();
    abstract public int getEVVacancies();
    abstract public int getVIPVacancies();
    private void portFolio(){}
    abstract public int getEconomy();
    abstract public int getEV();
    abstract public int getVIP();
    DisplayBoard db = new DisplayBoard();
}

class Car extends Floor{                // Floor number = 2

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 100;    // 1-85:Economy, 86-95:EV, 96-100:VIP
    private int totalVIP = 5;
    private int totalEV = 10;
    private int current = 0;
    int economyVacancy = 0;
    int EVVacancy = 0;
    int VIPVacancy = 0;

    static int[] floor2 = new int[totalSpots];
    static int[] now = new int[totalSpots];
    static int[] then = new int[totalSpots];
    static int[] paid = new int[totalSpots];
    static int[] rCharge = new int[totalSpots];
    static int[] carWash = new int[totalSpots];

    void display(){
        for(int i=0;i<100;i++){
            System.out.print(paid[i] + " ");
        }
        System.out.println("\n");
    }

    Car(){
        for(int i=0;i<totalSpots;i++){
            floor2[i] = 0;                        // 0 for vacant, 1 for filled
            now[i] = 0;
            then[i] = 0;
            paid[i] = 0;
            rCharge[i] = 0;
            carWash[i] = 0;
        }
    }

    public int getTotalSpots(){
        return totalSpots;
    }

    public int getTotalEV() {
        return totalEV;
    }

    public int getTotalVIP() {
        return totalVIP;
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
                floor2[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterEconomyService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getEV(){                         // assigns a free spot, if available
        for(int i=85;i<95;i++){
            if(floor2[i]==0){
                floor2[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterEVService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getVIP(){                        // assigns a free spot, if available
        for(int i=95;i<100;i++){
            if(floor2[i]==0){
                floor2[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 20;
        } else if (time > 1 && time <= 3) {
            amount = 30;
        } else {
            amount = 30 + 5 * (time - 3);
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                return 1;
            } else if (payHere == 1) {
                portFolio(cur);
                floor2[cur-1]=0;
                return 0;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
    }

    private void EnterEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
    }

    private void EnterEVService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
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

    public int ExitEVService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 20;
        } else if (time > 1 && time <= 3) {
            amount = 30;
        } else {
            amount = 30 + 5 * (time - 3);
        }
        if(rCharge[cur-1]==1){
            amount+=15;                                     // additional charges for recharging the vehicle
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                break;
            } else if (payHere == 1) {
                portFolio(cur);
                break;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor2[cur-1]=0;
        return 0;
    }

    private void EnterVIPService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
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

    public int[] ExitVIPService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 30;
        } else if (time > 1 && time <= 3) {
            amount = 40;
        } else {
            amount = 40 + 10 * (time - 3);
        }
        if(carWash[cur-1]==1){
            amount+=20;                                     // additional charges for washing the vehicle
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                break;
            } else if (payHere == 1) {
                portFolio(cur);
                return null;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor2[cur-1]=0;
        return paid;
    }

    private void portFolio(int cur){
        System.out.println("Press 1 for cash and press 2 for credit card payment >> ");
        int cr = scan.nextInt();
        while(true) {
            if (cr != 1 && cr != 2) {
                System.out.println("Invalid option. Try again");
            }
            else{
                paid[cur-1] = 1;
                System.out.println("Payment successful");
                break;
            }
        }
    }

}

/* ************************************* BIKE BIKE BIKE BIKE BIKE BIKE ******************************************* */

class Bike implements Floor{

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 200;    // 1-150:Economy, 151-180:EV, 181-200:VIP
    private int totalVIP = 30;
    private int totalEV = 20;
    private int current = 0;
    int economyVacancy = 0;
    int EVVacancy = 0;
    int VIPVacancy = 0;

    static int[] floor3 = new int[totalSpots];
    static int[] now = new int[totalSpots];
    static int[] then = new int[totalSpots];
    static int[] paid = new int[totalSpots];
    static int[] rCharge = new int[totalSpots];
    static int[] bikeWash = new int[totalSpots];

    void display(){
        for(int i=0;i<10;i++){
            System.out.print(paid[i] + " ");
        }
        System.out.println("\n");
    }

    Bike(){
        for(int i=0;i<totalSpots;i++){
            floor3[i] = 0;                        // 0 for vacant, 1 for filled
            now[i] = 0;
            then[i] = 0;
            paid[i] = 0;
            rCharge[i] = 0;
            bikeWash[i] = 0;
        }
    }

    public int getTotalSpots(){
        return totalSpots;
    }

    public int getTotalEV() {
        return totalEV;
    }

    public int getTotalVIP() {
        return totalVIP;
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
                floor3[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterEconomyService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getEV(){                         // assigns a free spot, if available
        for(int i=150;i<180;i++){
            if(floor3[i]==0){
                floor3[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterEVService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getVIP(){                        // assigns a free spot, if available
        for(int i=180;i<200;i++){
            if(floor3[i]==0){
                floor3[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 10;
        } else if (time > 1 && time <= 3) {
            amount = 20;
        } else {
            amount = 20 + 5 * (time - 3);
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                return 1;
            } else if (payHere == 1) {
                portFolio(cur);
                floor3[cur-1]=0;
                return 0;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
    }

    private void EnterEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
    }

    private void EnterEVService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
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

    public int ExitEVService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 10;
        } else if (time > 1 && time <= 3) {
            amount = 20;
        } else {
            amount = 20 + 5 * (time - 3);
        }
        if(rCharge[cur-1]==1){
            amount+=10;                                     // additional charges for recharging the vehicle
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                break;
            } else if (payHere == 1) {
                portFolio(cur);
                break;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor3[cur-1]=0;
        return 0;
    }

    private void EnterVIPService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
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

    public int[] ExitVIPService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 20;
        } else if (time > 1 && time <= 3) {
            amount = 30;
        } else {
            amount = 30 + 10 * (time - 3);
        }
        if(bikeWash[cur-1]==1){
            amount+=10;                                     // additional charges for washing the vehicle
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                break;
            } else if (payHere == 1) {
                portFolio(cur);
                return null;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor3[cur-1]=0;
        return paid;
    }

    private void portFolio(int cur){
        System.out.println("Press 1 for cash and press 2 for credit card payment >> ");
        int cr = scan.nextInt();
        while(true) {
            if (cr != 1 && cr != 2) {
                System.out.println("Invalid option. Try again");
            }
            else{
                paid[cur-1] = 1;
                System.out.println("Payment successful");
                break;
            }
        }
    }

}

/* ************************** TRUCK TRUCK TRUCK TRUCK TRUCK TRUCK ******************************* */

class Truck implements Floor{

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 50;    // 1-30:Economy, 31-40:EV, 41-50:VIP
    private int totalVIP = 10;
    private int totalEV = 10;
    private int current = 0;
    int economyVacancy = 0;
    int EVVacancy = 0;
    int VIPVacancy = 0;

    static int[] floor1 = new int[totalSpots];
    static int[] now = new int[totalSpots];
    static int[] then = new int[totalSpots];
    static int[] paid = new int[totalSpots];
    static int[] rCharge = new int[totalSpots];
    static int[] truckWash = new int[totalSpots];

    void display(){
        for(int i=0;i<totalSpots;i++){
            System.out.print(paid[i] + " ");
        }
        System.out.println("\n");
    }

    Truck(){
        for(int i=0;i<totalSpots;i++){
            floor1[i] = 0;                        // 0 for vacant, 1 for filled
            now[i] = 0;
            then[i] = 0;
            paid[i] = 0;
            rCharge[i] = 0;
            truckWash[i] = 0;
        }
    }

    public int getTotalSpots(){
        return totalSpots;
    }

    public int getTotalEV() {
        return totalEV;
    }

    public int getTotalVIP() {
        return totalVIP;
    }

    public int getEconomyVacancies(){           // gets number of free economy class spots
        for(int i=0;i<30;i++){
            if(floor1[i]==0){
                economyVacancy++;
            }
        }
        return economyVacancy;
    }

    public int getEVVacancies(){                // gets number of free EV class spots
        for(int i=30;i<40;i++){
            if(floor1[i]==0){
                EVVacancy++;
            }
        }
        return EVVacancy;
    }

    public int getVIPVacancies(){               // gets number of free VIP class spots
        for(int i=40;i<50;i++){
            if(floor1[i]==0){
                VIPVacancy++;
            }
        }
        return VIPVacancy;
    }

    public int getEconomy(){                    // assigns a free spot, if available
        for(int i=0;i<30;i++){
            if(floor1[i]==0){
                floor1[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterEconomyService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getEV(){                         // assigns a free spot, if available
        for(int i=30;i<40;i++){
            if(floor1[i]==0){
                floor1[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterEVService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int getVIP(){                        // assigns a free spot, if available
        for(int i=40;i<50;i++){
            if(floor1[i]==0){
                floor1[i]=1;
                current = i+1;
                paid[i] = 0;
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 30;
        } else if (time > 1 && time <= 3) {
            amount = 40;
        } else {
            amount = 40 + 5 * (time - 3);
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                return 1;
            } else if (payHere == 1) {
                portFolio(cur);
                floor1[cur-1]=0;
                return 0;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
    }

    private void EnterEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
    }

    private void EnterEVService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
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

    public int ExitEVService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 30;
        } else if (time > 1 && time <= 3) {
            amount = 40;
        } else {
            amount = 40 + 5 * (time - 3);
        }
        if(rCharge[cur-1]==1){
            amount+=30;                                     // additional charges for recharging the vehicle
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                break;
            } else if (payHere == 1) {
                portFolio(cur);
                break;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor1[cur-1]=0;
        return 0;
    }

    private void EnterVIPService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour();
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

    public int[] ExitVIPService(int cur){
        LocalTime tm = LocalTime.now();
        then[cur - 1] = tm.getHour();
        int time = then[cur - 1] - now[cur - 1];
        int amount;
        if (time <= 1) {
            amount = 30;
        } else if (time > 1 && time <= 3) {
            amount = 40;
        } else {
            amount = 40 + 10 * (time - 3);
        }
        if(truckWash[cur-1]==1){
            amount+=35;                                     // additional charges for washing the vehicle
        }
        while (true) {
            System.out.println("Your total charges are " + amount + " for " + (then[cur - 1] - now[cur - 1]) + " hours");
//            db.display()
            System.out.println("Would you like to pay here at the info portal? (1 for Yes and 0 for No) >> ");
            int payHere = scan.nextInt();
            if (payHere == 0) {
                paid[cur - 1] = 0;
                System.out.println("Please pay at the exit");
                break;
            } else if (payHere == 1) {
                portFolio(cur);
                return null;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor1[cur-1]=0;
        return paid;
    }

    private void portFolio(int cur){
        System.out.println("Press 1 for cash and press 2 for credit card payment >> ");
        int cr = scan.nextInt();
        while(true) {
            if (cr != 1 && cr != 2) {
                System.out.println("Invalid option. Try again");
            }
            else{
                paid[cur-1] = 1;
                System.out.println("Payment successful");
                break;
            }
        }
    }

}
