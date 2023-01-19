import characters.Moomintroll;
import characters.Person;
import characters.Traveler;
import exceptions.DifferentLocationsFailException;
import exceptions.SameGroupMembersFailException;
import interfaces.Fallen;
import items.Clock;
import items.Gun;
import items.Sofa;
import locations.Location;

public class Scene {
    public static void main(String[] args) throws DifferentLocationsFailException, SameGroupMembersFailException {
        // обьекты
        Location porch = new Location("Крыльцо", 13, 24);
        Location outdoor = new Location("Улица", 4, 7);
        Location bedroom = new Location("Спальня", 5, 5);
        Location livingRoom = new Location("Гостиная", 2, 5);
        Location bathroom = new Location("Ванная", 9, 67);
        Location veranda = new Location("Веранда", 1, 1);
        Location cabinet = new Location("Кабинет", 9, 4);
        Location cellar = new Location("Погреб", 10, 13);
        Location kitchen = new Location("Кухня", 9, 67);
        Location hall = new Location("Парадная", 7, 8);
        Location wardrobe = new Location("Гардероб", 7, 8);
        Location barn = new Location("Сарай", 7, 8);

        Traveler tofla = new Traveler("Тофсла", 15, outdoor);
        Traveler visla = new Traveler("Вифсла", 17, outdoor);
        Traveler.GroupTravelers trs = new Traveler.GroupTravelers(visla, tofla);

        Moomintroll mom = new Moomintroll("Муми-мама", 35, kitchen);
        Moomintroll dad = new Moomintroll("Муми-папа", 43, cabinet);

        Person per1 = new Person("Ondatr", 19, "man", bedroom);
        Person per3 = new Person("Napolt", 26, "man", kitchen);
        Person per2 = new Person("Georg", 23, "non-binary", bathroom);
        Person per4 = new Person("Снифф", 35, "girl", outdoor);

        Sofa sf1 = new Sofa("blue", 13500, "Раскладной диван", livingRoom);
        Clock clock1 = new Clock(1299, "Настенный часы", bedroom, 6, 23);
        Gun rifle = new Gun(17000, "Ружьё", barn);
        // история
        System.out.println("------------------------Начало истории------------------------");
        trs.walk(porch);
        mom.screaming("Кофе готов!");
        trs.runAndHide(cellar);
        trs.getHome(hall);
        Fallen duskFallen = new Fallen() {
            @Override
            public void fallen() {
                clock1.passedTime(2, 11);
                System.out.println("Наступили сумерки");
                trs.runAndHide(wardrobe);
            }
        };
        /*
        Fallen duskFallen = () -> {
            clock1.passedTime(2, 11);
            System.out.println("Наступили сумерки");
            trs.runAndHide(wardrobe);
        };
         */
        duskFallen.fallen();
        dad.walk(livingRoom);
        dad.setAlarm(sf1);
        clock1.passedTime(1, 14);
        dad.walk(barn);
        dad.takeGun(rifle);
        dad.walk(veranda);
        dad.barredDoor(sf1);
        clock1.passedTime(2, 12);
        clock1.passedTime(2, 7);
        per1.walk(veranda, sf1);
        dad.takeWeaponRunIncident(livingRoom);
        mom.takeWeaponRunIncident(livingRoom);
        per2.takeWeaponRunIncident(livingRoom);
        per3.takeWeaponRunIncident(livingRoom);
        per4.takeWeaponRunIncident(livingRoom);
        System.out.println("------------------------Конец истории------------------------");
        // проверка дополнительных функций, которых не было в истории
        System.out.println(per3.toString());
        System.out.println(mom.toString());
        System.out.println(clock1.toString());
        System.out.println(sf1.toString());

        Sofa sf2 = new Sofa("blue", 13500, "Раскладной диван", livingRoom);
        System.out.println(sf1.hashCode());
        System.out.println(sf2.hashCode());
        Clock clock2 = new Clock(1299, "Настенный часы", bedroom, 2, 7);
        System.out.println(clock1.equals(clock2));
        clock2.setTime(2, 18);
        System.out.println(clock1.equals(clock2));

        Sofa.Pillow pl = sf2.new Pillow("material", 60, 90);
        System.out.println(pl.getSofa());
    }
}
