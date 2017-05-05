public class BowlingGame {

    private final static int GAME_ROUND = 10;
    private final static int BOWLING_NUM = 10;
    private final static char STRIKE = 'X';
    private final static char SPARE = '/';
    private final static char MISS = '-';
    private final static char BOUNDARY = '|';

    boolean extra = false;
    int left = BOWLING_NUM;
    int cru = 1;
    int cru2 = 1;

    public int getBowlingScore(String bowlingCode) {
        int sumGoal = 0;
        for (int i = 0; i < bowlingCode.length(); i++) {
            int k = bowlingCode.charAt(i) - '0';
            if (extra) {
                cru -= 1;
            }
            switch (bowlingCode.charAt(i)) {
                case BOUNDARY:
                    if (bowlingCode.charAt(i - 1) == BOUNDARY)
                        extra = true;
                    left = BOWLING_NUM;
                    break;
                case STRIKE:
                    sumGoal += BOWLING_NUM * cru;
                    chCru(1, 1);
                    break;
                case SPARE:
                    sumGoal += left * cru;
                    chCru(1, 0);
                    break;
                case MISS:
                    chCru(0, 0);
                    break;
                default:
                    left -= k;
                    sumGoal += k * cru;
                    chCru(0, 0);
            }
        }
        return sumGoal;
    }

    private void chCru(int n1, int n2) {
        cru = extra ? cru2 : cru2 + n1;
        cru2 = extra ? 0 : n2 + 1;
    }
}
