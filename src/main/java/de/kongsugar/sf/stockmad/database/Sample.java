package de.kongsugar.sf.stockmad.database;

/**
 * Created by nikog on 04.09.2015.
 */
public class Sample {
    public static void main(String[] args) {
        // Abfrage aller vorhandenen Namen
        MySQLConnection.printItemList();
        MySQLConnection.deleteItem(1);
        MySQLConnection.printItemList();
        MySQLConnection.insertName("aaaa", "ssss", 5, 9000, "8a8a5a8a");
        MySQLConnection.printItemList();
    }
}
