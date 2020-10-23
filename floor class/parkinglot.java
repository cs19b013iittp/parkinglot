import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {            // driver code

        DisplayBoard ui=new DisplayBoard();
        ui.run();
    }
}


class Building {
    Scanner input = new Scanner(System.in);
    Car c = new Car();
    Bike bk = new Bike();
    Truck tr = new Truck();
    public void show_display(int floorNumber){
        if(floorNumber==2){
            for(int i=0; i<100; i++){
                if(i%10==0)
                    System.out.println("");
                if(Car.floor2[i]>0)
                    System.out.print("1 ");
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
                else
                    System.out.print("0 ");
            }
        }
        else if(floorNumber==3){
            for(int i=0; i<200; i++){
                if(i%10==0)
                    System.out.println("");
                if(Bike.floor3[i]>0)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
        }
    }
    public void show_display(){
        System.out.println("Floor 1 status:");
        for(int i=0; i<50; i++){
            if(i%10==0)
                System.out.println("");
            if(Truck.floor1[i]>0)
                System.out.print("1 ");
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
            else
                System.out.print("0 ");
        }
        System.out.println("");
    }
    public int validate(String vehicleType){
        if(vehicleType.toLowerCase().equals("truck"))
            return 1;
        else if (vehicleType.toLowerCase().equals("car"))
            return 2;
        else if (vehicleType.toLowerCase().equals("bike"))
            return 3;
        else
            return -1;
    }
    public int validate(String s,int x)
    {

        int floorNo=s.charAt(0)-'0';
        int token=0;
        for(int i=2;i<s.length();i++)
        {
            token*=10;
            token+=s.charAt(i)-'0';
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
    public int getFloor(String vehicle, boolean ev, boolean vip){
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
    public int pay(String s){
        int floorNumber=s.charAt(0)-'0';
        int token=0,spotNumber=0;
        if(floorNumber==1){
            for(int i=2;i<s.length();i++)
            {
                token*=10;
                token+=s.charAt(i)-'0';
            }
            int time,amount;
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
                return 2;
            }
        }
        else if (floorNumber==2){
            for(int i=2;i<s.length();i++)
            {
                token*=10;
                token+=s.charAt(i)-'0';
            }
            int time,amount;
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
                return 2;
            }

        }
        else{
            for(int i=2;i<s.length();i++)
            {
                token*=10;
                token+=s.charAt(i)-'0';
            }
            int time,amount;
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
                return 2;
            }
        }
        return -1;
    }

    public void paymentOptions(int floor, int spot){
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

    public int timeToCash(int time, int floor, int spot){
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
}


class DisplayBoard{

    public void run()
    {
        Scanner scan = new Scanner(System.in);
        Building parkinglot = new Building();
        int n;
        while(true)
        {
            System.out.println("Please enter 1 to view display board, 2 to park your vehicle, 3 to exit and other to exit the software");
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
                System.out.println("Enter 'bike' if your vehicle is bike");
                System.out.println("Enter 'car' if your vehicle is car");
                System.out.println("Enter 'truck' if your vehicle is truck");
                vehical_type=scan.next();
                System.out.println("If EV, enter 'true' else 'false'");                 // Haven't taken care of error cases
                isev=scan.nextBoolean();
                System.out.println("If you want VIP service, enter 'true' else 'false'");
                isvip=scan.nextBoolean();
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
            else
                break;
        }
    }
}

/**************************************** Floor Class *****************************************************************/

abstract class Floor{

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

class Car extends Floor{                // Floor number = 2

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

    public int ExitEconomyService(int cur){
        if(cur<1 || cur>85 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60 + tm.getMinute();
        int time = tm.getHour()*60 + tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
    }

    private void EnterEVService(int cur){
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

    public int ExitEVService(int cur){
        if(cur<86 || cur>95 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60+tm.getMinute();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterVIPService(int cur){
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

    public int ExitVIPService(int cur){
        if(cur<96 || cur>100 || floor2[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60+tm.getMinute();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

}



/* ****************************************************** BIKE BIKE BIKE BIKE ************************************************************ */



class Bike extends Floor{                // Floor number = 2

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

    public int ExitEconomyService(int cur){
        if(cur<1 || cur>150 || floor3[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60 + tm.getMinute();
        int time = tm.getHour()*60 + tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
    }

    private void EnterEVService(int cur){
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

    public int ExitEVService(int cur){
        if(cur<151 || cur>180 || floor3[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60+tm.getMinute();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterVIPService(int cur){
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

    public int ExitVIPService(int cur){
        if(cur<181 || cur>200 || floor3[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60+tm.getMinute();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

}




/* ******************************************* TRUCK TRUCK TRUCK TRUCK **************************************************** */





class Truck extends Floor{                // Floor number = 2

    Scanner scan = new Scanner(System.in);

    private static final int totalSpots = 50;    // 1-150:Economy, 151-180:EV, 181-200:VIP

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

    public int ExitEconomyService(int cur){
        if(cur<1 || cur>40 || floor1[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60 + tm.getMinute();
        int time = tm.getHour()*60 + tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterEconomyService(int cur){
        LocalTime tm = LocalTime.now();
        now[cur-1] = tm.getHour()*60+tm.getMinute();
    }

    private void EnterEVService(int cur){
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

    public int ExitEVService(int cur){
        if(cur<41 || cur>45 || floor1[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60+tm.getMinute();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

    private void EnterVIPService(int cur){
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

    public int ExitVIPService(int cur){
        if(cur<46 || cur>50 || floor1[cur-1]==0){
            System.out.println("Invalid spot");
            return -1;
        }
        LocalTime tm = LocalTime.now();
//        then[cur - 1] = tm.getHour()*60+tm.getMinute();
        int time = tm.getHour()*60+tm.getMinute() - now[cur - 1];
        return time;
    }

}
