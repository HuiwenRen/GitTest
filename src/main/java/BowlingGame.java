public class BowlingGame {

    private final int  GAME_ROUND = 10;
    private final int  BOWLING_NUM = 10;
    private final char STRIKE = 'X';
    private final char SPARE = '/';
    private final char MISS = '-';
    private final String BOUNDARY_NORMAL = "\\|";
    private final String BOUNDARY_EXTRA = "\\|\\|";
    public int getBowlingScore(String bowlingCode) {
        int sumGoal = 0;
        int left = BOWLING_NUM;
        int fShot = 0;
        int sShot = 0;
        String[] bowlingGrid = bowlingCode.split(BOUNDARY_EXTRA);
        int extraNum = bowlingGrid.length - 1;
        String[] normalBowlingGrid = bowlingGrid[0].split(BOUNDARY_NORMAL);
        for (int i = 0; i < GAME_ROUND; i++) {
            fShot = getGoal(left,normalBowlingGrid[i].charAt(0));
            sShot = getGoal(left - fShot,normalBowlingGrid[i].charAt(1));
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
