package ga.raindrop.projectperitah.saving;

import ga.raindrop.projectperitah.Game;
import ga.raindrop.projectperitah.achievements;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import ga.raindrop.projectperitah.information.*;
import ga.raindrop.projectperitah.positions.*;

import java.io.File;

public class loadGame {

    public static void loadFile(){

        try{

            File file = new File("./savegame.json");
            String content = FileUtils.readFileToString(file, "utf-8");

            // Convert JSON string to JSONObject
            JSONObject loadJSON = new JSONObject(content);

            // Loading Player Info
            JSONObject playerInfo = loadJSON.getJSONObject("Player Info");
            Player.playerName = playerInfo.getString("Player Name");
            Player.playerHP = playerInfo.getInt("Player HP");
            Player.playerPronoun = playerInfo.getString("Player Gender");
            Player.playerEXP = playerInfo.getInt("Player EXP");
            Player.playerLevel = playerInfo.getInt("Player Level");
            Game.loadPlace = playerInfo.getString("Load Place");
            Game.endingPoints = playerInfo.getInt("Ending Points");
            battleSystem.escapeSuccesses = playerInfo.getInt("Escaped Successfully");

            // Loading Achievements
            JSONObject achievementsFile = loadJSON.getJSONObject("Achievements");
            achievements.achievementTracker = achievementsFile.getInt("Achievement Tracker");
            achievements.bootFirstTime = achievementsFile.getBoolean("Boot First Time");
            achievements.areCreator = achievementsFile.getBoolean("Are Creator");
            achievements.beginJourneyNotebook = achievementsFile.getBoolean("Begin Journey Notebook");
            achievements.beginJourney = achievementsFile.getBoolean("Begin Journey");

            // Loads Player Inventory
            JSONObject playerInventory = loadJSON.getJSONObject("Player Inventory");
            Player.weapon = playerInventory.getString("Item");
            Player.halfHeals = playerInventory.getInt("Half Heals");
            Player.fullHeals = playerInventory.getInt("Full Heals");
            Player.money = playerInventory.getInt("Money");
            Player.fists = playerInventory.getBoolean("Fists");
            Player.club = playerInventory.getBoolean("Club");
            Player.sword = playerInventory.getBoolean("Sword");
            Player.spear = playerInventory.getBoolean("Spear");
            Player.lance = playerInventory.getBoolean("Lance");
            Player.cannon = playerInventory.getBoolean("Cannon");

            // Loads Other Info
            JSONObject otherInfo = loadJSON.getJSONObject("Other Info");
            Game.saveGameVersion = otherInfo.getString("Save Game Version");
            if (Game.saveGameVersion != Game.gameVersion){
                System.out.println("This save data is from an old version of the game.");
                System.out.println("This save file seems to be from Game Version " + Game.saveGameVersion + ". This Game Version is " + Game.gameVersion + ".");
                System.out.println("There may be some issues in your gameplay! Proceed with caution.");
                System.out.println("If you would like to continue without any issues, contact an Admin, or you could DIY it.");
            }else{
                System.out.println("This save data is compatible with Game Version " + Game.gameVersion + "!");
            }
            Game.choice = otherInfo.getString("Choice");
            //Calls the isValid method to check the save file
            isValid();

        }catch(Exception exc){
            exc.printStackTrace();
            System.out.println("It seems that your save data is corrupted, or they are from an unsupported version.");
            System.out.println("Contact an Admin at RainStudios to assist you, or you could DIY it.");
        }

        System.out.println("\nRestored Save Data:\n");
        System.out.println("\tPlayer Name = " + Player.playerName);
        System.out.println("\tPlayer HP = " + Player.playerHP);
        System.out.println("\tLoad Place = " + Game.loadPlace);
        System.out.println("\tItem = " + Player.weapon);
        System.out.println("\tChoice = " + Game.choice);
        System.out.println("\tEnding Points = " + Game.endingPoints);
        System.out.println("");
        System.out.println("\tAchievement Tracker = " + achievements.achievementTracker);
        System.out.println("\tBoot First Time = " + achievements.bootFirstTime);
        System.out.println("\tAre Creator = " + achievements.areCreator);
        System.out.println("\tBegin Journey Notebook = " + achievements.beginJourneyNotebook);
        System.out.println("\tBegin Journey = " + achievements.beginJourney);
        System.out.println("");

        if(Game.loadPlace.equals("Chapter 1 - Trials Ahead Shall Never End.")){
            startStory.StartStory();
        }
        if(Game.loadPlace.equals("1A")){
            readJournal1.journalPage1();
        }
        else{
            startStory.StartStory();
        }

    }
    //Checks if the save file is valid
    public static void isValid(){
        System.out.println("Checking if your save file is valid now!");
    }
}
