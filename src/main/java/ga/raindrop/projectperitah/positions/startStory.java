package ga.raindrop.projectperitah.positions;

import ga.raindrop.projectperitah.Game;
import ga.raindrop.projectperitah.configs.customText;
import ga.raindrop.projectperitah.saving.saveGame;
import ga.raindrop.projectperitah.achievements;
import ga.raindrop.projectperitah.information.*;

public class startStory {

    public static void StartStoryAchievement(){
        Game.loadPlace = "Chapter 1 - Trials Ahead Shall Never End.";
        achievements.bootFirstTime = true;
        achievements.achievementTracker = ++achievements.achievementTracker;
        System.out.println("Achievement Unlocked! - Boot the Game Up with a New Save File.");
        StartStory();
    }

    // Actual start of the story.
    public static void StartStory(){
        System.out.println("\nSergeant-Major Clotilde » ");
        customText.typeWriter("Are you ready for your real life examination, ");
        customText.typeWriter("Lieutenant " + Player.playerName + "?");
        customText.typeWriter("Lieutenant " + Player.playerName + " » ");
        customText.typeWriter("Yes ma'am! I am ready to face any trials waiting for me ahead!");
        System.out.println("There is an unlocked door in front of you to the north.");
        System.out.println("You may also save the game.");
        System.out.println("HINT: Type 'Read' to read the book. Type 'north' or 'walk north' to continue from the basement.");
        System.out.println("What would you like to do, " + Player.playerName + "?");

        Game.choice = Game.myScanner.next();

        if (Game.choice.equalsIgnoreCase("read")) {
            readJournal1.journalPage1Achievement();
        }
        if (Game.choice.equalsIgnoreCase("north")){
            customText.errText("Cannot access!");
        }
        if (Game.choice.equalsIgnoreCase("travel north")){

        }
        if (Game.choice.equalsIgnoreCase("walk north")) {

        }
        if (Game.choice.equalsIgnoreCase("walk")){

        }
        if (Game.choice.equalsIgnoreCase("door")){

        }
        if (Game.choice.equalsIgnoreCase("save")){
            saveGame.saveJSON();
            Game.mainMenu();
        }
        else{
            System.out.println("Invalid Command!");
            StartStory();
        }
    }

}
