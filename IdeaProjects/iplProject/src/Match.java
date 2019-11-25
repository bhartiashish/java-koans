import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
class Match {
    private static List<Integer> id = new ArrayList<>();
    private static List<Integer> season = new ArrayList<>();
    private static List<String> winner = new ArrayList<>();
    private static Map<Integer,List<Integer>> seasonIdMap = new HashMap<>();
    public static void setSeasonIdMap(int season,int id) {
        if(seasonIdMap.containsKey(season)) {
            seasonIdMap.get(season).add(id);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(id);
            seasonIdMap.put(season,list);
        }
    }
    public static Map<Integer, List<Integer>> getSeasonIdMap() {
        return seasonIdMap;
    }
    public void setId(Integer id) {
        this.id.add(id);
    }
    public static List<Integer> getId() {
        return id;
    }
    public void setSeason(Integer season) {
        this.season.add(season);
    }
    public static List<Integer> getSeason() {
        return season;
    }
    public void setWinner(String winner) {
        this.winner.add(winner);
    }
    public static List<String> getWinner() {
        return winner;
    }
}