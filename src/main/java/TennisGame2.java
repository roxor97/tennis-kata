
public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (p1Point == p2Point)
            score = equalScore();

        else if (p1Point >= 4 ||p2Point >= 4)
            score = scoreGreaterThan4();

        else score = differentScore(p1Point) + "-" + differentScore(p2Point);

        return score;
    }

    private String differentScore(int scorePlayer) {
        switch(scorePlayer)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }

    private String equalScore() {
        switch (p1Point){
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String scoreGreaterThan4() {
        int minusResult = p1Point - p2Point;
        switch(minusResult){
            case 1: case -1: return advantageScore(minusResult);
            default: return winScore(minusResult);
        }
    }

    private String advantageScore(int minusResult){
        return minusResult == 1 ? "Advantage player1" : "Advantage player2";
    }

    private String winScore(int minusResult){
        return minusResult >= 2 ? "Win for player1": "Win for player2";
    }


    public void P1Score(){
        p1Point++;
    }
    
    public void P2Score(){
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}