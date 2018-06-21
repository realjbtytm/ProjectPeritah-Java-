package ga.raindrop.projectperitah.positions;

import ga.raindrop.projectperitah.Game;
import ga.raindrop.projectperitah.achievements;
import ga.raindrop.projectperitah.saving.saveGame;

public class readJournal1 {

    public static void journalPage1Achievement(){
        Game.loadPlace = "1A";
        achievements.beginJourneyNotebook = true;
        achievements.achievementTracker = ++achievements.achievementTracker;
        System.out.println("Achievement Unlocked! - Begin the Journey with a Notebook.");
        journalPage1();
    }

    public static void journalPage1(){
        System.out.println("This piece of paper seems ripped out from a notebook.");
        System.out.println("It looks like it used to be damp with water.");
        System.out.println("");
        System.out.println("Journal Entry 1 - January 1st.");
        System.out.println("");
        System.out.println("");

        Game.choice = Game.myScanner.next();

        if (Game.choice.equalsIgnoreCase("north")){

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
            journalPage1();
        }

    }
}
