package dpsa.lab.dbforlogging;

import junit.framework.TestCase;

import java.io.FileWriter;

public class TestConsoleLogging extends TestCase {

    public void testCreateTableLogging() {
        DBStorage db = new DB();
        db = new ConsoleLoggingDBDecorator(db);

        db.createTable("MyTable", 3);
    }

    public void testInsertLogging() {
        DBStorage db = new DB();
        db = new ConsoleLoggingDBDecorator(db);

        String row1[] = {"1A", "1B", "1C"};
        String row2[] = {"2A", "2B", "2C"};
        db.createTable("MyTable", 3);
        db.insert("MyTable", row1);
        db.insert("MyTable", row2);
    }

    public void testSelectLogging() {
        DBStorage db = new DB();
        db = new ConsoleLoggingDBDecorator(db);

        db.createTable("MyTable", 3);
        String row1[] = {"1A", "1B", "1C"};
        String row2[] = {"2A", "2B", "2C"};
        String row3[] = {"3A", "2B", "3C"};
        db.insert("MyTable", row1);
        db.insert("MyTable", row2);
        db.insert("MyTable", row3);
        DBTable tab = db.select("MyTable", 1, "2B");
    }

    public void testJoinLogging() {
        DBStorage db = new DB();
        db = new ConsoleLoggingDBDecorator(db);

        db.createTable("MyTable1", 3);
        db.createTable("MyTable2", 2);
        String row11[] = {"1A", "1B", "1C"};
        String row12[] = {"2A", "2B", "2C"};
        String row13[] = {"3A", "2B", "3C"};
        String row21[] = {"2B", "1B'"};
        db.insert("MyTable1", row11);
        db.insert("MyTable1", row12);
        db.insert("MyTable1", row13);
        db.insert("MyTable2", row21);
        DBTable jtab = db.join("MyTable1", "MyTable2", 1, 0);
    }

}
