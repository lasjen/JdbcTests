package eritec.demo.oracle.queryReturnColl;

import eritec.demo.oracle.db.OracleConnectionFactory;
import oracle.jdbc.OracleConnection;

import java.sql.*;

public class TestReturnColl {

   private static OracleConnection conn =  null;

   public static OracleConnection getOracleConnection() throws ClassNotFoundException, SQLException {
      return (OracleConnection) OracleConnectionFactory.getConnection();
   }

   public static Connection getConnection() throws ClassNotFoundException, SQLException {
      return OracleConnectionFactory.getConnection();
   }

   public static void main(String[] args) throws Exception {

        conn = getOracleConnection();

        check_objects_exists();


        /*trace_on(conn);
        do_test(conn);
        trace_off(conn);
        drop_objects(conn);*/

      System.out.println("INFO: Main completed");
   }

   static void check_objects_exists() throws Exception {
      PreparedStatement ps = null;
      ResultSet rs = null;
      Statement st = conn.createStatement();
      String query;
      int cnt = -1;
      System.out.println("-------------------------------------------------------------");
      System.out.println("INFO: Checking if objects exists ...");
      ps = conn.prepareStatement("SELECT count(*) FROM user_tables WHERE table_name in (?, ?)");
      ps.setString(1,"EMP");
      ps.setString(2, "DEPT");
      rs = ps.executeQuery();
      while (rs.next()) cnt = rs.getInt(1);

      if (cnt!=2) {
         System.out.println("======================================================================================");
         System.out.println("Warning: Missing objects in DB");
         System.out.println("Run    : src/main/resource/eritec/demo/queryReturnColl/query_returning_collections.sql");
         System.out.println("======================================================================================");
         System.exit(0);
      }

      rs.close();
      ps.close();
      st.close();
   }


}
