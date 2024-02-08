package br.com.marcosceola.tables.view

import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.auth.AnonymousAllowed
import jakarta.servlet.http.HttpServletRequest

@Route("")
@PageTitle("Home")
@AnonymousAllowed
class HomeView(private val request: HttpServletRequest) : MainView(request)