package br.com.marcosceola.tables.view

import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.login.LoginForm
import com.vaadin.flow.component.login.LoginI18n
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.router.BeforeEnterEvent
import com.vaadin.flow.router.BeforeEnterObserver
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed
import jakarta.servlet.http.HttpServletRequest

@PageTitle("Login")
@Route("login")
@CssImport("./login_style.css")
@AnonymousAllowed
class LoginView(
    private val request: HttpServletRequest
) : MainView(request), BeforeEnterObserver {

    val loginForm: LoginForm

    init {
        this.alignItems = FlexComponent.Alignment.CENTER
        loginForm = LoginForm(criarLoginI18()).apply { action = "login" }
        loginForm.addClassName("login-form")

        add(loginForm)
    }

    private fun criarLoginI18(): LoginI18n = LoginI18n.createDefault().apply {
        form.title = "Login"
        form.submit = "Entrar"
        form.forgotPassword = "Esqueci minha senha"
        form.username = "Usuário"
        form.password = "Senha"

        errorMessage.title = "Usuário ou senha inválidos"
        errorMessage.message = "Verifique se o usuário e a senha informados estão corretos"
        errorMessage.username = "Usuário obrigatório"
        errorMessage.password = "Senha obrigatória"
    }

    override fun beforeEnter(event: BeforeEnterEvent) {
        val possuiEventoDeErro = event
            .location
            .queryParameters
            .parameters
            .containsKey("error")

        if (possuiEventoDeErro) {
            loginForm.isError = true
        }
    }
}