package ga.raindrop.projectperitah.information;

import ga.raindrop.projectperitah.Game;
import ga.raindrop.projectperitah.configs.customText;
import ga.raindrop.projectperitah.weapons.weapons;

import java.util.Random;
import java.util.Scanner;

public class battleSystem {
    public static int battleTurn;
    public static int damageDealt;

    public static String battleMenu;

    public static String deadMenu;

    public static Scanner myScanner;

    public static String switchOption;

    public static int HPDifference;

    public static Random random = new Random();

    public static String healOption;

    public static int escapeSuccesses;

    public static String hpBar;

    public static String enemyHpBar;

    public static void battle(){

        weapons.weaponSelection();

        battleTurn = ++battleTurn;

        if(Player.playerHP == 100){
            hpBar = "[::::::::::]";
        }
        if(Player.playerHP == 99){
            hpBar = "[:::::::::]";
        }
        if(Player.playerHP == 89){
            hpBar = "[::::::::]";
        }
        if(Player.playerHP == 79){
            hpBar = "[:::::::]";
        }
        if(Player.playerHP == 69){
            hpBar = "[::::::]";
        }
        if(Player.playerHP == 59){
            hpBar = "[:::::]";
        }
        if(Player.playerHP == 49) {
            hpBar = "[::::]";
        }
        if(Player.playerHP == 39){
            hpBar = "[:::]";
        }
        if(Player.playerHP == 29){
            hpBar = "[::]";
        }
        if(Player.playerHP == 19){
            hpBar = "[:]";
        }
        if(Player.playerHP == 9){
            hpBar = "[:]";
        }
        if(Player.playerHP == 0){
            hpBar = "[]";
        }

        if(Enemies.enemyHP == 100){
            enemyHpBar = "[::::::::::]";
        }
        if(Enemies.enemyHP == 99){
            enemyHpBar = "[:::::::::]";
        }
        if(Enemies.enemyHP == 89){
            enemyHpBar = "[::::::::]";
        }
        if(Enemies.enemyHP == 79){
            enemyHpBar = "[:::::::]";
        }
        if(Enemies.enemyHP == 69){
            enemyHpBar = "[::::::]";
        }
        if(Enemies.enemyHP == 59){
            enemyHpBar = "[:::::]";
        }
        if(Enemies.enemyHP == 49) {
            enemyHpBar = "[::::]";
        }
        if(Enemies.enemyHP == 39){
            enemyHpBar = "[:::]";
        }
        if(Enemies.enemyHP == 29){
            enemyHpBar = "[::]";
        }
        if(Enemies.enemyHP == 19){
            enemyHpBar = "[:]";
        }
        if(Enemies.enemyHP == 9){
            enemyHpBar = "[:]";
        }
        if(Enemies.enemyHP == 0){
            enemyHpBar = "[]";
        }

        customText.clearScreen();

        System.out.print("\n");
        System.out.println("You are battling against " + Enemies.enemyName + "!");
        System.out.println("Battle Turn " + battleTurn + "!");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(Enemies.enemyName + " has an HP of " + Enemies.enemyHP + " " + enemyHpBar + ".");
        System.out.println(Enemies.enemyName + " \'s weapon is " + Enemies.enemyWeapon);
        System.out.println(Enemies.enemyName + " has " + Player.halfHeals + " Half Heals and " + Player.fullHeals + " Full Heals.");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("You have an HP of " + Player.playerHP + " " + hpBar + "!");
        System.out.println("Your weapon is " + Player.weapon);
        System.out.println("You have " + Player.halfHeals + " Half Heals and " + Player.fullHeals + " Full Heals.");
        System.out.println("\n");
        System.out.println("What would you like to do?");
        System.out.println("Available options are 'fight', 'heal', 'flee'.");

        myScanner = new Scanner(System.in);
        battleMenu = myScanner.nextLine();

        if(battleMenu.equalsIgnoreCase("fight") || battleMenu.equalsIgnoreCase("attack")){
            damageDealt = random.nextInt((weapons.maximumDamage - weapons.minimumDamage + 1) + weapons.minimumDamage);

            Enemies.enemyHP = Enemies.enemyHP - damageDealt;

            if(damageDealt <= 0){
                System.out.println("\nYou embarrassingly miss your attack, causing to the enemy no damage.");
            }
            if(damageDealt > 0){
                System.out.println("\nYou hit the enemy! You have dealt " + damageDealt + " HP of damage!");
                System.out.println(Enemies.enemyName + " now has " + Enemies.enemyHP + "!");
            }
            enemyHPCheck();



        }
        if(battleMenu.equalsIgnoreCase("heal")) {
            if (Player.playerHP >= 100) {
                System.out.println("\nReally... just really, " + Player.playerHP + "? You literally have full HP!");
                System.out.println("What a waste of a turn that could have been a turning point in the battle.");
                enemiesTurn();
            }
            if (Player.playerHP < 100) {
                System.out.println("\nWhich type of Heals would you like to use?");
                System.out.println("You have " + Player.halfHeals + " Half Heals and " + Player.fullHeals + " Full Heals.");

                myScanner = new Scanner(System.in);
                healOption = myScanner.nextLine();

                if (healOption.equalsIgnoreCase("half heal") || healOption.equalsIgnoreCase("half")) {
                    HPDifference = (100 - Player.playerHP) / 2;
                    Player.playerHP = Player.playerHP + HPDifference;

                    Player.halfHeals = --Player.halfHeals;

                    System.out.println("\nYou have recovered your HP by " + HPDifference + "!");
                    System.out.println("Your HP is now at " + Player.playerHP);
                    System.out.println("You have " + Player.halfHeals + " Half Heals and " + Player.fullHeals + " Full Heals left.");
                }
                if (healOption.equalsIgnoreCase("full heal") || healOption.equalsIgnoreCase("full")) {
                    HPDifference = (100 - Player.playerHP);
                    Player.playerHP = Player.playerHP + HPDifference;

                    Player.fullHeals = --Player.fullHeals;

                    System.out.println("\nYou have recovered your HP by " + HPDifference + "!");
                    System.out.println("Your HP is now at " + Player.playerHP);
                    System.out.println("You have " + Player.halfHeals + " Half Heals and " + Player.fullHeals + " Full Heals left.");
                }

            }
            enemiesTurn();
        }

        if(battleMenu.equalsIgnoreCase("run") || battleMenu.equalsIgnoreCase("flee")) {
            escapeSuccesses = ++escapeSuccesses;



            System.out.println("You have successfully escaped! " + escapeSuccesses);

            if(escapeSuccesses >= 15){ // The limit on the amount of times that the player can flee is TBD
                customText.typeWriter("You coward. You have brought disgrace upon your family. You shall be executed on charge of cowardice.");
                System.out.println("\n A few days later...");
                System.out.println("On a gravestone... \n - " + Player.playerName + " - \n - A Coward and Disgrace upon the Kingdom of Peritah - \n - Died 925 AD -");
                // Insert achievement for Cowardice Ending here
                // Insert Ending counter for Cowardice Ending here
                // Insert boolean to true for Cowardice ending here

            }

            Game.mainMenu(); // Placeholder
        }
        if(battleMenu.equalsIgnoreCase("switch weapon") || battleMenu.equalsIgnoreCase("switch")){
            System.out.println("To which weapon do you want to switch to?");

            myScanner = new Scanner(System.in);
            switchOption = myScanner.nextLine();

            if(switchOption.equalsIgnoreCase("fists")){
                Player.weapon = "Fists";
                weapons.weaponSelection();
            }
            if(switchOption.equalsIgnoreCase("club")){
                Player.weapon = "Club";
                weapons.weaponSelection();
            }
            if(switchOption.equalsIgnoreCase("sword")){
                Player.weapon = "Sword";
                weapons.weaponSelection();
            }

            if(switchOption.equalsIgnoreCase("spear")){
                Player.weapon = "Spear";
                weapons.weaponSelection();
            }

            if(switchOption.equalsIgnoreCase("lance")){
                Player.weapon = "Lance";
                weapons.weaponSelection();
            }

            if(switchOption.equalsIgnoreCase("cannon")){
                Player.weapon = "Cannon";
                weapons.weaponSelection();
            }

            System.out.println("Changed weapon to " + Player.weapon + "!");
            enemiesTurn();
        }
    }

    public static void enemiesTurn(){
        damageDealt = random.nextInt((Enemies.enemyMaximumDamage - Enemies.enemyMinimumDamage + 1) + Enemies.enemyMinimumDamage);

        Player.playerHP = Player.playerHP - damageDealt;

        if(damageDealt <= 0){
            System.out.println("\nYou bravely dodge the hit! You did not suffer a HP loss!");
            battle();
        }
        if(damageDealt > 0){
            System.out.println("\nYou have been hit! The enemy dealt " + damageDealt + " of HP!");
            System.out.println("You only have " + Player.playerHP + " HP left!");
        }
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        playerHPCheck();

    }

    public static void playerHPCheck(){
        if(Player.playerHP <= 0){
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("You have died at the hands of " + Enemies.enemyName + "! \nWould you like to restart from your save, or you would you like to quit?");
            System.out.println("Options are 'Load' 'Quit' and 'Main Menu'");

            myScanner = new Scanner(System.in);
            deadMenu = myScanner.nextLine();

            if(deadMenu.equalsIgnoreCase("load") || deadMenu.equalsIgnoreCase("restart")){
                System.out.println("Not implemented yet!");
                Game.mainMenu();
                //loadGame.loadFile();
            }
            if(deadMenu.equalsIgnoreCase("quit") || deadMenu.equalsIgnoreCase("rage quit")) {
                System.exit(0);
            }
            if(deadMenu.equalsIgnoreCase("main menu")){
                Game.mainMenu();
            }
        }
        if(Player.playerHP > 0){
            battle();
        }
    }

    public static void enemyHPCheck(){

        if (Enemies.enemyHP <= 0){
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nYou have killed " + Enemies.enemyName + "!");
            Game.mainMenu();
        }
        if(Enemies.enemyHP > 0){
            enemiesTurn();
        }
    }
}
