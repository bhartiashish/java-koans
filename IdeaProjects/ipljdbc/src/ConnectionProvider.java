package connections;
import static ipl.Constants.*;
import java.sql.*;
import java.util.HashMap;
import java.util.*;
public class ConnectionProvider {
    public static Map<Object ,Object> getResult(String Queary, Object ... list)
    {
        Map<Object,Object> matchesPerYear = new HashMap<>();
        try
        {
            Class.forName(DRIVER);
            Connection con=DriverManager.getConnection(DRIVER_CONNECTION,USERNAME,PASSWORD);
            PreparedStatement pre =con.prepareStatement(Queary);

            int count =1;
            for(Object object : list){
                pre.setObject(count, object);
                count++;
            }
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                matchesPerYear.put(rs.getObject(SEASON),rs.getObject(NO_OF_MATCHES));
            }
            return matchesPerYear;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }
}
