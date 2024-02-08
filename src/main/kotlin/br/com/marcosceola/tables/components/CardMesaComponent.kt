package br.com.marcosceola.tables.components

import br.com.marcosceola.tables.model.Mesa
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout

@CssImport(value = "card_mesa_component_style.css")
class CardMesaComponent(mesa: Mesa) : VerticalLayout() {

    private val imagem: Image
    private val titulo: H2
    private val descricao: Div
    private val compartilharButton: Button
    private val vejaMaisButton: Button
    private val areaHorizontalTituloBotoes: HorizontalLayout

    init {
        this.addClassName("card-mesa")

        titulo = criarTitulo(mesa.nome)
        imagem = criarImagem(mesa.linkImagem)
        descricao = criarDescricao(mesa.descricao)
        compartilharButton = criarBotaoCompartilhar()
        vejaMaisButton = criarBotaoVejaMais()
        areaHorizontalTituloBotoes = criarAreaHorizontalTituloBotoes()

        add(imagem, areaHorizontalTituloBotoes, descricao)
    }

    private fun criarTitulo(titulo: String): H2 {
        val titulo = H2(titulo)
        titulo.setClassName("titulo-card-mesa")

        return titulo
    }

    private fun criarImagem(linkImagem: String): Image {
        val imagem = Image(linkImagem, "Imagem")
        imagem.setClassName("card-mesa-image")

        return imagem
    }

    private fun criarDescricao(descricao: String): Div {
        val descricao = Div(descricao)
        descricao.setClassName("card-mesa-descricao")

        return descricao
    }

    private fun criarBotaoCompartilhar(): Button {
        val button = Button("Compartilhar")
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY)

        return button
    }

    private fun criarBotaoVejaMais(): Button {
        val button = Button("Veja mais...")
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SUCCESS)

        return button
    }

    private fun criarAreaHorizontalTituloBotoes(): HorizontalLayout {
        val areaHorizontalTituloBotoes = HorizontalLayout(titulo, HorizontalLayout(compartilharButton, vejaMaisButton))
        areaHorizontalTituloBotoes.setClassName("card-mesa-titulo-botoes")

        return areaHorizontalTituloBotoes
    }
}