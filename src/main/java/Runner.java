public class Runner {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.welcome();
        int numberPlayers = ui.getPlayerNumber();
        ui.getPlayerName(numberPlayers);
        ui.startGame();
        Player winner = ui.winner();
        ui.printWinner(winner);

    }
}
