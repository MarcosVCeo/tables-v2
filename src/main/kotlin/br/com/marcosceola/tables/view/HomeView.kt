package br.com.marcosceola.tables.view

import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import jakarta.annotation.security.PermitAll

@Route("")
@PageTitle("Home")
@PermitAll
class HomeView : MainView() {


}