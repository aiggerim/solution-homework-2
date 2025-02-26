package solution-homework-2;

import Project3.Player;

import java.util.Scanner;

public class MUDController {
    private Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to MUD! Type 'help' for a list of commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                if (argument.startsWith("up ")) {
                    pickUp(argument.substring(3));
                } else {
                    System.out.println("Invalid 'pick up' command. Try 'pick up <item>'. ");
                }
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command. Type 'help' to see available commands.");
        }
    }

    private void lookAround() {
        System.out.println(player.getCurrentRoom().describe());
    }

    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Move where? Try 'move forward' or 'move left.'");
        }

        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved " + direction + ".");
            lookAround();
        } else {
            System.out.println("You can’t go that way!");
        }
    }

    private void pickUp(String itemName) {
        if (player.pickUpItem(itemName)) {
            System.out.println("You picked up " + itemName + ".");
        } else {
            System.out.println("No item named '" + itemName + "' here.");
        }
    }

    private void checkInventory() {
        player.showInventory();
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - describe the room");
        System.out.println("move <direction> - move in a direction (forward, back, left, right)");
        System.out.println("pick <itemName> - pick up an item");
        System.out.println("inventory - check your inventory");
        System.out.println("help - show available commands");
        System.out.println("quit / exit - leave the game");
    }
}

