package task06;
public interface IRepository {
    String findById(int id) throws RecordNotFoundException, DatabaseLockedException;
}