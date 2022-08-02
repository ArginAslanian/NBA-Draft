/*
 * NBA Draft Automated Application
 * Author: Argin Aslanian
 * This program will automate a 30 team NBA Draft with 30 Players and 30 Teams
 * Each team selecting an available player in their turn.
 * Menu:
 * 1: NBA Draft -> Conduct the draft
 * 2: View Available Players -> Display Available Players
 * 3: View Teams -> Display teams with their draft lottery number
 * 4: View Results -> Show the results
 * 5: Exit
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initial Message
        System.out.println("--- WELCOME TO THE NBA DRAFT! ---");

        try {
            // Scanners to read players.txt and teams.txt
            Scanner sc_players = new Scanner(new File("players.txt"));
            Scanner sc_teams = new Scanner(new File("teams.txt"));
            

        } catch (FileNotFoundException e) {
            // Message to quit program if File Not Found
            System.out.println("File was not found: Quitting Application...");
        }
        
    }
}