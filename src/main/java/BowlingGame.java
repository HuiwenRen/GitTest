public class BowlingGame {

    private final static int  GAME_ROUND = 10;
    private final static int  BOWLING_NUM = 10;
    private final static char STRIKE = 'X';
    private final static char SPARE = '/';
    private final static char MISS = '-';
    private final static String BOUNDARY_NORMAL = "\\|";
    private final static String BOUNDARY_EXTRA = "\\|\\|";

    public int getBowlingScore(String bowlingCode) {
        int sumGoal = 0;
        int fShot;
        int sShot;
        String[] bowlingGrid = bowlingCode.split(BOUNDARY_EXTRA);
        boolean extraRound = bowlingGrid.length > 1;
        String[] normalBowlingGrid = bowlingGrid[0].split(BOUNDARY_NORMAL);
        for (int i = 0; i < GAME_ROUND; i++) {
            fShot = getGoal(BOWLING_NUM,normalBowlingGrid[i].charAt(0));
            sShot = getGoal(BOWLING_NUM - fShot,normalBowlingGrid[i].charAt(1));
            sumGoal += fShot + sShot;
        }
        if (extraRound){
            fShot = getGoal(BOWLING_NUM,bowlingGrid[1].charAt(0));
            if(bowlingGrid[1].length()>1){
                sShot = getGoal(BOWLING_NUM - fShot,bowlingGrid[1].charAt(1));
            } else {
                sShot = 0;
            }
            sumGoal += fShot + sShot;
        }
        return sumGoal;
    }

    private int getGoal(int left, char get){
        switch(get){
            case '-':return 0;
            case 'X':return 10;
            case '/': return left;
            default:return get-'0';
        }
    }
}
