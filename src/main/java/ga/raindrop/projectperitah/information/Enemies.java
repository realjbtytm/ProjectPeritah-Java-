package ga.raindrop.projectperitah.information;

import java.util.ArrayList;
import java.util.Random;

public class Enemies {

    //Declaring Enemy stats
    public static int enemyHP;
    public static String enemyWeapon;
    public static int enemyHalfHeals;
    public static int enemyFullHeals;
    public static String enemyName;
    public static int enemyMinimumDamage;
    public static int enemyMaximumDamage;


    public static void enemies(){
        //Creates an array (List) of enemies to randomly battle with.
        ArrayList<String> enemyArray = new ArrayList<String>();

        // Adding appropriate default enemies to the enemyArray
        enemyArray.add(0, "Corrupted Civilian");
        enemyArray.add(1, "Corrupted Knight");
        enemyArray.add(2, "Mysterious Mage");
        enemyArray.add(3, "Feral Ghosts");
        enemyArray.add(4, "Corrupted Horseman");
        enemyArray.add(5, "Corrupted Archer");
        

        // Randomly select an enemy.
        Random selectedEnemyInt = new Random();
        int index = selectedEnemyInt.nextInt(enemyArray.size());
        String selectedEnemy = enemyArray.get(index);
        System.out.println(selectedEnemy);
        
        // Passes the enemy selection
        if(selectedEnemy.equalsIgnoreCase("corrupted civilian")){
            corruptedCivilian();
        }
        if(selectedEnemy.equalsIgnoreCase("corrupted knight")){
            corruptedKnight();
        }
        if(selectedEnemy.equalsIgnoreCase("mysterious mage")){
            mysteriousMage();
        }
        if(selectedEnemy.equalsIgnoreCase("feral ghosts")){
            feralGhosts();
        }
        if(selectedEnemy.equalsIgnoreCase("corrupted horseman")){
            corruptedHorseman();
        }
        if(selectedEnemy.equalsIgnoreCase("corrupted archer")){
            corruptedArcher();
        }
    }
    public static void corruptedCivilian(){
        enemyName = "Corrupted Civilian";
        enemyWeapon = "Fists";
        enemyMinimumDamage = 0;
        enemyMaximumDamage = 30;
        enemyHP = 100;
        enemyHalfHeals = 4;
        enemyFullHeals = 2;
        battleSystem.battle();

    }
    
    public static void corruptedKnight(){
        enemyName = "Corrupted Knight";
        enemyWeapon = "Sword";
        enemyMinimumDamage = 0;
        enemyMaximumDamage = 45;
        enemyHP = 100;
        enemyHalfHeals = 5;
        enemyFullHeals = 4;
        battleSystem.battle();
    }
    
    public static void mysteriousMage(){
        enemyName = "Mysterious Mage";
        enemyWeapon = "Mysterious Wand...";
        enemyMinimumDamage = 0;
        enemyMaximumDamage = 50;
        enemyHP = 100;
        enemyHalfHeals = 6;
        enemyFullHeals = 2;
        battleSystem.battle();
    }
    public static void feralGhosts(){
        enemyName = "Feral Ghosts";
        enemyWeapon = "Ghost Fists";
        enemyMinimumDamage = 0;
        enemyMaximumDamage = 20;
        enemyHP = 100;
        enemyHalfHeals = 4;
        enemyFullHeals = 2;
        battleSystem.battle();
    }

    public static void corruptedHorseman(){
        enemyName = "Corrupted Horseman";
        enemyWeapon = "Lance";
        enemyMinimumDamage = 5;
        enemyMaximumDamage = 40;
        enemyHP = 100;
        enemyHalfHeals = 4;
        enemyFullHeals = 2;
        battleSystem.battle();
    }
    public static void corruptedArcher(){
        enemyName = "Corrupted Archer";
        enemyWeapon = "Bow";
        enemyMinimumDamage = 0;
        enemyMaximumDamage = 45;
        enemyHP = 100;
        enemyHalfHeals = 2;
        enemyFullHeals = 3;
        battleSystem.battle();
    }
}
