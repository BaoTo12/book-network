package edu.chibao.profile.config;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Instant;

@Component
public class CustomJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            return new Jwt(
                    token,
                    Instant.ofEpochMilli(signedJWT.getJWTClaimsSet().getIssueTime().getTime()),
                    Instant.ofEpochMilli(signedJWT.getJWTClaimsSet().getExpirationTime().getTime()),
                    signedJWT.getHeader().toJSONObject(),
                    signedJWT.getJWTClaimsSet().toJSONObject()
            );
            } catch (ParseException e) {
            throw new JwtException("Invalid Token");
        }

    }
}
