package characters;


import exceptions.DifferentLocationsFailException;
import items.*;
import locations.*;

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
                + ", location = " + getPositionName() + '\'';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return this.getAge() == ((Moomintroll) object).getAge()
                && this.getPosition() == ((Moomintroll) object).getPosition()
                && this.gun.hashCode() == ((Moomintroll) object).getGun().hashCode();
    }
    @Override
    public int hashCode() {
        int result = getName() == null ? 0 : getName().hashCode();
        result = 31 * result + getAge();
        result += 31 * result + this.getPosition().hashCode();
        result += 31 * result + this.getGun().hashCode();
        return result;
    }
    public void setAlarm(Sofa sf1){
        String cout = "Moomintroll " + this.getName() + " установил звонок тревожной сигнализации возле предмета " + sf1.getName();
        System.out.println(cout);
        sf1.setAlarm();
    }
    public void barredDoor(Sofa sf){
        System.out.println("Moomintroll " + this.getName() + " загородил дверь предметом " + sf.getName());
        sf.changeCoordinates(3, 3);
    }
    public void takeGun(Gun gun) throws DifferentLocationsFailException {
        System.out.println("Moomintroll " + this.getName() + " взял оружие " + gun.getName());
        if(gun.getLocation() != this.getLocation())
            throw new DifferentLocationsFailException(
                    this.getName() + " и " + gun.getName() + " находяться в разных локациях");
        this.gun = gun;
    }
    public Gun getGun() {
        return this.gun;
    }
    public void screaming(String s){
        System.out.println("Moomintroll " + this.getName() + " кричит : \'" + s + "\'");
    }

}
