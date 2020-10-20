import java.util.Scanner;
import java.time.LocalTime;

public class FloorClass {
    public static void main(String[] args) {            // driver code
        Scanner scan = new Scanner(System.in);
        Car c = new Car();
        int spot1 = c.getEconomy();
        int spot2 = c.getEconomy();
        System.out.println(spot1);
        System.out.println(spot2);
        int s3= c.getEconomy();
        System.out.println(s3);
        c.ExitEconomyService(spot2);
        int s4=c.getEconomy();
        System.out.println(s4);
    }
}

class DisplayBoard{

}

interface Floor{
    public int getTotalSpots();
    public int getTotalEV();
    public int getTotalVIP();
    public int getEconomyVacancies();
    public int getEVVacancies();
    public int getVIPVacancies();
    private void portFolio(){}
    DisplayBoard db = new DisplayBoard();
}

class Car implements Floor{                // Floor number = 2

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
                EnterVIPService(current);
                return current;
            }
        }
        return -1;                              // no vacancy available
    }

    public int ExitEconomyService(int cur){
        if(cur<1 || cur>85 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
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
                break;
            } else if (payHere == 1) {
                portFolio(current);
                break;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor2[cur-1]=0;
        return 0;
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
        if(cur<86 || cur>95 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
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

    public int ExitVIPService(int cur){
        if(cur<96 || cur>100 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
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
        if(rCharge[cur-1]==1){
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
                portFolio(current);
                break;
            } else {
                System.out.println("Invalid option. Try again");
            }
        }
        floor2[cur-1]=0;
        return 0;
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