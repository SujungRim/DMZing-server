package com.walkd.dmzing.auth.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.walkd.dmzing.auth.UserDetailsImpl;
import com.walkd.dmzing.util.JwtUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String token) {
        DecodedJWT decodedJWT = JwtUtil.tokenToJwt(token);

        if (decodedJWT == null) {
            throw new BadCredentialsException("Not used Token");
        }

        String id = decodedJWT.getClaim("email").asString();
        String role = decodedJWT.getClaim("role").asString();

        return new UserDetailsImpl(id, AuthorityUtils.createAuthorityList(role));
    }
}
