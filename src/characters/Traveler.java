package characters;

import exceptions.SameGroupMembersFailException;
import locations.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static characters.Person.People;

public class Traveler extends Character  {

    public Traveler(String name, int age, Location location) {
        super(name, age, location);
    }
    public static class GroupTravelers {
        private ArrayList<Traveler> travelers = new ArrayList<>();

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
        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            for (Traveler i : this.travelers) {
                s.append(i.getName()).append(" ");
            }
            return s.toString();
        }
        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null) return false;
            if (this.getClass() != object.getClass()) return false;
            Map<Traveler, Integer> mp = new HashMap<>();
            for (Traveler i : travelers) {
                mp.put(i, 1);
            }
            for (Traveler i : ((GroupTravelers) object).getGroupTravelers()) {
                if(mp.containsKey(i))
                    mp.put(i, 0);
                else
                    return false;
            }
            for(Map.Entry<Traveler, Integer> pair : mp.entrySet())
            {
                Integer value = pair.getValue();
                if(value != 0) return false;
            }
            return true;
        }
        @Override
        public int hashCode() {
            int result = 0;
            for (Traveler i : travelers) {
                result += 31 * i.hashCode();
            }
            return result;
        }
        public void addTravelor(Traveler traveler){
            travelers.add(traveler);
        }
        public ArrayList<Traveler> getGroupTravelers(){
            return this.travelers;
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
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return this.getAge() == ((Traveler) object).getAge()
                && this.getPosition() == ((Traveler) object).getPosition();
    }
    @Override
    public int hashCode() {
        int result = getName() == null ? 0 : getName().hashCode();
        result = 31 * result + getAge();
        result += this.getPosition().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Traveler: "
                + "Name = '" + getName() + '\''
                + ", age = " + getAge()
                + ", location = " + getPositionName() + '\'';
    }
}
