package task05;
public record UserProfile(int id, String fullName, String role) {}
public interface IUserSource {
    UserProfile getNextUser();
}