package Enums;

import java.util.Random;
public enum Weapon {
    AXES,
    SCISSORS,
    STONES,
    SHOVELS,
    KNIVES,
    RAKES;

    private static final Weapon[] values = values();
    private static final int size = values.length;
    private static final Random random = new Random();

    public static Weapon getRandomWeapon()  {
        return values[random.nextInt(size)];
    }
}
