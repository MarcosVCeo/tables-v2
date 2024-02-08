package br.com.marcosceola.tables.model

import jakarta.persistence.*

@Table(name = "mesas")
@Entity
class Mesa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var nome: String,

    @Column
    var linkImagem: String,

    @Column
    var descricao: String
)