public class BowlingGame {

    private final static int GAME_ROUND = 10;
    private final static char STRIKE = 'X';
    private final static char SPARE = '/';
    private final static char MISS = '-';
    private final static String BOUNDARY_NORMAL = "\\|";
    private final static String BOUNDARY_EXTRA = "\\|\\|";
    public int getBowlingScore(String bowlingCode) {
        String[] bowlingGrid = bowlingCode.split(BOUNDARY_EXTRA);
        int extraNum = bowlingGrid.length - 1;
        String[] normalBowlingGrid = bowlingGrid[0].split(BOUNDARY_NORMAL);
        return 0;
    }
}
