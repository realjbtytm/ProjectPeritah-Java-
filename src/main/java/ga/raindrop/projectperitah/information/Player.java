package ga.raindrop.projectperitah.information;

import ga.raindrop.projectperitah.positions.startStory;

import java.util.Scanner;

public class Player {

    // For tracking Player HP at all times. Default value is set here.
    public static int playerHP;

    // To keep the desired username the user desires to play as.
    public static String playerName;

    public static int playerHPRecovery;

    // Registers Player Gender
    public static String playerPronoun;

    // Tracks Player EXP
    public static int playerEXP;

    // Tracks Player Level
    public static int playerLevel;

    // Keep track of the items that the user has equipped. Default value is set here.
    public static String weapon;

    // Registers how much heal items the player has. Default value is set here.
    public static int halfHeals;
    public static int fullHeals;

    // Registers how much money the player has. Default value is set here.
    public static int money;

    // Scanner for user input
    public static Scanner myScanner;


    // Called when the Player makes a new character.
    public static void startGameSetup() {
        playerHP = 100;
        playerEXP = 0;
        playerLevel = 1;
        weapon = "Fists";
        halfHeals = 10;
        fullHeals = 5;
        money = 100;
    }

    public static void playerPronounTryAgain() {
        // Player Gender
        myScanner = new Scanner(System.in);
        System.out.println("What is your character's gender?");
        Player.playerPronoun = myScanner.nextLine();

        // Checks if valid. (Not to offend anyone of any gender outside the two "binary" genders.)
        if (Player.playerPronoun.equalsIgnoreCase("male") || Player.playerPronoun.equalsIgnoreCase("m") || Player.playerPronoun.equalsIgnoreCase("him")) {
            Player.playerPronoun = "M";
            startStory.StartStoryAchievement();
        }
        if (Player.playerPronoun.equalsIgnoreCase("female") || Player.playerPronoun.equalsIgnoreCase("f") || Player.playerPronoun.equalsIgnoreCase("her")) {
            Player.playerPronoun = "F";
            startStory.StartStoryAchievement();
        }
        if (Player.playerPronoun.equalsIgnoreCase("they") || Player.playerPronoun.equalsIgnoreCase("Gender Neutral") || Player.playerPronoun.equalsIgnoreCase("Neutral")){
            Player.playerPronoun = "They";
            startStory.StartStoryAchievement();
        } else {
            System.out.println("Sorry, but I could not interpret that option!");
            playerPronounTryAgain();

        }

    }
    // Player Inventory starts here
    public static boolean fists = true; // Fists weapon; default value is true
    public static boolean club = false; // Club weapon; default value is false
    public static boolean spear = false; //Spear weapon; default value is false
    public static boolean lance = false; //Lance weapon; default value is false
    public static boolean sword = false; // Sword weapon; default value is false
    public static boolean cannon = false; // Cannon weapon; default value is false

}
