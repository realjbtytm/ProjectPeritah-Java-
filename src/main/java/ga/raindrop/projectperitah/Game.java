package ga.raindrop.projectperitah;

import ga.raindrop.projectperitah.configs.customText;
import ga.raindrop.projectperitah.positions.startStory;

import java.util.Scanner;

import ga.raindrop.projectperitah.information.*;

// NOTE: Central Options Menu (In one single file, so that we do not have to repeat it over and over again?)

public class Game {

    public static boolean freeBattle = false;

    // Scanner for user input
    public static Scanner myScanner;


    // Stores the option chosen.
    public static String choice;
    
    // Main Menu Options
    public static String mainMenu;

    // Saves where the player is.
    public static String loadPlace;

    // Tracks Ending Points (Decides the ending for the player)
    public static int endingPoints = 0;

    // Tracks Game Version
    public static String gameVersion = "1.1";

    // Tracks the Save Data Version that was saved in a specific version
    public static String saveGameVersion = "1.1";


    public static void main(String[] args) {
        // Main method for running the game properly
        Game game;
        game = new Game();

        game.mainMenu();

    }

    public static void mainMenu() {

        customText.clearScreen();

        customText.typeWriter("\n-------------------------------");
        customText.typeWriter("\n           Welcome!            ");
        customText.typeWriter("\n      Kingdom of Peritah       ");
        customText.typeWriter("\n       Game Version " + gameVersion);
        customText.typeWriter("\n       By: RainStudios         ");
        customText.typeWriter("\n-------------------------------");
        System.out.println("\nLoad, or Start a new Game?");
        System.out.println("\nHINT: Type 'Load' to load a saved game, or 'Start' to start a new game. 'Battle' if Free Battle");

        myScanner = new Scanner(System.in);
        mainMenu = myScanner.nextLine();

        if (mainMenu.equalsIgnoreCase("load")) {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Not implemented yet!");
            mainMenu();
            //loadGame.loadFile();
        }
        if (mainMenu.equalsIgnoreCase("start")) {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            playerSetup();
        }
        if (mainMenu.equalsIgnoreCase("quit") || mainMenu.equalsIgnoreCase("leave")){
            customText.typeWriter("Come back soon! See you next time! Quitting the game...");
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0); // Placeholder
        }
        if(mainMenu.equalsIgnoreCase("battle")){
            battleSystem.battleTurn = 0;
            freeBattle = true;
            loadGame.whereToGo();
            System.out.println("Complete!"); // Placeholder
        }
        else{
            System.out.println("Could not interpret that command!");
            mainMenu();
        }

    }

    public static void playerSetup() {

        Player.startGameSetup();

        System.out.println("Your health is at " + Player.playerHP + "%!");
        System.out.println("You have " + Player.weapon + " equipped.");
        System.out.println("");

        // Username
        myScanner = new Scanner(System.in);
        System.out.println("What is your name, Protagonist?");
        Player.playerName = myScanner.nextLine();

        // Preferred pronoun
        myScanner = new Scanner(System.in);
        System.out.println("What is your character's gender?");
        Player.playerPronoun = myScanner.nextLine();

        // Checks if valid.
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
        }
        else {
            System.out.println("Sorry, but I could not interpret that option!");
            Player.playerPronounTryAgain();

        }

    }
}
