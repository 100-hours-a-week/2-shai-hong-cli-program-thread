package src;
import java.util.*;
import src.model.Player;
import src.model.StarPlayer;
import src.model.Team;
import src.model.PlayerDataLoader;
import src.model.TimerThread;

public class Main {
    public static void main(String[] args) {
        // 타이머 스레드를 먼저 시작 (30초 제한)
        TimerThread timer = new TimerThread(30);
        timer.start();  // 타이머 스레드 시작

        Scanner scanner = new Scanner(System.in);
        List<Player> players = PlayerDataLoader.loadPlayers();
        Team team = new Team();

        System.out.println("\n🏀 NBA 선수 드래프트 시작! (최대 연봉 200)");
        System.out.println("\n📋 선수 목록:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i));
        }

        System.out.println("\n선수를 뽑으세요! (1~10)");

        // 팀 선택 로직
        while (team.getRemainingSalary() > 0 && team.getSelectedPlayers().size() < 5) {
            System.out.print("\n선수 번호 입력: ");

            if (!scanner.hasNextInt()) {
                System.out.println("❌ 1~10 사이의 번호를 입력해주세요!");
                scanner.next();  // 잘못된 입력값 소비
                continue;
            }
            int choice = scanner.nextInt();

            // players.size()로 유효범위체크
            if (choice < 1 || choice > players.size()) {
                System.out.println("❌ 올바른 번호를 입력하세요! (1~" + players.size() + ")");
                continue;
            }

            Player selected = players.get(choice - 1);
            if (selected == null) {
                System.out.println("⚠️ 이미 선택한 선수입니다!");
                continue;
            }

            if (selected instanceof StarPlayer) {
                ((StarPlayer) selected).showAward();
                System.out.print("이 선수를 선택하시겠습니까? (yes/no): ");
                String confirm = scanner.next();
                if (!confirm.equalsIgnoreCase("yes")) {
                    continue;
                }
            }

            if (team.addPlayer(selected)) {
                players.remove(choice - 1); // ✅ 선택한 선수를 리스트에서 제거
                System.out.println("✅ " + selected.getName() + "을(를) 팀에 추가했습니다!");
                System.out.println("💰 현재 총 연봉: " + (200 - team.getRemainingSalary()));
            
                // 남은 선수 목록 출력
                System.out.println("\n📋 남은 선수 목록:");
                for (int i = 0; i < players.size(); i++) {
                    System.out.println((i + 1) + ". " + players.get(i));
                }
            }            
        }

        timer.stopTimer();
        System.out.println("\n⛔ 더 이상 선수를 추가할 수 없습니다.");
        team.showTeam();
        scanner.close();
    }
}
