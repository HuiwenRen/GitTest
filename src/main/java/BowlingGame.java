import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private final static int GAME_ROUND = 10;
    private final static int BOWLING_NUM = 10;
    private final static char STRIKE = 'X';
    private final static char SPARE = '/';
    private final static char MISS = '-';
    private final static String BOUNDARY_NORMAL = "\\|";
    private final static String BOUNDARY_EXTRA = "\\|\\|";

    List<Grid> gridList = new ArrayList<Grid>();

    class Grid {
        boolean isExtra;
        int left;
        int getGoal;
        int crack;
        List<Integer> shot;

        Grid(String code, boolean isExtra) {
            this.isExtra = isExtra;
            crack = 1;
            getGoal = 0;
            left = BOWLING_NUM;
            shot = new ArrayList<Integer>();
            for (int i = 0; i < code.length(); i++) {
                shot.add(getGoal(left, code.charAt(i)));
                if(!isExtra){
                    int cra = 1;
                    left -= shot.get(i);
                    if (left == 0) {
                        cra += 1;
                    }
                    if (shot.get(i) == BOWLING_NUM) {
                        cra += 1;
                    }
                    getGoal = cra > 1 ? 10 : getGoal + shot.get(i) * crack;
                    crack = cra;
                }
            }
        }
    }

    private void initGridList(String bowlingCode) {
        String[] bowlingGrid = bowlingCode.split(BOUNDARY_EXTRA);
        String[] normalBowlingGrid = bowlingGrid[0].split(BOUNDARY_NORMAL);
        boolean extraRound = bowlingGrid.length > 1;
        for (int i = 0; i < GAME_ROUND; i++) {
            gridList.add(new Grid(normalBowlingGrid[i], false));
        }
        if (extraRound) {
            gridList.add(new Grid(bowlingGrid[1], true));
        }
    }

    public int getBowlingScore(String bowlingCode) {
        int sumGoal = 0;
        int fCrack = 0;
        int sCrack = 0;
        initGridList(bowlingCode);
        for (Grid grid : gridList) {
            sumGoal += grid.getGoal;
            sumGoal += grid.shot.get(0) * fCrack;
            if(sCrack != 0 && grid.shot.size()>1){
                sumGoal += grid.shot.get(1) * sCrack;
                sCrack = 0;
            }
            fCrack = grid.crack > 1 ? sCrack + 1 : sCrack;
            sCrack = grid.crack > 2 ? 1 : 0;
        }
        return sumGoal;
    }

    private static int getGoal(int left, char sym) {
        switch (sym) {
            case MISS:
                return 0;
            case STRIKE:
            case SPARE:
                return left;
            default:
                return sym - '0';
        }
    }
}
