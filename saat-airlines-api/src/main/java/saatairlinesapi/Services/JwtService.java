package saatairlinesapi.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String createJwtToken(String email) {
        long expirationTime = 86400000; // 24 saat
        String jwtToken = Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey)
                .compact();
        return jwtToken;
    }

    public boolean isJwtTokenValid(String jwtToken, String email) {
        System.out.println("token mail : " + email);
        System.out.println("token jwtToken : " + jwtToken);

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();

            String tokenEmail = claims.getSubject();

            // Tokenin içerisindeki email'i kontrol et
            if (!email.equals(tokenEmail)) {
                return false;
            }
            return true; // Token geçerli ise true döndürülür
        } catch (Exception e) {
            // JWT tokeni geçersiz veya doğrulama hatası oluştu
            return false;
        }
    }

}
