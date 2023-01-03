package Characters;


import Items.*;
import Locations.*;
public class Moomintroll extends Character {

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
        String cout = "Moomintroll " + this.getName() + " установил звонок тревожной сигнализации возле локации " + sf1.getName();
        System.out.println(cout);
        sf1.setAlarm();
    }

}
