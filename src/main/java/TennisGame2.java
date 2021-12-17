
public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;
    
    public String p1Res = "";
    public String p2Res = "";
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

        if (p1Point > 0 && p2Point ==0)
        {
            if (p1Point ==1)
                p1Res = "Fifteen";
            if (p1Point ==2)
                p1Res = "Thirty";
            if (p1Point ==3)
                p1Res = "Forty";
            
            p2Res = "Love";
            score = p1Res + "-" + p2Res;
        }
        if (p2Point > 0 && p1Point ==0)
        {
            if (p2Point ==1)
                p2Res = "Fifteen";
            if (p2Point ==2)
                p2Res = "Thirty";
            if (p2Point ==3)
                p2Res = "Forty";
            
            p1Res = "Love";
            score = p1Res + "-" + p2Res;
        }
        
        if (p1Point > p2Point && p1Point < 4)
        {
            if (p1Point ==2)
                p1Res ="Thirty";
            if (p1Point ==3)
                p1Res ="Forty";
            if (p2Point ==1)
                p2Res ="Fifteen";
            if (p2Point ==2)
                p2Res ="Thirty";
            score = p1Res + "-" + p2Res;
        }
        if (p2Point > p1Point && p2Point < 4)
        {
            if (p2Point ==2)
                p2Res ="Thirty";
            if (p2Point ==3)
                p2Res ="Forty";
            if (p1Point ==1)
                p1Res ="Fifteen";
            if (p1Point ==2)
                p1Res ="Thirty";
            score = p1Res + "-" + p2Res;
        }

        return score;
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
        if ("player1".equals(player))
            P1Score();
        else
            P2Score();
    }
}