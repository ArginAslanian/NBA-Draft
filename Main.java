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
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // The ArrayLists will store the teams and players
    static ArrayList<String> players = new ArrayList<String>();
    static ArrayList<String> teams = new ArrayList<String>();

    // Function to load teams and players from the files to the ArrayList
    static void loadFromFile(Scanner file, ArrayList<String> a_list) {
        while (file.hasNextLine()) {
            a_list.add(file.nextLine());
        }
    }

    public static void main(String[] args) {
        // Initial Message
        System.out.println("--- WELCOME TO THE NBA DRAFT! ---");

        try {
            // Scanners to read players.txt and teams.txt
            Scanner sc_players = new Scanner(new File("players.txt"));
            Scanner sc_teams = new Scanner(new File("teams.txt"));
            
            // Files have been loaded.
            // Now, Load the players and the teams to the ArrayLists
            loadFromFile(sc_players, players); // Load Players
            loadFromFile(sc_teams, teams); // Load Teams

        } catch (FileNotFoundException e) {
            // Message to quit program if File Not Found
            System.out.println("File was not found: Quitting Application...");
        }
    }
}