/*
 * NBA Draft Automated Application
 * Author: Argin Aslanian
 * This program will automate a 30 team NBA Draft with 30 Players and 30 Teams
 * Each team selecting an available player in their turn.
 * Menu:
 * 1: NBA Draft -> Conduct the draft - Can only be done once in the program
 * 2: View Players -> Display Available Players
 * 3: View Teams -> Display Teams
 * 4: View Results -> Show the results - Can only be shown after NBA Draft has been conducted
 * 5: Exit
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    // The ArrayLists will store the teams and players
    // The HashMap will store the completed draft
    static ArrayList<String> players = new ArrayList<String>();
    static ArrayList<String> teams = new ArrayList<String>();
    static LinkedHashMap<String, String> draft = new LinkedHashMap<String, String>();

    // Function to load teams and players from the files to the ArrayList
    static void loadFromFile(Scanner file, ArrayList<String> a_list) {
        while (file.hasNextLine()) {
            a_list.add(file.nextLine());
        }
    }

    // Function to display Teams/Players - Options 2 & 3
    static void showPlayersTeams(ArrayList<String> a_list) {
        System.out.println("\n--------------------\n");
        for (int i = 0; i < a_list.size(); i++) {
            System.out.println(i+1 + ": " + a_list.get(i));
            delay(250);
           
        }
        System.out.println("\n--------------------\n");
    }

    // Delay function
    static void delay(int m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Randomize Players and Teams order
    static ArrayList<String> shuffleTeamsPlayers(ArrayList<String> a_List) {
        Collections.shuffle(a_List);
        return a_List;
    }

    // Function to show draft results
    static void showDraftResults(int n) {
        int pick_number = 1;
        for (String s : draft.keySet()) {
            System.out.println(pick_number + ": " + s + " -> " + draft.get(s));
            pick_number++;
            delay(n);
        }
    }

    // NBA Draft Function
    static void startDraft() {
        System.out.print("---------------\nStarting NBA Draft\n---------------\n");
        delay(4000);
        ArrayList<String> shuffled_teams = shuffleTeamsPlayers(teams);
        ArrayList<String> shuffled_players = shuffleTeamsPlayers(players);
        System.out.print("---------------\nDraft Lottery\n---------------");
        showPlayersTeams(shuffled_teams);
        delay(3000);
        // Populate the 'draft' HashMap with shuffled_teams and shuffled_players
        for (int i = 0; i < shuffled_teams.size(); i++) {
            draft.put(shuffled_teams.get(i), shuffled_players.get(i));
        }
        // Draft is now complete
        // Show Draft Results
        showDraftResults(2000);
        System.out.println("---------------\nNBA Draft Completed\n---------------\n");
    }

    public static void main(String[] args) {
        // Initial Message
        System.out.println("\n--- WELCOME TO THE NBA DRAFT! ---\n");

        try {
            // Scanners to read players.txt and teams.txt
            Scanner sc_players = new Scanner(new File("players.txt"));
            Scanner sc_teams = new Scanner(new File("teams.txt"));
            
            // Files have been loaded.
            // Now, Load the players and the teams to the ArrayLists
            loadFromFile(sc_players, players); // Load Players
            loadFromFile(sc_teams, teams); // Load Teams

            // Menu Selections
            int u_selection = 0;
            Scanner u_input = new Scanner(System.in);
            boolean invalid_selection = true;
            boolean draft_exists = false;
            
            // MAIN MENU
            do {

                System.out.println("1: Start NBA Draft");
                System.out.println("2: View Players");
                System.out.println("3: View Teams");
                System.out.println("4: View Results");
                System.out.println("5: Exit");

                // Get user input
                // Validate to make sure its a number between 1-5
                System.out.print("\nSelect From Menu Above: ");
                do {
                    while (!u_input.hasNextInt()) {
                        System.out.print("Invalid Input: Please Try Again: ");
                        u_input.next();
                    }
                    u_selection = u_input.nextInt();
                    if (u_selection < 1 || u_selection > 5) {
                        System.out.print("Invalid Input: Please Try Again: ");
                        invalid_selection = true;
                    } else if (u_selection == 1 && draft_exists) {
                        System.out.print("Draft Already Completed: Please Try Again or Press 4 to View Results: ");
                        invalid_selection = true;
                    } else if (u_selection == 4 && !draft_exists) {
                        System.out.print("Draft has Not Been Completed: Please Try Again or Press 1 to Start NBA Draft: ");
                        invalid_selection = true;
                    } else {
                        invalid_selection = false;
                    }
                } while (invalid_selection);

                switch (u_selection) {
                    case 1:
                        startDraft();
                        draft_exists = true;
                        break;
                    case 2:
                        showPlayersTeams(players);
                        break;
                    case 3:
                        showPlayersTeams(teams);
                        break;
                    case 4:
                        System.out.print("---------------\nNBA Draft Results\n---------------\n");
                        showDraftResults(250);
                        System.out.println("\n-------------------\n");
                        break;
                    case 5:
                        System.out.println("Thank you. NBA Draft Application Ended.");
                        break;
                    default:
                        System.out.println("Invalid selection. NBA Draft Application Ended.");
                        break;
                }

            } while (u_selection != 5);

            // Close the scanner
            u_input.close();
            sc_players.close();
            sc_teams.close();

        } catch (FileNotFoundException e) {
            // Message to quit program if File Not Found
            System.out.println("File was not found: NBA Draft Application Ended.");
        }
    }
}