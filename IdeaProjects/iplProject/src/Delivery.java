import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Delivery {
    private static List<Integer> matchId = new ArrayList<>();
    private static List<Integer> extraRun = new ArrayList<>();
    private static List<Integer> totalRun = new ArrayList<>();
    private static List<String> inning = new ArrayList<>();
    private static List<String> over = new ArrayList<>();
    private static List<String> battingTeam = new ArrayList<>();
    private static List<String> bowlingTeam = new ArrayList<>();
    private static List<String> bowler = new ArrayList<>();
    private static Map<Integer,List<Integer>> matchIdIndexMap = new HashMap<>();
    static int index=0;

    
    public static void setMatchIdIndexMap(int matchId) {
        if(matchIdIndexMap.containsKey(matchId)) {
            matchIdIndexMap.get(matchId).add(index);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(index);
            matchIdIndexMap.put(matchId,list);
        }
        index++;
        Delivery.matchIdIndexMap = matchIdIndexMap;
    }
    public static Map<Integer, List<Integer>> getMatchIdIndexMap() {
        return matchIdIndexMap;
    }
    public void setMatchId(int matchId) {
        this.matchId.add(matchId);
    }
    public static List<Integer> getMatchId() {
        return matchId;
    }
    public static List<Integer> getExtraRun() {
        return extraRun;
    }
    public void setExtraRun(Integer extraRun) {
        this.extraRun.add(extraRun);
    }
    public static List<String> getBowler() {
        return bowler;
    }
    public void setBowler(String bowler) {
        this.bowler.add(bowler);
    }
    public static List<String> getBowlingTeam() {
        return bowlingTeam;
    }
    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam.add(bowlingTeam);
    }
    public static List<String> getOver() {
        return over;
    }
    public void setOver(String over) {
        this.over.add(over);
    }
    public static List<String> getBattingTeam() {
        return battingTeam;
    }
    public void setBattingTeam(String battingTeam) {
        this.battingTeam.add(battingTeam);
    }
    public static List<Integer> getTotalRun() {
        return totalRun;
    }
    public void setTotalRun(Integer totalRun) {
        this.totalRun.add(totalRun);
    }
    public static List<String> getInning() {
        return inning;
    }
    public void setInning(String inning) {
        this.inning.add(inning);
    }
}