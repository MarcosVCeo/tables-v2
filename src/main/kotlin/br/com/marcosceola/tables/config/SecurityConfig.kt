package br.com.marcosceola.tables.config

import br.com.marcosceola.tables.view.LoginView
import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager

@EnableWebSecurity
@Configuration
class SecurityConfig : VaadinWebSecurity() {

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        setLoginView(http, LoginView::class.java)
    }

    @Bean
    fun userDetailsManager(): UserDetailsManager = InMemoryUserDetailsManager(
        User
            .withUsername("admin")
            .password("123")
            .roles("ADMIN")
            .build()
    )
}