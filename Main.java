package Project_Aigera;

import Project3.Item;
import Project3.MUDController;
import Project3.Player;
import Project3.Room;

public class Main {
    public static void main(String[] args) {
        Room startRoom = new Room("Cave Entrance", "A dark cave entrance.");
        Room forest = new Room("Forest", "A dense forest with tall trees.");
        Room dungeon = new Room("Dungeon", "A cold, damp dungeon with stone walls.");

        startRoom.connectRoom("forward", forest);
        forest.connectRoom("back", startRoom);
        forest.connectRoom("right", dungeon);
        dungeon.connectRoom("left", forest);

        startRoom.addItem(new Project3.Item("torch"));
        forest.addItem(new Item("sword"));

        Player player = new Player(startRoom);
        MUDController controller = new MUDController(player);

        controller.runGameLoop();
    }
}
