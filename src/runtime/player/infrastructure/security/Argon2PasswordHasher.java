package runtime.player.infrastructure.security;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import runtime.player.domain.PasswordHasher;

import java.util.Objects;

import static runtime.player.domain.PlayerPassword.invalidPassword;

public class Argon2PasswordHasher implements PasswordHasher {

    private static final int DEFAULT_ITERATION = 3;
    private static final int DEFAULT_MEMORY_KB = 65536; // 64 MiB
    private static final int DEFAULT_PARALLELISM = 1;

    private static final String NOT_NULL_MSG = "rawPassword must not be null";

    private final Argon2 argon2;
    private final int iterations;
    private final int memoryKb;
    private final int parallelism;

    public Argon2PasswordHasher() {
        this(DEFAULT_ITERATION, DEFAULT_MEMORY_KB, DEFAULT_PARALLELISM);
    }

    public Argon2PasswordHasher(int iterations, int memoryKb, int parallelism) {
        this.iterations = iterations;
        this.memoryKb = memoryKb;
        this.parallelism = parallelism;
        this.argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
    }

    @Override
    public String hash(String rawPassword) {
        Objects.requireNonNull(rawPassword, NOT_NULL_MSG);
        char[] passwordChars = rawPassword.toCharArray();
        try {
            return argon2.hash(iterations, memoryKb, parallelism, passwordChars);
        } finally {
            argon2.wipeArray(passwordChars);
        }
    }

    @Override
    public boolean matches(String rawPassword, String encodedHash) {
        if(invalidPassword(rawPassword)) {
            return false;
        }
        char[] passwordChars = rawPassword.toCharArray();
        try {
            return argon2.verify(encodedHash, passwordChars);
        } finally {
            argon2.wipeArray(passwordChars);
        }
    }

}
