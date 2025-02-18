package Project_Aigera;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> connectedRooms;
    private List<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.connectedRooms = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public void connectRoom(String direction, Room room) {
        connectedRooms.put(direction, room);
    }

    public Room getConnectedRoom(String direction) {
        return connectedRooms.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n").append(description).append(".\n");

        if (!items.isEmpty()) {
            sb.append("Items here: ");
            for (Item item : items) {
                sb.append(item.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); // Убираем последнюю запятую
            sb.append("\n");
        }

        return sb.toString();
    }
}
