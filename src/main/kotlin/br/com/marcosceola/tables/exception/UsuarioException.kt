package br.com.marcosceola.tables.exception

class UsuarioException(override val message: String, override val cause: Throwable?) : Exception(message, cause) {
    constructor(message: String) : this(message, null)
}