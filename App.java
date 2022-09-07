import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String fName = " ";
        String lName;
        String phoneNumber;
        String state = " ";
        System.out.println("Enter the nickname of the vehicle: ");
        String minivanName = scnr.nextLine();
        RoadTrip rTrip = new RoadTrip(minivanName);
        while(!fName.equalsIgnoreCase("q"))
        {
            System.out.println("Enter the first name of the passenger you would like to add (enter q to quit): ");
            fName = scnr.nextLine();
            if (!fName.equalsIgnoreCase("q")){
                System.out.println("Enter the last name of the passenger: ");
                lName = scnr.nextLine();
                System.out.println("Enter the phone number of the passenger: ");
                phoneNumber = scnr.nextLine();
                Passenger e = new Passenger(fName, lName, phoneNumber);
                if(rTrip.addPassenger(e))
                {
                    System.out.println("Passenger " + fName + " " + lName + " was successfully added to the road trip.");
                }
                else
                {
                    System.out.println("Passenger " + fName + " " + lName + " could not be added because the minivan is full.");
                }
                while(!state.equalsIgnoreCase("q"))
                {
                    System.out.println("Enter the states " + fName + " has visited (enter q to quit): ");
                    state = scnr.nextLine();
                    if(!state.equalsIgnoreCase("q"))
                    {
                        rTrip.addStateVisited(e, state);
                        System.out.println(state + " was successfully added to " + fName + "'s list of states.");
                    }
                }
                state = " ";
            }

        }
        fName = " ";
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("\nYou will now be able to view states visited for each passenger.");
        while(!fName.equalsIgnoreCase("q"))
        {
            System.out.println("Enter the first name of the passenger (enter q to quit): ");
            fName = scnr.nextLine();
            if(!fName.equalsIgnoreCase("q")){
                System.out.println("Enter the last name of the passenger: ");
                lName = scnr.nextLine();
                if(rTrip.checkPassenger(fName, lName))
                {
                    System.out.println(rTrip.getStatesByName(fName + " " + lName));
                }
            }
            System.out.println();
        }
        rTrip.displayStatesVisited();
    }
}