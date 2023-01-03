package Characters;

import Items.Sofa;
import Locations.Location;

import java.util.ArrayList;

public class Travelers extends Character{

    static ArrayList<newTraveler> travelers = new ArrayList<>();
    public Travelers(String name, int age, Location location) {
        super(name, age, location);
        //Travelers.add()
    }
    public class newTraveler {
        private String name;
        private int age;
        private Location location;

        public newTraveler(String name, int age, Location location) {
            if ((name == null) || (name.isEmpty())) {
                throw new IllegalArgumentException("Некорректное имя!");
            }
            this.name = name;
            if (age < 0) {
                throw new NumberFormatException("Возраст не может быть отрицательным!");
            }
            this.age = age;
            this.location = location;
        }
    }
    @Override
    public void walk(Location finish){
        System.out.println(this.getName() + " успешно дошёл до локации " + finish.getName());
        //this.location = finish;
    }
}
