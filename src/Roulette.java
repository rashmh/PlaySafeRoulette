
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

public class Roulette {

    static Set<Player> players = new HashSet<>();
    static Scanner input = new Scanner(System.in);

    static{
        try {
            Scanner userFile = new Scanner(new File("players.txt"));
            while(userFile.hasNext()){
                players.add(new Player(userFile.nextLine().trim()));
            }
            userFile.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        final LocalDateTime end = now.plusSeconds(30);

        while (now.isBefore(end)) {
            players.forEach(Roulette::setBet);
            now = LocalDateTime.now();
        }

        input.close();

        players.forEach(p -> {
            System.out.printf("\n%s bet list: \n\n", p.name);
            p.betList.forEach(b -> {
                System.out.printf("Bet Type: %s \t Bet Value: %s \t Bet Amount: %.2f\n", b.value.getClass().getSimpleName(), b.value.toString(), b.amount);
            });
        });
    }

    static void setBet(Player player){
        try{
            System.out.println("Please enter a bet [1 -36 | EVEN | ODD] and bet amount: ");
            System.out.print(player.name+ "\t");
            player.betList.add(new Bet(input.nextLine().split(" ")));
        }catch(Exception e){
            repeat(e.getMessage(),player);
        }
    }

    public static void repeat(String reason, Player player){
        System.out.println(reason);
        System.out.println("please try again!");
        setBet(player);
    }

}
