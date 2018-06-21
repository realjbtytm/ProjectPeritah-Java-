package ga.raindrop.projectperitah.weapons;

import ga.raindrop.projectperitah.information.Player;

public class weapons {

    public static int minimumDamage;
    public static int maximumDamage;

    public static void weaponSelection() {
        if (Player.fists = true) {
            if (Player.weapon.equalsIgnoreCase("fists")) {
                fists();
                return;
            }
        }
        if(Player.fists = false){
            System.out.println("Hey! You cannot equip what you don't own!");
            return;
        }
        if (Player.club = true) {
            if (Player.weapon.equalsIgnoreCase("club")) {
                club();
                return;
            }
        }

        if (Player.spear = true) {
            if (Player.weapon.equalsIgnoreCase("spear")) {
                spear();
                return;
            }
        }

        if (Player.lance = true) {
            if (Player.weapon.equalsIgnoreCase("lance")) {
                lance();
                return;
            }
        }

        if(Player.sword = true) {
            if (Player.weapon.equalsIgnoreCase("sword")) {
                sword();
                return;
            }
        }
        if(Player.cannon = true) {
            if (Player.weapon.equalsIgnoreCase("cannon")) {
                cannon();
                return;
            }
        }
    }

    public static void fists() {
        minimumDamage = 0;
        maximumDamage = 15;
    }

    public static void club() {
        minimumDamage = 0;
        maximumDamage = 25;
    }

    public static void spear() {
        minimumDamage = 0;
        maximumDamage = 30;
    }

    public static void lance() {
        minimumDamage = 0;
        maximumDamage = 20;
    }

    public static void sword() {
        minimumDamage = 0;
        maximumDamage = 35;
    }

    public static void cannon() {
        minimumDamage = 0;
        maximumDamage = 45;
    }
}
