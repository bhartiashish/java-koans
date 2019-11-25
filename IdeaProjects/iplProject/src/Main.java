import java.util.*;
public class Main {
    public static void main(String[] a){
        Data data = new Data();
        List<String> deliveryList= data.deliveryData();
        List<String> matchList = data.matchData();
        Service service=new Service();

        System.out.println("1. Number of matches played per year of all the years in IPL. \n");

        Map<Integer,Integer> matchesPerYear = service.matchPerYear(matchList);
        matchesPerYear.forEach((year,match) -> System.out.println(year+" - "+match));

        System.out.println("\n2. Number of matches won of all teams over all the years of IPL. \n");

        Map<String,Integer> totalWinningMatchByTeam = service.totalWinningMatchByTeam(matchList);
        totalWinningMatchByTeam.forEach((team,winningMatch) -> System.out.println(team+" - "+winningMatch));


        System.out.println("\n3. For the year 2016 get the extra runs conceded per team. \n");

        Map<String,Integer> extraRunInYear=service.extraRunInYear(matchList,deliveryList,Constant.YEAR_FOR_EXTRA_RUN);
        extraRunInYear.forEach((team,extraRun) -> System.out.println(team +" - "+extraRun));

        System.out.println("\n4. For the year 2015 get the top economical bowlers. \n");

        Map<String,Double> economicalBowleroOfYear=service.economicalBowleroOfYear(
                matchList,deliveryList,Constant.YEAR_FOR_ECONOMICAL_BOWLER);
        economicalBowleroOfYear.forEach((team,bolwingEconomy) -> System.out.println(team +" - "+bolwingEconomy));

        Map.Entry<String,Double> entry = economicalBowleroOfYear.entrySet().iterator().next();
        System.out.println("\n"+entry.getKey()+" is the best economical bowler"+" in year "
                +Constant.YEAR_FOR_ECONOMICAL_BOWLER+" with economy "+entry.getValue());
    }
}