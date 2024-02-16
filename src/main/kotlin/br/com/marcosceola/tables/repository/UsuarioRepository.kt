package br.com.marcosceola.tables.repository

import br.com.marcosceola.tables.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long?> {

    fun findUserByUsername(username: String): Optional<Usuario>

}