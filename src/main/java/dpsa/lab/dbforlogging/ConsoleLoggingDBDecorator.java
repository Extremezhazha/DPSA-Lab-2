package dpsa.lab.dbforlogging;

import org.apache.log4j.Logger;

// INFO level logging for console
public class ConsoleLoggingDBDecorator extends DBDecorator {
    static final Logger log = Logger.getLogger(ConsoleLoggingDBDecorator.class.getName());

    public ConsoleLoggingDBDecorator(DBStorage database) {
        super(database);
    }

    @Override
    public void createTable(String name, int columns) {
        log.info("Table " + name + " with " + columns + " columns created");

        super.createTable(name, columns);
    }

    @Override
    public void insert(String tableName, String[] row) {
        StringBuilder s = new StringBuilder();
        s.append("Table ").append(tableName).append(" inserted row (");
        for (int i = 0; i < row.length; ++i) {
            if (i < row.length - 1) {
                s.append(row[i]).append(", ");
            } else {
                s.append(row[i]);
            }
        }
        s.append(")");
        log.info(s.toString());

        super.insert(tableName, row);
    }

    @Override
    public DBTable select(String tabName, int col, String selector) {
        log.info("Selected table " + tabName + " with column " + col + " by selector " + selector);

        return super.select(tabName, col, selector);
    }

    @Override
    public DBTable join(String tab1Name, String tab2Name, int tab1Col, int tab2Col) {
        log.info("Joined table " + tab1Name + " and " + tab2Name + " with column " + tab1Col + " in table 1 and column " + tab2Col + " in table 2");

        return super.join(tab1Name, tab2Name, tab1Col, tab2Col);
    }
}
