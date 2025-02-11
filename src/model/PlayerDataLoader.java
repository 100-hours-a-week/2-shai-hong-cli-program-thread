package src.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerDataLoader {
    
    public static List<Player> loadPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new StarPlayer("Stephen Curry", 93, 50, "MVP 2회"));
        players.add(new Player("LeBron James", 90, 40));
        players.add(new StarPlayer("Kevin Durant", 92, 45, "Finals MVP 2회"));
        players.add(new Player("Luka Doncic", 90, 40));
        players.add(new Player("Anthony Davis", 85, 35));
        players.add(new StarPlayer("Shai Gilgeous-Alexander", 95, 40, "올-NBA 1st 팀"));
        players.add(new Player("Bam Adebayo", 80, 30));
        players.add(new Player("Jason Tatum", 85, 40));
        players.add(new Player("Paul George", 80, 35));
        players.add(new Player("Kawhi Leonard", 85, 40));
        return players;
    }
}
