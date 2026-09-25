package task16;
public class LocalStorageBlobAdapter implements ICloudBlobStorage {
    private final LocalDiskFileSystem localDiskFileSystem;
    public LocalStorageBlobAdapter(LocalDiskFileSystem localDiskFileSystem) {
        this.localDiskFileSystem = localDiskFileSystem;
    }
    @Override
    public boolean uploadBlob(String bucketName, String objectKey, byte[] data) {
        String rawPath = "/var/data/" + bucketName + "/" + objectKey;
        String sanitizedPath = rawPath.replaceAll("/{2,}", "/");
        return localDiskFileSystem.saveToPath(sanitizedPath, data);
    }
}