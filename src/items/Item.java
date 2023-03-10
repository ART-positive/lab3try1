package items;

import interfaces.Name;
import interfaces.Position;
import interfaces.Price;
import locations.Location;
import pairs.Pair;

public abstract class Item implements Price, Name, Position {
    private int price;
    private String name;
    private Location location;

    public Item(int price, String nameItem, String nameLocation, int x, int y) {
        if (price < 0) {
            throw new NumberFormatException("Цена не может быть отрицательной!");
        }
        this.price = price;
        if ((nameItem == null) || (nameItem.isEmpty())) {
            throw new IllegalArgumentException("Некорректное название предмета!");
        }
        this.name = nameItem;
        this.location = new Location(nameLocation, x, y);
    }
    public Item(int price, String nameItem, Location location2) {
        this.price = price;
        this.name = nameItem;
        this.location = location2;
    }


    @Override
    public String getName() {
        return this.name;
    }

    public void getPositionPrint(){
        String s = this.name;
        System.out.println(this.name + " находиться на локации " + this.location.getName());
    }
    @Override
    public String getPositionName(){
        return this.location.getName();
    }
    @Override
    public Pair getPosition(){
        return this.location.getCoordinates();
    }
    @Override
    public int getPrice(){
        return this.price;
    }
    public void changeCoordinates(int x, int y){
        Pair pr = new Pair(x, y);
        location.setCoordinates(pr);
    }
    @Override
    public void changePrice(int newPrice){
        this.price = newPrice;
    }

    public Location getLocation(){
        return this.location;
    }


}
