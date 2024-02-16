package br.com.marcosceola.tables.config

import br.com.marcosceola.tables.service.UsuarioService
import br.com.marcosceola.tables.view.LoginView
import com.vaadin.flow.spring.security.VaadinWebSecurity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
@Configuration
class SecurityConfig(@Autowired val usuarioService: UsuarioService) : VaadinWebSecurity() {

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        setLoginView(http, LoginView::class.java)
    }

    override fun configure(web: WebSecurity?) {
        web!!.ignoring().requestMatchers("/images/**", "/logo.png")
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider = DaoAuthenticationProvider(encoder()).apply {
        setUserDetailsService(usuarioService)
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()
}