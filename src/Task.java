import java.util.HashMap;

public class Task {
    public int level;
    public HashMap<String,Integer>animalsAppearing=new HashMap<>();
    public HashMap<String,Integer>neededCommodity=new HashMap<>();
    public int firstStandardTime;
    public int secondStandardTime;
    public int firstBonus;
    public int secondBonus;
    public int initialCoin;


    public Task(int level, int firstStandardTime, int secondStandardTime, int firstBonus, int secondBonus, int initialCoin) {
        this.level = level;
        this.firstStandardTime = firstStandardTime;
        this.secondStandardTime = secondStandardTime;
        this.firstBonus = firstBonus;
        this.secondBonus = secondBonus;
        this.initialCoin = initialCoin;
    }
}
