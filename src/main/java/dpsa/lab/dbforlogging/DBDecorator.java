package dpsa.lab.dbforlogging;

public abstract class DBDecorator extends DBStorage {
    private DBStorage database;

    public DBDecorator(DBStorage database) {
        this.database = database;
    }

    @Override
    public void createTable(String name, int columns) {
        database.createTable(name, columns);
    }

    @Override
    public void insert(String tableName, String[] row) {
        database.insert(tableName, row);
    }

    @Override
    public DBTable select(String tabName, int col, String selector) {
        return database.select(tabName, col, selector);
    }

    @Override
    public DBTable join(String tab1Name, String tab2Name, int tab1Col, int tab2Col) {
        return database.join(tab1Name, tab2Name, tab1Col, tab2Col);
    }

    @Override
    public DBTable getTable(String name) {
        return database.getTable(name);
    }
}
