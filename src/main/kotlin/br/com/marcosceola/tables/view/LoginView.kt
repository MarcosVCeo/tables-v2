package br.com.marcosceola.tables.view

import com.vaadin.flow.component.login.LoginForm
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed

@PageTitle("Login")
@Route("login")
@AnonymousAllowed
class LoginView : VerticalLayout() {

    val loginForm: LoginForm

    init {
        this.alignItems = FlexComponent.Alignment.CENTER

        loginForm = LoginForm()
        loginForm.action = "login"

        add(loginForm)
    }
}