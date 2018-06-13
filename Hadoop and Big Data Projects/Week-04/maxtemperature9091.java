import java.io.BufferedReader;                  
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class maxtemperature9091{

        public static void main(String[] args) throws ClassNotFoundException, SQLException {         //Exception to handle Sql classes not found

                Connection conn = null;
                BufferedReader buffread = null;
                Statement stmnt = null;

             


                        Class.forName("com.mysql.jdbc.Driver");                                     //Code to get the connection into the database 
                        conn = DriverManager.getConnection(
                                        "jdbc:mysql://127.0.0.1/vncweek04", "root", "password");    //Database name, user and pwd given

                        stmnt = conn.createStatement();                                             //statement to connect 
                        
            System.out.println("Connection established");

                        try {

                                String full;

                                buffread = new BufferedReader(new FileReader("9091-sample.txt"));   //function to read the file 

                                while ((full = buffread.readLine()) != null) {
                                        String usaweather_st_id=full.substring(4,10);               //specifying the first field of the weather station 
                                        String wbanweather_st_id=full.substring(10,15);             //specifying the wban weather station id
                                        String obvyr=full.substring(15,19);                         //specifying the year of observation 
                                 
                                        String latitude=full.substring(28,33);
                                        String longitude=full.substring(34,40);                     //specifying latitude and longitude 
				                        String elevation=full.substring(46,50);                     //specifying the elevation
				                        String winddir=full.substring(60,62);                       //specifying wind direction  
                                        String sky_ceil_ht=full.substring(70,74);                   //specifying the sky ceiling height
                                        String visibility_dist=full.substring(78,83);               //specifying the visibility distance
                                        String air_temp;                                            //specifying the air temperature
                                         if (full.charAt(87)=='+'){
                                         air_temp = full.substring(88, 92);
                                 }
                                 else {
                                         air_temp = full.substring(87, 92);
                                          }


                                        
                                        String dew_pt_temp=full.substring(93,97);

				                        String atm_pressure=full.substring(99,103);
                                        
										

                                        String insert= "insert into vnc04.vncdc9091 values (?,?,?,?,?,?,?,?,?,?,?,?);";    //inserting values into the database and parsing
                                        PreparedStatement statement01 = conn.prepareStatement(insert);
                                        statement01.setString(1,usaweather_st_id );
                                        statement01.setString(2,wbanweather_st_id);
                                        statement01.setString(3,obvyr);
                                        statement01.setString(4,latitude );
                                        statement01.setString(5,longitude);
                                        statement01.setString(6,elevation );
                                        statement01.setString(7,winddir );
										statement01.setString(8,sky_ceil_ht );
										statement01.setString(9,visibility_dist );
										statement01.setString(10,air_temp );
                                        statement01.setString(11,dew_pt_temp);
										statement01.setString(12,atm_pressure);

                                        statement01.execute();
                                }
    String sqlstmnt="select obvyr, max(air_temp) from vnc04.vncdc9091 where air_temp != 9999 group by obvyr;";    //Sql statement to select the maximum temperature per year
                                PreparedStatement statement02 = conn.prepareStatement(sqlstmnt);
								System.out.println("The Maximum temperature for the combined years of 1990 and 1991 is given below");
								System.out.println("------------------------------------------------------------------------------");
                                ResultSet rset = statement02.executeQuery();
                                while (rset.next())
                                {
                                        System.out.println(rset.getString(1)+"   "+rset.getString(2));
                                }


                        } catch (IOException e) {
                                e.printStackTrace();
                        } finally {
                                try {
                                        if (buffread != null)
                                                buffread.close();
                                } catch (IOException ex) {
                                        ex.printStackTrace();
                                }
                        }

}}