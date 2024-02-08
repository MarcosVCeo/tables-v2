package br.com.marcosceola.tables.config

import br.com.marcosceola.tables.view.LoginView
import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@EnableWebSecurity
@Configuration
class SecurityConfig : VaadinWebSecurity() {

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        setLoginView(http, LoginView::class.java)
    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().requestMatchers("/images/**", "/logo.png")
    }

    @Bean
    fun userDetailsManagerBean(): UserDetailsManager = InMemoryUserDetailsManager(
        User
            .withUsername("admin")
            .password("\$2a\$10\$utX3XRviLbJwnNeX0CgTd.eSsQFQSpCq3B4XkhXCnhZDujEAKuzUa")
            .roles("ADMIN")
            .build()
    )

    @Bean
    fun encoderBean(): PasswordEncoder = BCryptPasswordEncoder()
}