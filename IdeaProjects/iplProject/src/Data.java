import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Data {
    public static List<String> parseCsv(String fileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        }
        catch(Exception e) {
            System.out.println("Some exception occured while parsing file");
        }
        lines.remove(0);
        return lines;
    }
    public static List<String> deliveryData(){
        List<String> deliveriesLines = parseCsv(Constant.DELIVERY_FILES);
        deliveriesLines.forEach(deliveryLine -> {
            String[] deliveryValues = deliveryLine.split(",");
            Delivery delivery = new Delivery();
            int matchId=Integer.valueOf(deliveryValues[Constant.MATCH_ID]);
            delivery.setMatchId(matchId);
            delivery.setExtraRun(Integer.valueOf(deliveryValues[Constant.EXTRA_RUN]));
            delivery.setTotalRun(Integer.valueOf(deliveryValues[Constant.TOTAL_RUN]));
            delivery.setOver(deliveryValues[Constant.OVER]);
            delivery.setInning(deliveryValues[Constant.INNING]);
            delivery.setBowler(deliveryValues[Constant.BOWLER]);
            delivery.setBowlingTeam(deliveryValues[Constant.BOWLING_TEAM]);
            delivery.setBattingTeam(deliveryValues[Constant.BATTING_TEAM]);
            Delivery.setMatchIdIndexMap(matchId);
        });
        return deliveriesLines;
    }
    public static List<String> matchData() {
        List<String> matchesLines = parseCsv(Constant.MATCH_FILES);
        Map<Integer,String> seasonIdMap=new HashMap<>();
        for(String line : matchesLines){
            List<Integer> list=new ArrayList<>();
            String[] matchValues = line.split(",");
            Match match=new Match();
            int id=Integer.valueOf(matchValues[Constant.ID]);
            match.setId(id);
            int season=Integer.valueOf(matchValues[Constant.SEASON]);
            match.setSeason(season);
            match.setWinner(matchValues[Constant.WINNER]);
            Match.setSeasonIdMap(season,id);
        }
        return matchesLines;
    }
}