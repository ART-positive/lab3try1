package Characters;


import Exceptions.DifferentLocationsFailException;
import Items.*;
import Locations.*;

import java.util.ArrayList;

public class Moomintroll extends Character {

    private Gun gun;

    public Moomintroll(String name, int age, Location location) {
        super(name, age, location);
    }

    @Override
    public int getAge(){
        float age1 = super.getAge();
        return Math.round(age1 * 0.7f);
    }
    @Override
    public String toString() {
        return "Moomintroll: "
                + "Name = '" + getName() + '\''
                + ", age = " + getAge()
                + ", location = " + getPositionStr();
    }
    public void setAlarm(Sofa sf1){
        String cout = "Moomintroll " + this.getName() + " установил звонок тревожной сигнализации возле предмета " + sf1.getName();
        System.out.println(cout);
        sf1.setAlarm();
    }
    public void barredDoor(Sofa sf){
        System.out.println("Moomintroll " + this.getName() + " загородил дверь предметом " + sf.getName());
        sf.setCoordinates();
    }
    public void takeGun(Gun gun) throws DifferentLocationsFailException {
        System.out.println("Moomintroll " + this.getName() + " взял оружие " + gun.getName());
        gun.getLocation();
        if(gun.getLocation() != this.getLocation())
            throw new DifferentLocationsFailException(
                    this.getName() + " и " + gun.getName() + " находяться в разных локациях");
        this.gun = gun;
    }
    public void screaming(String s){
        System.out.println("Moomintroll " + this.getName() + " кричит : \'" + s + "\'");
    }

}
