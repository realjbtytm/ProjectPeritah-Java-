package ga.raindrop.projectperitah;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.FileWriter;
import java.io.IOException;

import ga.raindrop.projectperitah.information.Player;

public class saveGame {


    public static void saveJSON() throws JSONException {
        // Master save file JSONObject
        JSONObject saveGameFile = new JSONObject();

        //Saving Player Info
        JSONObject playerInfo = new JSONObject();
        playerInfo.put("Player Name", Player.playerName);
        playerInfo.put("Player HP", Player.playerHP);
        playerInfo.put("Player Gender", Player.playerPronoun);
        playerInfo.put("Player EXP", Player.playerEXP);
        playerInfo.put("Player Level", Player.playerLevel);
        playerInfo.put("Load Place", Game.loadPlace);
        playerInfo.put("Ending Points", Game.endingPoints);
        Player.playerName = "";
        Player.playerHP = 100;
        Player.playerEXP = 0;
        Player.playerLevel = 1;
        saveGameFile.put("Player Info", playerInfo);

        // Saving Player Inventory
        JSONObject playerInventory = new JSONObject();
        playerInventory.put("Item", Player.weapon);
        playerInventory.put("Half Heals", Player.halfHeals);
        playerInventory.put("Full Heals", Player.fullHeals);
        playerInventory.put("Money", Player.money);
        playerInventory.put("Fists", Player.fists);
        playerInventory.put("Club", Player.club);
        playerInventory.put("Sword", Player.sword);
        playerInventory.put("Cannon", Player.cannon);
        saveGameFile.put("Player Inventory", playerInventory);
        Player.weapon = "Fists";
        Player.halfHeals = 10;
        Player.fullHeals = 5;
        Player.money = 100;
        Player.fists = true; // Fists weapon; default value is true
        Player.club = false; // Club weapon; default value is false
        Player.sword = false; // Sword weapon; default value is false
        Player.cannon = false;


        // Saving Other Information
        JSONObject otherInfo = new JSONObject();
        otherInfo.put("Save Game Version", Game.saveGameVersion);
        otherInfo.put("Choice", Game.choice);
        saveGameFile.put("Other Info", otherInfo);
        Game.choice = "";
        Game.saveGameVersion = "1.1";


        // Saving Achievements
        JSONObject achievementsFile = new JSONObject();
        achievementsFile.put("Achievement Tracker", achievements.achievementTracker);
        achievementsFile.put("Boot First Time", achievements.bootFirstTime);
        achievementsFile.put("Are Creator", achievements.areCreator);
        achievementsFile.put("Begin Journey Notebook", achievements.beginJourneyNotebook);
        achievementsFile.put("Begin Journey", achievements.beginJourney);
        saveGameFile.put("Achievements", achievementsFile);
        achievements.achievementTracker = 0;
        achievements.beginJourneyNotebook = false;
        achievements.beginJourney = false;
        achievements.bootFirstTime = false;
        achievements.areCreator = false;

        try{
            FileWriter file = new FileWriter("./" + Player.playerName + ".json");
            int spacesToIndentEachLevel = 4;
            file.write(saveGameFile.toString(spacesToIndentEachLevel));
            file.flush();
            file.close();

        }catch(IOException e){
            e.printStackTrace();
        }



        System.out.println("Saved the Game!");


        }

    }
