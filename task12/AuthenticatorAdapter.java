package task12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class AuthenticatorAdapter implements IModernAuthenticator {
    private final LegacyAuthService legacyAuthService;
    public AuthenticatorAdapter(LegacyAuthService legacyAuthService) {
        this.legacyAuthService = legacyAuthService;
    }
    @Override
    public boolean login(String username, String plainTextPassword) {
        String hexHash = hashToMd5Hex(plainTextPassword);
        return legacyAuthService.authenticateUserHex(username, hexHash);
    }
    private String hashToMd5Hex(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(plainText.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }
}