/*
 * NBA Draft Automated Application
 * Author: Argin Aslanian
 * This program will automate a 30 team NBA Draft with 30 Players and 30 Teams
 * Each team selecting an available player in their turn.
 * Menu:
 * 1: NBA Draft -> Conduct the draft - Can only be done once in the program
 * 2: View Available Players -> Display Available Players
 * 3: View Teams -> Display teams with their draft lottery number
 * 4: View Results -> Show the results - Can only be shown after NBA Draft has been conducted
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

            // Menu Selections
            int u_selection = 0;
            Scanner u_input = new Scanner(System.in);
            
            // MAIN MENU
            do {

                System.out.println("1: Start NBA Draft");
                System.out.println("2: View Available Players");
                System.out.println("3: View Teams");
                System.out.println("4: View Results");
                System.out.println("5: Exit");

                // Get user input
                // Validate to make sure its a number between 1-5
                System.out.print("Select From Menu Above: ");
                do {
                    while (!u_input.hasNextInt()) {
                        System.out.print("Invalid Input: Please Try Again: ");
                        u_input.next();
                    }
                    u_selection = u_input.nextInt();
                    if (u_selection < 1 || u_selection > 5) {
                        System.out.print("Invalid Input: Please Try Again: ");
                    }
                } while (u_selection < 1 || u_selection > 5);

                switch (u_selection) {
                    case 1:
                        System.out.println("Start NBA Draft");
                        break;
                    case 2:
                        System.out.println("View Available Players");
                        break;
                    case 3:
                        System.out.println("View Teams");
                        break;
                    case 4:
                        System.out.println("View Results");
                        break;
                    case 5:
                        System.out.println("Thank you. NBA Draft Application Ended.");
                        break;
                    default:
                        System.out.println("Invalid selection. NBA Draft Application Ended.");
                        break;
                }

            } while (u_selection != 5);


        } catch (FileNotFoundException e) {
            // Message to quit program if File Not Found
            System.out.println("File was not found: NBA Draft Application Ended.");
        }
    }
}