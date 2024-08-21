package com.niantic;

public class Knight extends Character
{
    private int armor;

    public Knight(String name, int health, int level, int experience, int armor) {
        super(name, health, level, experience);

        this.armor = armor;
    }

    public int getArmor()
    {
        return armor;
    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        armor += 5;
    }

    @Override
    public void takeDamage(int damage)
    {
        if(armor > damage)
        {
            super.takeDamage(0);
        }
        else
        {
            int remainingDamage = damage - armor;
            super.takeDamage(remainingDamage);
        }
    }

    @Override
    public String specialAbility()
    {
        return "Armor Shield";
    }
}
