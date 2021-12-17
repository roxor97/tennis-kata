
public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private final String player1Name;
    private final String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (scoreIsLowerThan4()) {
            return lowerThan4();
        } else if (scorePlayer1 == scorePlayer2) {
            return "Deuce";
        } else {
            return greaterThan4();
        }
    }

    private boolean scoreIsLowerThan4() {
        return bothScoreLowerThan4() && additionDifferentTo6();
    }

    private boolean bothScoreLowerThan4() {
        return scorePlayer1 < 4 && scorePlayer2 < 4;
    }

    private boolean additionDifferentTo6() {
        return scorePlayer1 + scorePlayer2 != 6;
    }

    private String greaterThan4() {
        String playerName = getPlayerName();
        return scoreAdvantageOrWin() ? "Advantage " + playerName : "Win for " + playerName;
    }

    private boolean scoreAdvantageOrWin() {
        return (scorePlayer1 - scorePlayer2) * (scorePlayer1 - scorePlayer2) == 1;
    }

    private String getPlayerName() {
        String playerName;
        playerName = scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
        return playerName;
    }

    private String lowerThan4() {
        String score;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        score = p[scorePlayer1];
        return (scorePlayer1 == scorePlayer2) ? score + "-All" : score + "-" + p[scorePlayer2];
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            this.scorePlayer1++;
        else
            this.scorePlayer2++;
    }

}