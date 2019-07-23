package data;

import java.util.ArrayList;

public class Item {
    private ArrayList<Weapon> weapons;
    private int numOfGuns = 0;
    private int index;

    Item() {
        weapons = new ArrayList<>(6);
    }

    void addWeapon(String name) {
        if (name.equals("ak47")) {
            weapons.add(new Ak47());
            numOfGuns++;
        } else if (name.equals("desertEagle")) {
            weapons.add(new DesertEagle());
            numOfGuns++;
        } else {
            System.out.println("the name entered cou be wrong");
        }
    }

    Weapon getCurrWeapon() {
        return weapons.get(index);
    }

    public String getCurrWeaponName() {
        return weapons.get(index).getName();
    }

    void gunChange() {
        if (index + 1 != numOfGuns) {
            index++;
        } else {
            index = 0;
        }
    }
}
