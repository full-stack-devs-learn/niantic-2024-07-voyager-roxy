package com.niantic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    @Test
    public void levelUp_shouldIncreaseArmorByFivePointsAndPerformLevelUpFunctions()
    {
        var knight = new Knight("Knight", 50, 1, 1, 10);

        knight.levelUp();

        int expectedArmor = 15;
        int expectedLevel = 2;
        int expectedHealth = 60;

        int actualArmor = knight.getArmor();
        int actualLevel = knight.getLevel();
        int actualHealth = knight.getHealth();


        assertEquals(expectedArmor, actualArmor, "Because it should have increased the armor by 5");
        assertEquals(expectedLevel, actualLevel, "Because the knight leveled up.");
        assertEquals(expectedHealth, actualHealth, "Because the knight leveled up, the health should increase by 10.");
    }

    @Test
    public void attackLessThanArmor_shouldResultInNoDamage()
    {
        var knight = new Knight("Knight", 50, 1, 1, 30);
        int damage = 10;

        knight.takeDamage(damage);

        int expectedHealth = 50;
        int actualHealth = knight.getHealth();

        assertEquals(expectedHealth, actualHealth, "Because armor is more powerful than attack, no damage is sustained.");
    }

    @Test
    public void additionalDamage_shouldBeRemovedFromHealthOfKnight()
    {
        var knight = new Knight("Knight", 50, 1, 1, 30);
        int damage = 40;

        knight.takeDamage(damage);

        int expectedHealth = 40;
        int actualHealth = knight.getHealth();

        assertEquals(expectedHealth, actualHealth, "Because additional damage should be removed from health of the knight.");
    }

    @Test
    public void armor_shouldDeflectAmountOfDamage()
    {
        var knight = new Knight("Knight", 50, 1, 1, 30);
        int damage = 30;

        knight.takeDamage(damage);

        int expectedHealth = 50;
        int actualHealth = knight.getHealth();

        assertEquals(expectedHealth, actualHealth, "Because armor should be deflect damage.");
    }

    @Test
    public void armorLevel_shouldNotDecreaseAndCanBeReused()
    {
        var knight = new Knight("Knight", 50, 1, 1, 30);
        int damage1 = 30;
        int damage2 = 20;

        knight.takeDamage(damage1);

        int expectedArmor = 30;
        int actualArmor = knight.getArmor();

        knight.takeDamage(damage2);

        int expectedArmor2 = 30;
        int actualArmor2 = knight.getArmor();

        assertEquals(expectedArmor, actualArmor, "Because armor should not decrease.");
        assertEquals(expectedArmor2, actualArmor2, "Because armor can be reused.");
    }
}
