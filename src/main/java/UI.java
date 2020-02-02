import java.util.Scanner;

public class UI {

    public Scanner sc = new Scanner(System.in);
    public Game game = new Game();

    public void welcome(){
        System.out.println("Welcome lets play BlackJack!");
    }

    public int getPlayerNumber(){
        System.out.println("How many players is there?");
        int players = sc.nextInt();
        return players;
    }

    public void getPlayerName(int numberPlayers){
        Player returnName = new Player("");
        for(int i = 0; i < numberPlayers; i ++){
            System.out.println("\n Please enter your name:");
            String name = sc.next();
            Player playerName = new Player(name);
            game.addPlayer(playerName);
        }
    }

    public void startGame(){
        game.deal();
    }

    public Player winner(){
        return game.winner();
    }

    public void printWinner(Player player) {
        String name = player.getName();
        System.out.println(name + " is the winner!");
    }
}