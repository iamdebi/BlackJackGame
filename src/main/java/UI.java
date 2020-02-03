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

    public void stickOrTwist() {
        for (int i = 1; i < game.countPlayers(); i++) {
            for (Player player : game.getPlayers()) {
                int handValue = player.handValue();
                Scanner sc = new Scanner(System.in);
                System.out.println(player.getName() + ", it's your turn and your current hand value is " + handValue + ". Would you like to stick or twist?");
                String result = sc.nextLine();
                game.stickOrTwist(player, result);
            }
        }
    }

    public Player winner(){
        return game.winner();
    }

    public void printWinner(Player player) {
        String name = player.getName();
        System.out.println(name + " is the winner!");
    }
}