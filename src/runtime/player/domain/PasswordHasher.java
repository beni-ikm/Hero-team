package runtime.player.domain;

public interface PasswordHasher {
    String hash(String rawPassword);
    boolean matches(String rawPassword, String encodedHash);
}
