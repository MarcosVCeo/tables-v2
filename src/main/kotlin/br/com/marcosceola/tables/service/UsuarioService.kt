package br.com.marcosceola.tables.service

import br.com.marcosceola.tables.exception.UsuarioException
import br.com.marcosceola.tables.model.Usuario
import br.com.marcosceola.tables.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UsuarioService(@Autowired private val usuarioRepository: UsuarioRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): Usuario = usuarioRepository
        .findUserByUsername(username)
        .orElseThrow { UsuarioException("Não foi possível encontrar o usuario com o username $username") }
}