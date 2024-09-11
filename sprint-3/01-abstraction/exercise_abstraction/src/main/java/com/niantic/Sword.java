package com.niantic;

public class Sword extends Weapon
{
    public Sword(String name, int damage)
    {
        super(name, damage);
    }

    @Override
    public int attack() {
        int charge = getPercentCharged();
        if(charge + 10 <= 100) {
            setPercentCharged(charge + 10);
        }
        else {
            setPercentCharged(100);
        }
        return getDamage();
    }

    @Override
    public int powerAttack() {
        int charge = getPercentCharged();
        if(charge > 0){
            if(charge < 50)
            {
                return getDamage();
            }
            if(charge > 50 && charge < 90)
            {
                setPercentCharged(charge - 50);
                return getDamage() * 2;
            }
            if(charge == 100)
            {
                setPercentCharged(0);
                return getDamage() * 4;
            }
        }
        return getDamage();
    }

    @Override
    public int getRange() {
        return 1;
    }
}
