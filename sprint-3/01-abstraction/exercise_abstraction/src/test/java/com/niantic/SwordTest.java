package com.niantic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordTest {

    @Test
    public void getRange_shouldReturn_1()
    {
        Sword sword = new Sword("Name", 10);
        int actualRange = sword.getRange();
        int expectedRange = 1;

        assertEquals(expectedRange, actualRange, "Because range should be 1.");
    }

    @Test
    public void attack_shouldAdd_10_to_percentCharged()
    {
        Sword sword = new Sword("Name", 10);
        int actualCharge = sword.attack();
        int expectedCharge = 10;

        assertEquals(expectedCharge, actualCharge, "Because the percent charged should increase by 10.");
    }

    @Test
    public void percentCharged_cannotExceed_100()
    {
        Sword sword = new Sword("Name", 10);
        int expectedCharge = 100;
        for(int i = 0; i < 11; i++) {
            sword.attack();
        }

        int actualCharge = sword.getPercentCharged();

        assertEquals(expectedCharge, actualCharge, "Because the percent charged cannot exceed 100.");
    }

    @Test
    public void chargeLessThan50_shouldPerformRegularAttack()
    {
        Sword sword = new Sword("Name", 10);
        int expectedDamage = 10;
        sword.powerAttack();
        int actualDamage = sword.getDamage();

        assertEquals(expectedDamage, actualDamage, "Because it should be a regular attack with damage of 10.");
    }

    @Test
    public void chargeBetween50And90_shouldDeliverDoubleBlow_andChargeShouldBeReducedBy50()
    {
        Sword sword = new Sword("Name", 10);
        for(int i = 0; i < 7; i++) {
            sword.attack();
        }
        int expectedDamage = 20;
        int actualDamage = sword.powerAttack();

        int expectedCharge = 20;
        int actualCharge = sword.getPercentCharged();

        assertEquals(expectedDamage, actualDamage, "Because it should be double the damage.");
        assertEquals(expectedCharge, actualCharge, "Becuase the charge should have reduced by 50%");
    }

    @Test
    public void charge100_shouldDeliver4TimesBlow_andChargeShouldBe0()
    {
        Sword sword = new Sword("Name", 10);
        for(int i = 0; i < 10; i++) {
            sword.attack();
        }
        int expectedDamage = 40;
        int actualDamage = sword.powerAttack();

        int expectedCharge = 0;
        int actualCharge = sword.getPercentCharged();

        assertEquals(expectedDamage, actualDamage, "Because it should be double the damage.");
        assertEquals(expectedCharge, actualCharge, "Because the charge should have been reduced to 0.");
    }
}
