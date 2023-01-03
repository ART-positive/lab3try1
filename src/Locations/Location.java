package Locations;

import Interfaces.Name;
import Interfaces.Position;
import Items.Clock;
import Pairs.Pair;


public class Location implements Name {
    private String name;
    private Pair pair;

    public Location(String name, int x, int y){
        this.name = name;
        Pair pair = new Pair(x, y);
        this.pair = pair;
    }

    public Pair getCoordinates(){
        return this.pair;
    }
    @Override
    public String toString() {
        return "Location: "
                + "Name = '" + getName() + '\''
                + ", coordinates = " + this.getCoordinates().geta() + " " + this.getCoordinates().getb();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return  this.pair.geta() == ((Location) object).pair.geta()
                && this.pair.getb() == ((Location) object).pair.getb();
    }
    @Override
    public int hashCode() {
        int result = pair.geta() + pair.getb() == 0 ? 0 : pair.hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
    @Override
    public String getName() {
        return this.name;
    }

    public void setCoordinates(Pair pair) {
        this.pair = pair;
    }


}
