package Characters;

import Exceptions.SameGroupMembersFailException;
import Items.Sofa;
import Locations.Location;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;

import static Characters.Person.People;

public class Traveler extends Character  {

    public Traveler(String name, int age, Location location) {
        super(name, age, location);
    }
    public static class GroupTravelers {
        private ArrayList<Traveler> travelers = new ArrayList<>();

        public GroupTravelers(Traveler tr1, Traveler tr2) throws SameGroupMembersFailException {
            if(tr1.hashCode() == tr2.hashCode())
                throw new SameGroupMembersFailException("В одной группе не может быть два одинаковых путника!");
            travelers.add(tr1);
            travelers.add(tr2);
        }
        public GroupTravelers(Traveler tr1, Traveler tr2, Traveler tr3) throws SameGroupMembersFailException {
            if(tr1.hashCode() == tr2.hashCode() || tr2.hashCode() == tr3.hashCode() || tr1.hashCode() == tr3.hashCode())
                throw new SameGroupMembersFailException("В одной группе не может быть два одинаковых путника!");
            travelers.add(tr1);
            travelers.add(tr2);
            travelers.add(tr3);
        }
        public GroupTravelers(Traveler... trs) throws SameGroupMembersFailException {
            Map<Traveler, Integer> mp = new HashMap<>();
            for (Traveler i : trs) {
                if(mp.containsKey(i))
                    throw new SameGroupMembersFailException("В одной группе не может быть два одинаковых путника!");
                else
                    mp.put(i, 1);
            }
            Collections.addAll(travelers, trs);
        }

        public void walk(Location location){
            for (Traveler i : this.travelers) {
                i.walk(location);
            }
        }
        public void getHome(Location location){
            System.out.println("Путников приняли в Муми-дом");
            this.walk(location);
        }
        public void runAndHide(Location location){
            for (Traveler i : this.travelers) {
                System.out.println(i.getName() + " перепугался и спрятaлся в локации " + location.getName());
                i.setLocation(location);
            }

            int n = (int)Math.floor(Math.random() * People.size());
            int n1 = (int)Math.floor(Math.random() * People.size());
            while(n == n1) n1 = (int)Math.floor(Math.random() * People.size());
            People.get(n).walk(location);
            People.get(n1).walk(location);
        }

    }
    @Override
    public void walk(Location finish){
        System.out.println(this.getName() + " дошёл до локации " + finish.getName());
        this.setLocation(finish);
    }
}
