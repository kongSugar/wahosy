package de.kongsugar.wahosy.database;

import java.sql.*;
import java.util.prefs.Preferences;

public class Database {

    private static Connection conn = null;

    private Database() {
        try {
            Preferences prefs = Preferences.userNodeForPackage(this.getClass());

            //if(prefs.nodeExists("url")&&prefs.nodeExists("user")&&prefs.nodeExists("password")){}
            //else{throw new Exception("Couldn't load preferences");}

            String url = prefs.get("url", null);
            String user = prefs.get("user", null);
            String password = prefs.get("password", null);

            conn = DriverManager.getConnection(url,user,password);

            System.out.println(conn.toString());
            System.out.println(conn.getMetaData().getURL());
        } catch (SQLException e) {
            System.out.println("Connect nicht moeglich " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void configure(String url, String port, String db, String user, String password) {
        String jdbcURL = String.format("jdbc:mysql://%s:%s/%s", url, port, db);

        Preferences prefs = Preferences.userNodeForPackage(Database.class);
        prefs.put("url", jdbcURL);
        prefs.put("user", user);
        prefs.put("password", password);
    }

    public static Connection getInstance()
    {
        if(conn == null)
            new Database();
        return conn;
    }

    public static void printItemList()
    {
        conn = getInstance();

        if(conn != null)
        {
            Statement query;
            try {
                query = conn.createStatement();

                // Ergebnistabelle erzeugen und abholen.
                String sql = "SELECT * FROM items";
                ResultSet result = query.executeQuery(sql);

                // Ergebnissätze durchfahren.
                while (result.next()) {

                    int id = result.getInt(1); // Alternativ: result.getString(1);
                    String name = result.getString(2); // Alternativ: result.getString(2);
                    String manufacturer = result.getString(3);
                    System.out.format("%5d%20s%20s", id, name, manufacturer+"\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fügt einen neuen Datensatz hinzu
     */
    public static void insertName(String name_, String manufacturer_,int quantity_,int weight_,String serialnumber_)
    {
        conn = getInstance();

        if(conn != null)
        {
            try {

                // Insert-Statement erzeugen (Fragezeichen werden später ersetzt).
                String sql = "INSERT INTO items(name, manufacturer, quantity, weight, serialnumber) " +
                        "VALUES(?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                // Erstes Fragezeichen durch "name" Parameter ersetzen
                preparedStatement.setString(1, name_);
                // Zweites Fragezeichen durch "manufacturer" Parameter ersetzen
                preparedStatement.setString(2, manufacturer_);
                // Drittes Fragezeichen durch "quantity" Parameter ersetzen
                preparedStatement.setInt(3, quantity_);
                // Viertes Fragezeichen durch "weight" Parameter ersetzen
                preparedStatement.setInt(4, weight_);
                // Fünftes Fragezeichen durch "serialnumber" Parameter ersetzen
                preparedStatement.setString(5, serialnumber_);
                // SQL ausführen.
                preparedStatement.executeUpdate();

                // Es wird der letzte Datensatz abgefragt
                String lastItem = "SELECT * FROM items ORDER BY id DESC LIMIT 1";
                ResultSet result = preparedStatement.executeQuery(lastItem);

                // Wenn ein Datensatz gefunden wurde, wird auf diesen zugegriffen
                if(result.next())
                {
                    int id = result.getInt(1); // Alternativ: result.getString(1);
                    String name = result.getString(2); // Alternativ: result.getString(2);
                    String manufacturer = result.getString(3);
                    int quantity = result.getInt(4);
                    int weight = result.getInt(5);
                    String serialnumber = result.getString(6);
                    System.out.format("%5d%20s%20s%10d%10d%10s", id, name, manufacturer, quantity, weight, serialnumber);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Aktualisiert einen Datensatz
     */
    public static void updateItem(int id_, String name_, String manufacturer_,int quantity_,int weight_,String serialnumber_)
    {
        conn = getInstance();

        if(conn != null)
        {
            try {
    	  
    	/*----------------------------------------fehlt noch-----------------------------------------------
         *
    	 * "Getmethode" erzeugen die alte werte ausliest und in textfields im programm eintägt,
    	 * damit man nicht jeden einzelnen eintrag komplett neuschreiben sondern nur anpassen und absenden muss.
    	 * ------------------------------------------------------------------------------------------------ 
    	 */


                // Update-Statement erzeugen
                String updateSql = "UPDATE items " +
                        "SET name = ?, manufacturer = ? , quantity = ?, weight = ?, serialnumber = ?" +
                        "WHERE id = ?";
                PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateSql);
                // Erstes Fragezeichen durch "name" Parameter ersetzen
                preparedUpdateStatement.setString(1, name_);
                // Zweites Fragezeichen durch "manufacturer" Parameter ersetzen
                preparedUpdateStatement.setString(2, manufacturer_);
                // Drittes Fragezeichen durch "quantity" Parameter ersetzen
                preparedUpdateStatement.setInt(3, quantity_);
                // viertes Fragezeichen durch "weight" Parameter ersetzen
                preparedUpdateStatement.setInt(4, weight_);
                // Fünftes Fragezeichen durch "serialnumber" Parameter ersetzen
                preparedUpdateStatement.setString(5, serialnumber_);

                // sechstes Fragezeichen durch "id" Parameter ersetzen

                preparedUpdateStatement.setInt(6, id_);
                // SQL ausführen
                preparedUpdateStatement.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteItem(int id_)
    {
        conn = getInstance();

        if(conn != null)
        {
            try {

                // Delete-Statement erzeugen
                String deleteSql = "DELETE FROM items " +
                        "WHERE id = ?";
                PreparedStatement preparedDeleteStatement = conn.prepareStatement(deleteSql);
                // Erstes Fragezeichen durch "id" Parameter ersetzen
                preparedDeleteStatement.setInt(1, id_);

                // SQL ausführen
                preparedDeleteStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}