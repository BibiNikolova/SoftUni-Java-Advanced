package examPreparation.type03.guild;

import java.util.LinkedList;

public class Guild {
    private String name;
    private int capacity;
    private LinkedList<Player> roster;

    public Guild(String color, int capacity) {
        this.name = color;
        this.capacity = capacity;
        this.roster = new LinkedList<Player>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (!player.getRank().equals("Member")) {
            player.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (!player.getRank().equals("Trial")) {
            player.setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);
        for (Player player : removed) {
            roster.remove(player);
        }
        return removed;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Players in the examPreparation.type03.guild: ").append(this.name).append(":").append(System.lineSeparator());
        this.roster.forEach(player -> sb.append(player.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}
