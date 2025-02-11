package src.model;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> selectedPlayers = new ArrayList<>();
    private int totalSalary = 0;
    private static final int SALARY_CAP = 200;

    public List<Player> getSelectedPlayers() {
        return selectedPlayers;
    }

    public boolean addPlayer(Player player) {
        if (totalSalary + player.salary > SALARY_CAP) {
            System.out.println("💰 연봉 초과! 이 선수를 추가할 수 없습니다.");
            return false;
        }
        selectedPlayers.add(player);
        totalSalary += player.salary;
        return true;
    }

    public void showTeam() {
        System.out.println("\n🏀 최종 팀 구성:");
        for (Player p : selectedPlayers) {
            System.out.println(p);
        }
        System.out.println("총 연봉: " + totalSalary + " (제한: " + SALARY_CAP + ")");
    }

    public int getRemainingSalary() {
        return SALARY_CAP - totalSalary;
    }
}

