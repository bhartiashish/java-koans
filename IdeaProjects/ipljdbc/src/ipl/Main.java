package ipl;
import java.util.List;
import java.util.Map;
import static ipl.Constants.*;
import static ipl.Service.*;
import static connections.ConnectionProvider.*;
public class Main {

    public static void main(String[] a) {

        System.out.println("1. Number of matches played per year of all the years in IPL. \n");

        Map<Object, Object> matchesPerYear = matchPerYear();
        matchesPerYear.forEach((year, match) -> System.out.println(year + " - " + match));


        System.out.println("\n2. Number of matches won of all teams over all the years of IPL. \n");

        Map<Object, Object> totalWinningMatchByTeam = totalWinningMatchByTeam();
        totalWinningMatchByTeam.forEach((team, winningMatch) -> System.out.println(team + " - " + winningMatch));


        System.out.println("\n3. For the year 2016 get the extra runs conceded per team. \n");

        Map<Object, Object> extraRunInYear = extraRunInYear(YEAR_FOR_EXTRA_RUN);
        extraRunInYear.forEach((team, extraRun) -> System.out.println(team + " - " + extraRun));

        System.out.println("\n4. For the year 2015 get the top economical bowlers. \n");

        Map<String, Double> economicalBowlerOfYear = economicalBowleroOfYear(YEAR_FOR_ECONOMICAL_BOWLER);
        economicalBowlerOfYear.forEach((team, bolwingEconomy) -> System.out.println(team + " - " + bolwingEconomy));

        Map.Entry<String, Double> entry = economicalBowlerOfYear.entrySet().iterator().next();
        System.out.println("\n" + entry.getKey() + " is the best economical bowler" + " in year "
                + YEAR_FOR_ECONOMICAL_BOWLER + " with economy " + entry.getValue());
    }
}
