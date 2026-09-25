package task16;
public interface ICloudBlobStorage {
    boolean uploadBlob(String bucketName, String objectKey, byte[] data);
}