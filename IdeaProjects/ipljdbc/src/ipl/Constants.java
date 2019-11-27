package ipl;
import java.util.List;
public final class Constants {
    public static final int FIRST_ROW = 0;
    public static final int YEAR_FOR_ECONOMICAL_BOWLER = 2015;
    public static final int YEAR_FOR_EXTRA_RUN = 2016;
    public static final int SEASON = 1;
    public static final int NO_OF_MATCHES = 2;
    public static final int TEAM = 1;
    public static final int WINNING_MATCH = 2;
    public static final int EXTRA_RUNS = 2;
    public static final int BOWLER = 1;
    public static final int BOWLING_ECONOMY = 2;
    public static final String DRIVER="org.postgresql.Driver";
    public static final String DRIVER_CONNECTION="jdbc:postgresql://localhost:5432/ashish";
    public static final String USERNAME="postgres";
    public static final String PASSWORD="123654";
    public static final String QUEARY_FOR_MATCH_PER_YEAR="select season as year,count(season) " +
            "as number_of_matches from ashish.matches group by season\n";
    public static final String QUEARY_FOR_MATCHES_WON_BY_TEAM="select winner, count(winner) from ashish.matches " +
            "where winner is not null group by winner";
    public static final String QUEARY_FOR_EXTRA_RUNS="select batting_team,sum(extra_runs) from ashish.deliveries where match_id in " +
            "(select id from ashish.matches where season= ? ) group by batting_team";
    public static final String QUEARY_FOR_BEST_ECONOMICAL_BOWLER="select d.bowler,sum(tr)/count(bowler) as bowling_economy " +
            "from(select match_id,inning,over,bowler,sum(total_runs) as tr \n" +
            "from ashish.deliveries group by match_id,inning,over,bowler\n" +
            "order by match_id,inning,over) as d \n" +
            "where match_id in (select id from ashish.matches where season = ? )\n" +
            "group by bowler order by bowling_economy";

}