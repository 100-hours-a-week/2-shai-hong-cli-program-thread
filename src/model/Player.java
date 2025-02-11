package src.model;

public class Player extends Person {
    protected int ability;
    protected int salary;

    public Player(String name, int ability, int salary) {
        super(name);
        this.ability = ability;
        this.salary = salary;
    }

    public String toString() {
        return name + " (능력치: " + ability + ", 연봉: " + salary + ")";
    }
}

