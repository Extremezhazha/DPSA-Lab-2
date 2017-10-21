package dpsa.lab.dbforlogging;

public abstract class DBStorage {
    public abstract void createTable(String name, int columns);
    public abstract void insert(String tableName, String[] row);
    public abstract DBTable select(String tabName, int col, String selector);
    public abstract DBTable join(String tab1Name, String tab2Name, int tab1Col, int tab2Col);
    public abstract DBTable getTable(String name);
}
