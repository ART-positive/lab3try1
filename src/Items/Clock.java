package Items;

import Locations.Location;
import Pairs.Pair;
public class Clock extends Item {
    private Pair time;

    public Clock(int price, String nameItem, Location location, int hours, int minutes){
        super(price, nameItem, location);
        Pair time = new Pair(hours, minutes);
        if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("У " + nameItem + " некорректное время!");
        }
        this.time = time;
        clockStruck(time);
    }
    @Override
    public String toString() {
        return "Clock: "
                + "Name = '" + getName() + '\''
                + ", price = " + getPrice()
                + ", location = " + getPositionStr()
                + ", time = " + this.time.geta() + ":" + this.time.getb();
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        return  this.time.geta() == ((Clock) object).time.geta()
                && this.time.getb() == ((Clock) object).time.getb()
                && this.getPrice() == ((Clock) object).getPrice();
    }
    @Override
    public int hashCode() {
        int result = time.geta() + time.getb() == 0 ? 0 : time.hashCode();
        result = 31 * result + getPrice();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLocation().hashCode();
        return result;
    }

    public void setTime(int hours, int minutes) {
        Pair time = new Pair(hours, minutes);
        this.time = time;
        clockStruck(time);
    }
    @Override
    public void getPositionPrint(){

        System.out.println(getName() + " находяться на локации " + getLocation().getName());
    }
    public void passedTime(int hours, int minutes){
        int Hours = this.time.geta();
        while(hours != 0){
            Hours++;
            if(Hours == 13) Hours = 1;
            clockStruck(new Pair(Hours, 0));
            hours--;
        }
        minutes += this.time.getb();
        if(minutes >= 60){
            Hours++;
            minutes %= 60;
            if(Hours == 13) Hours = 1;
            clockStruck(new Pair(Hours, 0));
        }
        Pair time = new Pair(Hours, minutes);
        System.out.println("Часы показывают " + Hours + " часа и " + minutes + " минут");
        this.time = time;
    }

    private void clockStruck(Pair time){
        if(time.getb() == 0){
            String s;
            int hours = time.geta();
            s = switch (hours) {
                case 1 -> "час";
                case 2 -> "два";
                case 3 -> "три";
                case 4 -> "четыре";
                case 5 -> "пять";
                case 6 -> "шесть";
                case 7 -> "семь";
                case 8 -> "восемь";
                case 9 -> "девять";
                case 10 -> "десять";
                case 11 -> "одиннадцать";
                default -> "двенадцать";
            };
            System.out.println("Часы пробили " + s);
        }
    }
}
