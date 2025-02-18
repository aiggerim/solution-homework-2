package Project_Aigera;

import Project3.Item;
import Project3.Room;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Project3.Item> inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean move(String direction) {
        Room nextRoom = currentRoom.getConnectedRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

    public boolean pickUpItem(String itemName) {
        Project3.Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            inventory.add(item);
            return true;
        }
        return false;
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
