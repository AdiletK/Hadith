package com.tezal.hadith.security

import com.tezal.hadith.enums.RoleList
import com.tezal.hadith.exception.CustomException
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider {
    /**
     * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
     * microservices environment, this key would be kept on a config-server.
     */
    @Value("\${security.jwt.token.secret-key:secret-key}")
    private var secretKey: String? = null

    @Value("\${security.jwt.token.expire-length:36000000}")
    private val validityInMilliseconds: Long = 36000000 // 10h

    @Autowired
    private val myUserDetails: MyUserDetails? = null
    @PostConstruct
    protected fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey!!.toByteArray())
    }

    fun createToken(username: String?, roles: List<RoleList>): String {
        val claims = Jwts.claims().setSubject(username)
        claims["auth"] = roles.stream().map { s: RoleList -> SimpleGrantedAuthority(s.authority) }.filter { o: SimpleGrantedAuthority? -> Objects.nonNull(o) }.collect(Collectors.toList())
        val now = Date()
        val validity = Date(now.time + validityInMilliseconds)
        return Jwts.builder() //
                .setClaims(claims) //
                .setIssuedAt(now) //
                .setExpiration(validity) //
                .signWith(SignatureAlgorithm.HS256, secretKey) //
                .compact()
    }

    fun getAuthentication(token: String?): Authentication {
        val userDetails = myUserDetails!!.loadUserByUsername(getUsername(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun getUsername(token: String?): String {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }

    fun validateToken(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            true
        } catch (e: JwtException) {
            throw CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: IllegalArgumentException) {
            throw CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}