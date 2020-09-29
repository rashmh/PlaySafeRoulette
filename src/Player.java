import java.util.ArrayList;
import java.util.List;

public class Player {


    String name;
    List<Bet> betList;

    public Player(String name){
        this.name = name;
        this.betList = new ArrayList<>();
    }
}
