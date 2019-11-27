package ipl;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
import java.math.BigDecimal;
import static connections.ConnectionProvider.*;
import static ipl.Constants.*;
public class Service {

    public static Map<Object ,Object> matchPerYear() {
        Map<Object, Object> matchesPerYear = getResult(QUEARY_FOR_MATCH_PER_YEAR);
        return matchesPerYear;
    }

    public static Map<Object,Object> totalWinningMatchByTeam(){
        Map<Object, Object> totalWinningMatchByTeam = getResult(QUEARY_FOR_MATCHES_WON_BY_TEAM);

        return totalWinningMatchByTeam;
    }
    public static Map<Object,Object> extraRunInYear( int year){

        Map<Object, Object> teamsExtraRun = getResult(QUEARY_FOR_EXTRA_RUNS,year);

        return teamsExtraRun;
    }


    public static Map<String, Double> economicalBowleroOfYear(int year){
        Map<String,Double> listOfBolwer=new LinkedHashMap<>();
        Map<String,Double> ecobowler=new LinkedHashMap<>();
        Map<Object, Object> economicalBowleroOfYear = getResult(QUEARY_FOR_BEST_ECONOMICAL_BOWLER,year);
        for (Map.Entry<Object, Object> entry : economicalBowleroOfYear.entrySet())
        {
            String bowler_name=String.valueOf(entry.getKey());
            String string=String.valueOf(entry.getValue());
            String s=string.substring(0,8);
            Double economy=Double.valueOf(s);
            ecobowler.put(bowler_name,economy);
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
