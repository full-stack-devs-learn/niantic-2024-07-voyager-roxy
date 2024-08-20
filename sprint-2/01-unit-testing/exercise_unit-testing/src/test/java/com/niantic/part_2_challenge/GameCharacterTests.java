package com.niantic.part_2_challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameCharacterTests
{
    @Test
    public void takeHit_shouldReduceEnergyLevelByAmountOfDamageSpecified()
    {
        int maxEnergyLevel = 100;
        String name = "Iron Man";
        int damage = 20;

        GameCharacter gameCharacter = new GameCharacter(maxEnergyLevel, name);

        gameCharacter.takeHit(damage);

        int expectedEnergy = 80;

        int energyDamage = gameCharacter.getEnergyLevel();

        assertEquals(expectedEnergy, energyDamage, "Because it should have returned 100 - 20 = 80.");

    }

    @Test
    public void energyLevel_shouldNeverFallBelowZero()
    {
        int maxEnergyLevel = 100;
        String name = "Iron Man";
        int damage = 100;

        GameCharacter gameCharacter = new GameCharacter(maxEnergyLevel, name);

        gameCharacter.takeHit(damage);

        int expectedEnergyLevel = 0;
        int actualEnergyLevel = gameCharacter.getEnergyLevel();

        assertEquals(expectedEnergyLevel, actualEnergyLevel, "Energy level cannot be below 0.");
    }

    @Test
    public void heal_shouldIncreaseEnergyLevelBySpecifiedEnergy()
    {
        int maxEnergyLevel = 100;
        String name = "Iron Man";
        int heal = 20;
        int expectedEnergy = 70;

        GameCharacter gameCharacter = new GameCharacter(maxEnergyLevel, name);

        gameCharacter.takeHit(50);

        gameCharacter.heal(heal);

        int actualEnergy = gameCharacter.getEnergyLevel();

        assertEquals(expectedEnergy, actualEnergy, "Because it should have returned 50 + 20 = 70.");
    }

    @Test
    public void energyLevel_shouldNeverIncreaseAboveMaxLevel()
    {
        int maxEnergyLevel = 100;
        String name = "Iron Man";

        GameCharacter gameCharacter = new GameCharacter(maxEnergyLevel, name);

        gameCharacter.takeHit(20);
        gameCharacter.heal(20);

        int energyLevel = gameCharacter.getEnergyLevel();

        assertEquals(maxEnergyLevel, energyLevel, "Because the energy level shouldn't be greater than the max energy level." );
    }

    @Test
    public void energyLevel_reachesZeroCharacterCannotHeal()
    {
        int maxEnergyLevel = 100;
        String name = "Iron Man";
        int damage = 100;
        int heal = 0;

        GameCharacter gameCharacter = new GameCharacter(maxEnergyLevel, name);

        gameCharacter.takeHit(damage);
        gameCharacter.isKnockedOut();
        gameCharacter.heal(heal);

        int actualEnergy = gameCharacter.getEnergyLevel();

        int expectedEnergy = 0;

        assertEquals(expectedEnergy, actualEnergy, "Because the energy has reached zero, the character cannot heal.");
    }

    @Test
    public void isKnockedOut_shouldReturnTrueIfEnergyLevelIsZero()
    {
        int maxEnergyLevel = 100;
        String name = "Iron Man";
        int damage = 100;

        GameCharacter gameCharacter = new GameCharacter(maxEnergyLevel, name);

        gameCharacter.takeHit(damage);

        boolean isKnockedOut = gameCharacter.isKnockedOut();

        assertTrue(isKnockedOut, "Because when the energy has reached zero, the character should be knocked out.");
    }
}