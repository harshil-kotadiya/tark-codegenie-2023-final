package MileStone1;

import java.util.*;



// Trains call to store train information
class Train{
    String Train_Number;
    String Intial_Station;
    String Final_Station;
    String Distance;
    HashMap<String,Integer>seats;
    HashMap<String,HashMap<String,Integer>> date_seat_left = new HashMap<>();
}


// Ticket class to store information of ticket like ticket number and fare
class Ticket{
    int Ticket_number;
    int fare;
    String Booking_date;
    Ticket(int ticket_number, int fare,String date){
        this.Ticket_number = ticket_number;
        this.fare = fare;
        this.Booking_date = date;
    }
}


public class TrainManagementSystem {


    static int TICKET_NUMBER =100000000;

    // to store information about all trains
    public static List<Train>alltrains = new ArrayList<>();

    // to store information about all tickets
    public static List<Ticket>all_tickets = new ArrayList<>();

    // for getting name of the city
    static String getcityname(String s){
        int i=0;
        while (s.charAt(i)!='-')i++;
        return s.substring(0,i);
    }

    // for getting distance from intial city to final city
    static String getdistance(String s){
        int i=0;
        while (s.charAt(i)!='-')i++;

        return s.substring(i+1);
    }

    //to store information about seats available in a train of a particular category
    static HashMap<String,Integer> getseats(String [] seats){
        HashMap<String,Integer> map_seats  = new HashMap<>();
        for (int i=1;i<seats.length;i++){
            map_seats.put(getcityname(seats[i]),Integer.parseInt(getdistance(seats[i])));
        }
        return map_seats;
    }




    //to check if seats are available to book
    static String CheckIfSeatsAreAvailable(Train train,String[]ticket_to_book){
        String s = "";
        String coach_class  = convert_to_class(ticket_to_book[3]);
        int tickets_to_book = Integer.parseInt(ticket_to_book[4]);
        String datetobook = ticket_to_book[2];



        // if the train has been booked before
        if (train.date_seat_left.containsKey(datetobook)){
            for (Map.Entry<String,Integer> mapElement : train.date_seat_left.get(datetobook).entrySet()) {
                String key = mapElement.getKey();
                if (key.contains(coach_class)){
                    if (tickets_to_book<=mapElement.getValue()){
                        Ticket ticket = new Ticket(TICKET_NUMBER+1,getfare(coach_class,tickets_to_book, Integer.parseInt(train.Distance)),datetobook);
                        TICKET_NUMBER++;
                        // add ticket to List of ticket
                        all_tickets.add(ticket);
                        // updating the seats now available in a cabin
                        mapElement.setValue(mapElement.getValue()-tickets_to_book);

                        s=ticket.Ticket_number+" "+ticket.fare;
                        return s;
                    }
                    else{
                        return "No Seats Available";
                    }
                }

            }
        }


        for (Map.Entry<String,Integer> mapElement : train.seats.entrySet()) {
            String key = mapElement.getKey();
            if (key.contains(coach_class)){
                if (tickets_to_book<=mapElement.getValue()){
                    Ticket ticket = new Ticket(TICKET_NUMBER+1,getfare(coach_class,tickets_to_book, Integer.parseInt(train.Distance)),datetobook);
                    TICKET_NUMBER++;
                    // add ticket to List of ticket
                    all_tickets.add(ticket);
                    // updating the seats now available in a cabin
//                    mapElement.setValue(mapElement.getValue()-tickets_to_book);

                    HashMap<String ,Integer>updated_seats = new HashMap<>();
                    updated_seats.putAll(train.seats);

                    updated_seats.put(key,mapElement.getValue()-tickets_to_book);
                    train.date_seat_left.put(datetobook,updated_seats);


                    s=ticket.Ticket_number+" "+ticket.fare;
                    return s;
                }
                else{
                    return "No Seats Available";
                }
            }

        }

        return "";
    }

    // this is to convert class given in ticket to class present in train class
    static String convert_to_class(String coachclass){
        if (coachclass.equals("SL")) return "S";
        else if(coachclass.equals("3A")) return "B";
        else if(coachclass.equals("2A")) return "A";
        else if(coachclass.equals("1A"))return "H";
        else {
            return "Invalid class";
        }
    }

    static int getfare(String coach_class,int tickets_to_book,int distance){
        if(coach_class.equals("S"))return tickets_to_book * distance;
        else if(coach_class.equals("B"))return tickets_to_book*2*distance;
        else if(coach_class.equals("A"))return tickets_to_book*3*distance;
        else if(coach_class.equals("H"))return tickets_to_book*4*distance;
        return 0;
    }






    public static void main(String[] args) {

        // work in progress

        Scanner s = new Scanner(System.in);

        int nooftrains = Integer.parseInt( s.nextLine());


        for (int i=0;i<nooftrains;i++){
            Train train = new Train();
            String [] str = s.nextLine().split(" ");
            train.Train_Number  = str[0];
            train.Intial_Station = getcityname(str[1]);
            train.Final_Station = getcityname(str[2]);
            train.Distance = getdistance(str[2]);

            String [] seats = s.nextLine().split(" ");
            train.seats = getseats(seats);
            alltrains.add(train);
        }



        while (true){
            int count = nooftrains;
            String [] book_ticket = s.nextLine().split(" ");
            for (Train train:alltrains){
                if (train.Intial_Station.equals(book_ticket[0]) && train.Final_Station.equals(book_ticket[1])){
                    String output = CheckIfSeatsAreAvailable(train,book_ticket);
                    System.out.println(output);
                }
                else{
                    count--;
                }
            }
            if (count==0){
                System.out.println("No Trains Available");
            }
        }



        // check if the train object are stored in
//        for (Train train:alltrains){
//            System.out.println(train.Train_Number+", "+train.Intial_Station+" "+train.Final_Station+" "+train.Distance);
//            System.out.println(train.seats);
//        }


    }

}
