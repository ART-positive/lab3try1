import Characters.Moomintroll;
import Characters.Person;
import Characters.Travelers;
import Items.Clock;
import Items.Sofa;
import Locations.Location;

public class Scene {
    public static void main(String[] args) {
        Location porch = new Location("Крыльцо", 13, 24);

        Location kitchen = new Location("Кухня", 9, 67);
        Location bedroom = new Location("Спальня", 5, 5);
        Location livingRoom = new Location("Гостиная", 3, 3);
        Location bathroom = new Location("Ванная", 9, 67);
        Location veranda = new Location("Веранда", 1, 1);
        Location cabinet = new Location("Кабинет", 9, 4);
        Location outdoor = new Location("Улица", 4, 7);

        Person per1 = new Person("Ondatr", 19, "man", bedroom);
        Person per2 = new Person("Georg", 23, "non-binary", bathroom);
        Person per3 = new Person("Napolt", 26, "man", kitchen);

        Moomintroll dad = new Moomintroll("Муми-папа", 43, cabinet);
        Moomintroll mom = new Moomintroll("Муми-мама", 35, kitchen);

        //Traveler tofla = new Traveler("Тофсла", 15, outdoor);
        //Traveler visla = new Traveler("Вифсла", 17, outdoor);
        //Traveler[] travelers = new Traveler[]{"Тофсла", 15, outdoor, "Вифсла", 17, outdoor};

        Sofa sf1 = new Sofa("blue", 13500, "Раскладной диван", livingRoom);
        Clock clock1 = new Clock(1299, "Настенный часы", bedroom, 11, 40);

        //tofla.walk(porch);
        //visla.walk(porch);
        //travelers.


        clock1.passedTime(2, 38);
        dad.walk(livingRoom, sf1);
        dad.setAlarm(sf1);
        dad.walk(cabinet, sf1);
        per1.walk(veranda, sf1);
        dad.takeWeaponRunIncident(livingRoom);
        mom.takeWeaponRunIncident(livingRoom);
        per1.takeWeaponRunIncident(livingRoom);
        per2.takeWeaponRunIncident(livingRoom);
        per3.takeWeaponRunIncident(livingRoom);

        System.out.println(per3.toString());
        System.out.println(mom.toString());
        System.out.println(clock1.toString());
        System.out.println(sf1.toString());

        Sofa sf2 = new Sofa("blue", 13500, "Раскладной диван", livingRoom);
        System.out.println(sf1.hashCode());
        System.out.println(sf2.hashCode());
        Clock clock2 = new Clock(1299, "Настенный часы", bedroom, 11, 40);
        System.out.println(clock1.equals(clock2));
        clock2.setTime(2, 18);
        System.out.println(clock1.equals(clock2));
    }
}
