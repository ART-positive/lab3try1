package characters;

import enums.Panic;
import enums.Weapon;
import interfaces.Name;
import interfaces.Position;
import items.Sofa;
import pairs.Pair;
import locations.*;

public abstract class Character implements Name, Position {
    private String name;
    private int age;
    private Location location;
    public Character(String name, int age, Location location) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("Некорректное имя!");
        }
        this.name = name;
        if (age < 0) {
            throw new NumberFormatException("Возраст не может быть отрицательным!");
        }
        this.age = age;
        this.location = location;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return this.getAge() == ((Character) object).getAge()
                && this.location.getCoordinates() == ((Character) object).location.getCoordinates();
    }
    @Override
    public int hashCode() {
        int result = getName() == null ? 0 : getName().hashCode();
        result = 31 * result + getAge();
        result += this.location.hashCode();
        return result;
    }

    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
    public int getAge(){
        return this.age;
    }

    protected void speak(Character ch) {
        System.out.println(ch.getName() + " сказал: " + "\"Это еще что за выдумки!\"");
    }
    public void walk(Location finish, Sofa sofa1){
        System.out.println(this.getName() + " хочет дойти до локации " + finish.getName());
        if(finish.getCoordinates() == sofa1.getPosition() || canGo(this.getPosition(), finish.getCoordinates(), sofa1.getPosition())) {
            System.out.println(this.getName() + " успешно дошёл до локации " + finish.getName());
            this.location = finish;
        }
        else {
            System.out.println(this.getName() + " не смог дойти до локации " + finish.getName());
            System.out.println(this.getName() + " остановился перед " + sofa1.getName());
            this.location = sofa1.getLocation();
        }
    }
    public void walk(Location finish){
        System.out.println(this.getName() + " дошёл до локации " + finish.getName());
        this.location = finish;
    }
    public void takeWeaponRunIncident(Location finish) {
        System.out.println(this.getName() + " взял " + Weapon.getRandomWeapon() + " и побежал в локацию " + finish.getName());
        this.location = finish;
    }
    protected void panic(){
        System.out.print("Дом наполнился ");
        boolean flag = false;
        for(Panic emotions : Panic.values()) {
            if(flag) System.out.print(", " + emotions);
            else System.out.print(emotions);
            flag = true;
        }
        System.out.println("!");
    }



    protected boolean canGo(Pair start, Pair finish, Pair let) {
        if(Math.abs(DistanceBetweenPoints(start, let)
                + DistanceBetweenPoints(let, finish) - DistanceBetweenPoints(start, finish)) < 0.0001d) {
            return false;
        }
        else {
            return true;
        }
    }
    private double DistanceBetweenPoints(Pair x, Pair y) {
        double a = Math.abs(x.geta() - y.geta());
        double b = Math.abs(x.getb() - y.getb());
        return Math.hypot(a, b);
    }
    @Override
    public void getPositionPrint(){
        System.out.println(this.name + " находиться на локации " + this.location.getName());
    }
    @Override
    public Pair getPosition(){
        return this.location.getCoordinates();
    }
    @Override
    public String getPositionName(){
        return this.location.getName();
    }
    @Override
    public String getName() {
        return this.name;
    }

    public void changeName(String name) {
        this.name = name;
    }
}
