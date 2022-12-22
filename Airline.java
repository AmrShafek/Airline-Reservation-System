
package airline;
import java.sql.Time;
import java.util.Scanner;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom; 
import java.time.LocalDate;  
public class Airline {

    public static void main(String[] args) {
   Scanner input = new Scanner(System.in) ;   
   int option ;
   boolean q=true;
    while(q){
        System.out.println("press 1 to Book ticket");
        System.out.println("press 2 to Exit");
        option =input.nextInt();
       switch(option){
        case 1:
        reservations ob = new reservations();
        System.out.println("----------------------------------");
        System.out.println("The name is : "+ob.get_Person_name());
        System.out.println("The address is : "+ob.get_Person_address());
        System.out.println("The airport name : "+ob.get_name_Airport());
        System.out.println("The Passenger number is : "+ob.get_Passenger_number());
        System.out.println("The departure locatin is : "+ob.get_From());
        System.out.println("The arrival locatin is : "+ob.get_to());
        System.out.println("The date of flight is : "+ob.generateRandomDate());
        System.out.println("The departure time is : "+ob.time());
        System.out.println("The arrival time is : "+ob.time());
        System.out.println("The date of booking "+ob.generateRandomDate());
        System.out.println("-----------------------------------");
        System.out.println("Have a nice journey");
        System.out.println("***********************************");
        break ;
        case 2 :
            q=false;
            System.out.println("Thank You");
            break;
}
       }
    }
    
}
interface Airport {
public void set_name_Airport(String name_Airport);
public String get_name_Airport();

}
interface person extends Airport{
public void setPerson_name(String name);
public String get_Person_name();
public void set_Person_address(String address);
public String get_Person_address();
}
interface passenger extends person{
public void set_Passenger_number(int Passenger_number) ;
public int get_Passenger_number() ;
}
interface flight_describtion extends Airport{
public void set_From(String from);
public String get_From();
public void set_to(String to);
public String get_to();
public String get_Arrival();
public void set_Arrival(String arrival);
public String get_Departure();
public void set_Departure(String departure);
}
interface scheduled_flight extends flight_describtion{
public String get_Date_flight();
public void set_Date_flight(String date_flight);

}
final class reservations implements passenger,scheduled_flight{ 
    static Scanner input = new Scanner(System.in) ;
    static Random rand =new Random();
    public String Person_name;
    public String Person_address;
    public String name_Airport;
    public String date_flight;
    public String from;
    public String to;
    public String departure;
    public String arrival;
    public String data_made;
    public int Passenger_number=rand.nextInt(1000);
    private final static java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("dd/MM/yyyy");
    public reservations (){
       System.out.println("Which Airport you prefere ");
       String name_air=input.nextLine();
       this.set_name_Airport(name_air);
        System.out.println("Enter Your name ");
        String name =input.nextLine();
        this.setPerson_name(name);

        System.out.println("Enter Your address ");
        String Person_add=input.nextLine();
        set_Person_address(Person_add);
        System.out.println("From Which country you will leave ");
        String froml=input.nextLine();
        set_From(froml);
        System.out.println("Which country you will go  ");
        String tol=input.nextLine();
        set_to(tol);
    }
   public String generateRandomDate(){
   Random r = new Random();
    java.util.Calendar c = java.util.Calendar.getInstance();
    c.set(java.util.Calendar.MONTH, Math.abs(r.nextInt()) % 12);
    c.set(java.util.Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
    c.setLenient(true);
    return DATE_FORMAT.format(c.getTime()); 
    
    }
   public Time time (){
  final Random random = new Random();
final int millisInDay = 24*60*60*1000;
Time time = new Time((long)random.nextInt(millisInDay));
        return time; 
   }
    public String getData_made() {
        return data_made;
    }

    public void setData_made(String data_made) {
        this.data_made = data_made;
    }
     @Override
    public void set_name_Airport(String name_Airport){
        this.name_Airport=name_Airport;
    }

    @Override
    public void setPerson_name(String name) {
        this.Person_name=name;
    }
    @Override
    public void set_Person_address(String address) {
        this.Person_address=address;
    }
    @Override
    public void set_From(String from) {
        this.from=from;
    }
    @Override
    public void set_to(String to) {
        this.to=to;
    }
    @Override
    public void set_Passenger_number(int Passenger_number) {
        this.Passenger_number=Passenger_number;
        
    }
    @Override
    public void set_Date_flight(String date_flight) {
    }
        @Override
    public void set_Arrival(String arrival) {
        this.arrival=arrival;
    }
    

    @Override
    public void set_Departure(String departure) {
        this.departure=departure;
                
    }

    @Override
    public String get_Person_name() {
        return this.Person_name;
        
    } 

    @Override
    public int get_Passenger_number() {
        return this.Passenger_number;
    }

    @Override
    public String get_Person_address() {
        return this.Person_address;
    }

    @Override
    public String get_name_Airport(){
     return this.name_Airport;
    }
    @Override
    public String get_Date_flight() {
        return this.date_flight;
    }
    @Override
    public String get_From() {
        return this.from;
    }
    @Override
    public String get_to() {
        return this.to;
    }
    @Override
    public String get_Arrival() {
        return this.arrival;
    }
    @Override
    public String get_Departure() {
        return this.departure;
    }

}