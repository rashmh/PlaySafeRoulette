import java.util.ArrayList;

public class Player {


    String name;
    List<Bet> betList;

    public Player(String name){
        this.name = name;
        this.betList = new ArrayList<>();
    }
}
