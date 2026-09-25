package task03;
public class StudentDirectoryAdapter implements IModernDirectory {
    private final LegacyStudentDirectory legacyStudentDirectory;
    public StudentDirectoryAdapter(LegacyStudentDirectory legacyStudentDirectory) {
        this.legacyStudentDirectory = legacyStudentDirectory;
    }
    @Override
    public int size() {
        return legacyStudentDirectory.totalEntries();
    }
    @Override
    public String get(int zeroBasedIndex) {
        if (zeroBasedIndex < 0 || zeroBasedIndex >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + zeroBasedIndex);
        }
        return legacyStudentDirectory.getStudentAt(zeroBasedIndex + 1);
    }
}