package Items;
import java.lang.*;

import Locations.Location;
import Pairs.Pair;

public class Sofa extends Item {
    private String color;
    private static boolean Alarm = false;
    public Sofa(String color, int price, String nameItem, Location location){
        super(price, nameItem, location);
        if ((color == null) || (color.isEmpty())) {
            throw new IllegalArgumentException("Некорректное название цвета!");
        }
        this.color = color;
    }


    @Override
    public String toString() {
        return "Sofa: "
                + "Name = '" + getName() + '\''
                + ", price = " + getPrice()
                + ", location = " + getPositionStr()
                + ", color = " + getColor();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return  this.getPrice() == ((Sofa) object).getPrice();
    }
    @Override
    public int hashCode() {
        int result = color == null ? 0 : color.hashCode();
        result = 31 * result + getPrice();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLocation().hashCode();
        return result;
    }
    public Sofa(String color, int price, String nameItem, String nameLocation, int x, int y){
        super(price, nameItem, nameLocation, x, y);
        this.color = color;
    }
    @Override
    public Pair getPosition(){
        return super.getPosition();
    }

    @Override
    public Location getLocation(){
        return super.getLocation();
    }
    public boolean activeAlarm(){
        return Alarm;
    }
    public void setAlarm(){
        Alarm = true;
    }
    public String getColor() {
        return this.color;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
