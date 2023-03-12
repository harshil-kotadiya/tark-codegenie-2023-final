package MileStone1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Train{
String Train_Number;
String Intial_Station;
String Final_Station;
String Distance;
HashMap<String,Integer>seats;

//Train(String train_number,String initial_station,String final_station,String distance,HashMap<String,Integer>map_seats){
//    this.Train_Number = train_number;
//    this.Intial_Station = initial_station;
//    this.Final_Station = final_station;
//    this.Distance = distance;
//    this.seats  = map_seats;
//}
}





public class TrainManagementSystem {

    final int TICKET_NUMBER =100000000;
    int No_of_Trains;
    public static List<Train>alltrains = new ArrayList<>();




    TrainManagementSystem(int no_of_trains){
    this.No_of_Trains = no_of_trains;
    }



    public static void main(String[] args) {

        // work in progress


        Scanner s = new Scanner(System.in);

        int nooftrains = Integer.parseInt( s.nextLine());

        for (int i=0;i<nooftrains;i++){
            Train new
            String [] str = s.nextLine().split(" ");

        }





//        ArrayList<ArrayList<String>> initial_input = new ArrayList<>();
//        while (s.hasNextLine()){
//            ArrayList<String> str = new ArrayList<>();
//
//            String line = s.nextLine();
//            if ("".equals(line)) {
//                break;
//            }
//            str.add(line);
//            initial_input.add(str);
////            in.add(line);
//            //infinite loop
//        }



//        System.out.println("loop break");
//        System.out.println(initial_input);
//        System.out.println(initial_input.get(0).get(0));

        // getting the number of trains from input
//         int numoftrains = Integer.parseInt(initial_input.get(0).get(0));
//
//        TrainManagementSystem tr =new TrainManagementSystem(numoftrains);
//
//
//        System.out.println(numoftrains);
////        System.out.println(initial_input.size());
//        //running the loop for
//        int index =1;
//        String  st= initial_input.get(index).get(0);
//        String [] se = st.split(" ");
//        for (String s1:
//             se) {
//            System.out.println(s);
//        }
//        while (numoftrains>0 && index<initial_input.size()){
//            Train train = new Train();
//            String [] st= initial_input.get(index).get(0).split(" ");
//
//
//
//
//            alltrains.add(train);
//            numoftrains--;
//        }



}

}
