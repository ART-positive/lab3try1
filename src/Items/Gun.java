package Items;

import Locations.Location;

public class Gun extends Item{

    public Gun(int price, String nameItem, Location location){
        super(price, nameItem, location);
    }

    @Override
    public Location getLocation(){
        return super.getLocation();
    }
}
