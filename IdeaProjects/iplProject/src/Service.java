import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class Service {
    //Question 1
    public static Map<Integer,Integer> matchPerYear(List<String> matchList) {
        Map<Integer,Integer> matchesPerYear = new HashMap<>();
        List<Integer> season=Match.getSeason();
        for(Integer line : season) {
            if (matchesPerYear.containsKey(line)) {
                matchesPerYear.put(line, matchesPerYear.get(line) + 1);
            } else {
                matchesPerYear.put(line, 1);
            }
        }
        return matchesPerYear;
    }
    //Question 2
    public static Map<String,Integer> totalWinningMatchByTeam(List<String> matchList){
        Map<String,Integer> teamWinningMatch = new HashMap<>();
        List<String> winner=Match.getWinner();
        for(String line : winner) {
            String team= line;
            if (team.equals("")) {
                team = "total draw match";
            }
            if (teamWinningMatch.containsKey(team)) {
                teamWinningMatch.put(team, teamWinningMatch.get(team) + 1);
            } else {
                teamWinningMatch.put(team, 1);
            }
        }
        return teamWinningMatch;
    }
    //Question 3
    public static Map<String,Integer> extraRunInYear(List<String> matchList,List<String> deliveryList,int year) {
        Map<String,Integer> teamsExRun = new HashMap<>();
        for(Integer id : Match.getSeasonIdMap().get(year)){
            for(Integer index : Delivery.getMatchIdIndexMap().get(id)){
                String team=Delivery.getBattingTeam().get(index);
                int extraRun=Delivery.getExtraRun().get(index);
                if(teamsExRun.containsKey(team)){
                    teamsExRun.put(team,teamsExRun.get(team)+ extraRun);
                }else {
                    teamsExRun.put(team, extraRun);
                }
            }
        }
        return teamsExRun;
    }
    //Question 4
    public static Map<String, Double> economicalBowleroOfYear(List<String> matchList,List<String> deliveryList,int year) {
        Map<String,Integer> stringMap = new HashMap<>();
        Map<String,Double> ecobowler = new HashMap<>();
        Map<String,Integer> bowlerRun = new HashMap<>();
        Map<String,Double> bowlerOver = new HashMap<>();
        Map<String,Double> listOfBolwer=new LinkedHashMap<>();
        for(Integer id : Match.getSeasonIdMap().get(year)){
            for(Integer index : Delivery.getMatchIdIndexMap().get(id)){
                int totalRun=Delivery.getTotalRun().get(index);
                String string=Delivery.getMatchId().get(index)+"-"+Delivery.getInning().get(index)+
                        "-"+Delivery.getOver().get(index);
                String bowler=Delivery.getBowler().get(index);
                if (stringMap.containsKey(string)) {
                } else {
                    stringMap.put(string, 0);
                    if (bowlerOver.containsKey(bowler)) {
                        bowlerOver.put(bowler, bowlerOver.get(bowler) + 1);
                    } else {
                        bowlerOver.put(bowler, 1.0);
                    }
                }
                if (bowlerRun.containsKey(bowler)) {
                    bowlerRun.put(bowler, bowlerRun.get(bowler) + totalRun);
                } else {
                    bowlerRun.put(bowler, totalRun);
                }
            }
        }
        for (Map.Entry<String, Double> entry : bowlerOver.entrySet())
        {
            double d=bowlerRun.get(entry.getKey())/entry.getValue();
            ecobowler.put(entry.getKey(),d);
        }
        List<Map.Entry<String,Double>> list =new LinkedList<Map.Entry<String,Double>>(ecobowler.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Double>>(){
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String,Double> item : list) {
            listOfBolwer.put(item.getKey(),item.getValue());
        }
        return listOfBolwer;
    }
}