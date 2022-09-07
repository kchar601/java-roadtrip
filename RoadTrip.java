import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.net.ssl.HandshakeCompletedListener;

public class RoadTrip {
    private String minivanName;
    protected HashSet<Passenger> passengers;
    private HashSet<String> states;
    private HashMap<String, HashSet<String>> statesByPassenger;
    
    public RoadTrip(String minivanName) {
        this.minivanName = minivanName;
        passengers = new HashSet();
        states = new HashSet();
        statesByPassenger = new HashMap();
    }

    public boolean addPassenger(Passenger pass)
    {
        if (passengers.size()<8)
        {
        passengers.add(pass);
        return true;
        }
        else
        {
            return false;
        }
    }

    public void displayPassengers()
    {
        Iterator iter = passengers.iterator();
        System.out.println("Minivan: " + minivanName);
        while(iter.hasNext())
        {
            System.out.println("\tPassenger:" + iter.next());
        }
    }

    public void addStateVisited(Passenger p, String state)
    {
        if (statesByPassenger.containsKey(p.getName()))
        {
            statesByPassenger.get(p.getName()).add(state);
        }
        else{
        HashSet<String> newState = new HashSet();
        newState.add(state);
        statesByPassenger.put(p.getName(), newState);}
    }

    public void displayStatesVisited()
    {
        Iterator itrtr = statesByPassenger.entrySet().iterator();
        System.out.println("Vehicle: " + minivanName);
        while(itrtr.hasNext())
        {
            System.out.print(itrtr.next() + ", ");
        }
    }

    public HashSet<String> getStatesByName(String name)
    {
        return statesByPassenger.get(name);
    }

    public boolean checkPassenger(String s, String x)
    {
        return (statesByPassenger.containsKey(s + " " + x));
    }
}
