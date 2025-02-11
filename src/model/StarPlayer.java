package src.model;

public class StarPlayer extends Player {
    private String award;

    public StarPlayer(String name, int ability, int salary, String award) {
        super(name, ability, salary);
        this.award = award;
    }

    public void showAward() {
        System.out.println(name + "의 수상 경력: " + award);
    }
}
