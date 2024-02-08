package br.com.marcosceola.tables.view

import br.com.marcosceola.tables.components.CardMesaComponent
import br.com.marcosceola.tables.model.Mesa
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route
import jakarta.annotation.security.PermitAll

@Route("/tables")
@PermitAll
class MesasView : MainView() {

    private val mesas = mutableListOf<Mesa>()

    val cards: VerticalLayout

    init {
        cards = VerticalLayout()
        mesas.add(
            Mesa(
                nome = "Table 1",
                linkImagem = "https://miro.medium.com/v2/resize:fit:1400/1*N0icESJYaWzTvDWtucesAw.png",
                descricao = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )
        mesas.add(
            Mesa(
                nome = "Table 1",
                linkImagem = "https://miro.medium.com/v2/resize:fit:1400/1*N0icESJYaWzTvDWtucesAw.png",
                descricao = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publipublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublispublisshing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )
        mesas.add(
            Mesa(
                nome = "Table 1",
                linkImagem = "https://miro.medium.com/v2/resize:fit:1400/1*N0icESJYaWzTvDWtucesAw.png",
                descricao = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )
        mesas.add(
            Mesa(
                nome = "Table 1",
                linkImagem = "https://miro.medium.com/v2/resize:fit:1400/1*N0icESJYaWzTvDWtucesAw.png",
                descricao = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )
        mesas.add(
            Mesa(
                nome = "Table 1",
                linkImagem = "https://miro.medium.com/v2/resize:fit:1400/1*N0icESJYaWzTvDWtucesAw.png",
                descricao = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )

        mesas.forEach { criarCard(it) }

        cards.style
            .set("align-items", "center")

        add(cards)
    }

    private fun criarCard(mesa: Mesa) {
        val card = CardMesaComponent(mesa)

        cards.add(card)
    }
}