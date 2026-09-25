package task06;
public class DatabaseAdapter implements IRepository {
    private final LegacyDatabaseConnection legacyDatabaseConnection;
    public DatabaseAdapter(LegacyDatabaseConnection legacyDatabaseConnection) {
        this.legacyDatabaseConnection = legacyDatabaseConnection;
    }
    @Override
    public String findById(int id) throws RecordNotFoundException, DatabaseLockedException {
        String[] outBuffer = new String[1];
        int resultCode = legacyDatabaseConnection.executeFetch(id, outBuffer);
        if (resultCode == -1) {
            throw new RecordNotFoundException("Record not found for id: " + id);
        }
        if (resultCode == -2) {
            throw new DatabaseLockedException("Database is locked for id: " + id);
        }
        return outBuffer[0];
    }
}