package Characters;

import Items.*;
import Locations.*;

public class Person extends Character {
    private String gender;

    public Person(String name, int age, String gender, Location location) {
        super(name, age, location);
        this.gender = gender;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return this.getAge() == ((Person) object).getAge()
                && this.getPosition() == ((Person) object).getPosition();
    }
    @Override
    public int hashCode() {
        int result = getName() == null ? 0 : getName().hashCode();
        result = 31 * result + getAge();
        result += this.getPosition().hashCode();
        result += this.gender.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person: "
                + "Name = '" + getName() + '\''
                + ", age = " + getAge()
                + ", gender = " + this.gender
                + ", location = " + getPositionStr();
    }

    public String getGender(){
        return this.gender;
    }

    public void activatedAlarm(Sofa sofa) {

        if(sofa.activeAlarm()){
            panic();
        }
    }
    @Override
    public void walk(Location finish, Sofa sofa){
        System.out.println(this.getName() + " хочет дойти до локации " + finish.getName());
        if(super.canGo(this.getPosition(), finish.getCoordinates(), sofa.getPosition())) {
            System.out.println(this.getName() + " успешно дошёл до локации " + finish.getName());
            setLocation(finish);
        }
        else {
            System.out.println(this.getName() + " не смог дойти до локации " + finish.getName());
            System.out.println(this.getName() + " остановился перед " + sofa.getName());
            super.speak(this);
            System.out.println(this.getName() + " активировал звонок тревожной сигнализации");
            this.activatedAlarm(sofa);
            setLocation(sofa.getLocation());
        }
    }
}
