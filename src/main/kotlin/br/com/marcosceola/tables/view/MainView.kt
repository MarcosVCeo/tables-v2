package br.com.marcosceola.tables.view

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Nav
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.RouterLink
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

@CssImport("./styles.css")
abstract class MainView(private val request: HttpServletRequest) : VerticalLayout() {

    private val nav: Nav
    private val imagemLogo: Image
    private val logoRouterLink: RouterLink
    private val mainTitleTables: H1
    private val routerLinkTituloPrincipal: RouterLink
    private val subTituloMesas: H2
    private val routerLinkSubTituloMesas: RouterLink
    private val logoutButton: Button

    init {
        this.addClassName("main-vertical-layout")

        mainTitleTables = criarMainTitle()
        imagemLogo = criarImagemLogo()
        logoRouterLink = criarRouterLinkLogo()
        routerLinkTituloPrincipal = criarRouterLinkMainTitle(mainTitleTables)
        subTituloMesas = criarTablesSubTitle()
        routerLinkSubTituloMesas = criarRouterLinkTablesSubTitle(subTituloMesas)
        logoutButton = criarLogoutButton()

        val areaNavBar = HorizontalLayout(HorizontalLayout(routerLinkTituloPrincipal, routerLinkSubTituloMesas), logoutButton)
        areaNavBar.addClassName("area-nav-bar")

        nav = criarNavBar(logoRouterLink, areaNavBar)

        add(nav)
    }

    private fun criarMainTitle(): H1 {
        val h1 = H1("Tables")
        h1.addClassName("main-title")

        return h1
    }

    private fun criarNavBar(vararg components: Component): Nav {
        val nav = Nav()
        nav.addClassName("nav-bar")
        components.forEach { nav.add(it) }

        return nav
    }

    private fun criarImagemLogo(): Image {
        val image = Image("images/logo.png", "Vaadin Logo")
        image.addClassName("logo")

        return image
    }

    private fun criarRouterLinkLogo(): RouterLink {
        RouterLink(HomeView::class.java)
        logoRouterLink.add(imagemLogo)

        return logoRouterLink
    }

    private fun criarRouterLinkMainTitle(mainTitle: H1): RouterLink {
        val routerLink = RouterLink(HomeView::class.java)
        routerLink.setClassName("main-title")
        routerLink.add(mainTitle)

        return routerLink
    }

    private fun criarTablesSubTitle(): H2 {
        val h2 = H2("Mesas")
        h2.setClassName("sub-title-nav")

        return h2
    }

    private fun criarRouterLinkTablesSubTitle(tablesSubTitle: H2): RouterLink {
        val routerLink = RouterLink(MesasView::class.java)
        routerLink.addClassName("sub-title-nav")
        routerLink.add(tablesSubTitle)

        return routerLink
    }

    private fun criarLogoutButton(): Button {
        val button = Button("Logout")
        val autenticacao = SecurityContextHolder.getContext().authentication
        val estaAutenticado = autenticacao != null &&
                autenticacao.isAuthenticated &&
                autenticacao.principal is UserDetails

        button.isVisible = estaAutenticado

        button.addClickListener { event -> request.session!!.invalidate() }

        return button
    }
}