package Items;

import Locations.Location;

public class Gun extends Item{

    public Gun(int price, String nameItem, Location location){
        super(price, nameItem, location);
    }

    @Override
    public String toString() {
        return "Gun: "
                + "Name = '" + getName() + '\''
                + ", price = " + getPrice()
                + ", location = " + getPositionName();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return  this.getPosition().geta() == ((Gun) object).getPosition().geta()
                && this.getPosition().geta() == ((Gun) object).getPosition().getb()
                && this.getPrice() == ((Gun) object).getPrice();
    }
    @Override
    public int hashCode() {
        int result = getPrice();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLocation().hashCode();
        return result;
    }
}
