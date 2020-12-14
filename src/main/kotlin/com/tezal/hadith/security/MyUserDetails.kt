package com.tezal.hadith.security

import com.tezal.hadith.repo.UserRepo
import org.springframework.security.core.userdetails.UserDetailsService
import kotlin.Throws
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service

@Service
class MyUserDetails(private val userRepository: UserRepo) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val (_, password, _, _, roles) = userRepository.findByUserName(username)
        return User //
                .withUsername(username) //
                .password(password) //
                .authorities(roles) //
                .accountExpired(false) //
                .accountLocked(false) //
                .credentialsExpired(false) //
                .disabled(false) //
                .build()
    }
}