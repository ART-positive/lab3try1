package Items;
import java.lang.*;

import Interfaces.Name;
import Interfaces.Position;
import Locations.Location;
import Pairs.Pair;

public class Sofa extends Item {
    private final String color;
    private static boolean Alarm = false;
    public Sofa(String color, int price, String nameItem, Location location){
        super(price, nameItem, location);
        if ((color == null) || (color.isEmpty())) {
            throw new IllegalArgumentException("Некорректное название цвета!");
        }
        this.color = color;
    }

    public class Pillow {
        private final String material;
        private final Pair size;

        public Pillow(String material, int x_size, int y_size){
            if ((material == null) || (material.isEmpty())) {
                throw new IllegalArgumentException("Некорректное название материала!");
            }
            this.material = material;
            this.size = new Pair(x_size, y_size);
        }

        public String getSofa(){
            return getName();
        }
        public String getMaterial(){
            return this.material;
        }
        public Pair getSize(){
            return this.size;
        }

        @Override
        public String toString() {
            return "Pillow: "
                    + "sofa = '" + getSofa() + '\''
                    + ", material = " + getMaterial()
                    + ", size = " + getSize();
        }
        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null) return false;
            if (this.getClass() != object.getClass()) return false;
            return  this.getSofa().equals(((Pillow) object).getSofa())
                    && this.size.getb() == ((Pillow) object).size.getb()
                    && this.size.geta() == ((Pillow) object).size.geta()
                    && this.getMaterial().equals(((Pillow) object).getMaterial());
        }
        @Override
        public int hashCode() {
            int result = size.geta() * 31 + size.getb();
            result = 31 * result + getSofa().hashCode();
            result = 31 * result + getMaterial().hashCode();
            return result;
        }
    }
    @Override
    public String toString() {
        return "Sofa: "
                + "Name = '" + getName() + '\''
                + ", price = " + getPrice()
                + ", location = " + getPositionStr() + '\''
                + ", color = " + getColor();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return  this.hashCode() == object.hashCode();
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
