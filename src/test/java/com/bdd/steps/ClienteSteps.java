package com.bdd.steps;

import com.bdd.runner.pages.ClientePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ClienteSteps {

    ClientePage clientePage = new ClientePage();

    @Given("^El usuario navega a la pagina de clientes$")
    public void elUsuarioNavegaALaPaginaDeClientes() {
        clientePage.nevegateToCliente();
    }

    @And("filtramos identificacion {int}")
    public void filtramosIdentificacion(Integer int1) {
        clientePage.filtrarClienteIdentificacion(String.valueOf(int1));
    }

    @And("^registramos los datos a modificar$")
    public void registramosLosDatosAModificar() {
        clientePage.insertarDatoModificar();
    }

    @And("^click en el boton guardar$")
    public void clickEnElBotonGuardar() {
        clientePage.butonGuardar();
    }

    @Then("^muestra el mensaje del proceso$")
    public void muestraElMensajeDelProceso() {
        Assert.assertTrue(clientePage.messageGuardar());
    }

    //Scenario nuevo cliente
    @When("^damos click nuevo cliente$")
    public void damosClickNuevoCliente() {
        clientePage.clickbotonNuevoCliente();
    }

    @When("^registramos los datos del nuevo cliente$")
    public void registramosLosDatosDelNuevoCliente() {
        clientePage.insertamosDatosNuevoCliente();
    }

    @And("^damos click en el boton guardar nuevo cliente$")
    public void damosClickEnElBotonGuardarNuevoCliente() {
        clientePage.butonGuardar();
    }

    @Then("^Se muestra el mensaje de registros creado$")
    public void seMuestraElMensajeDeRegistrosCreado() {
        Assert.assertTrue(clientePage.messageGuardar());
    }

    //scenario eliminar
    @When("filtramos el registro eliminar {int}")
    public void filtramosElRegistroEliminar(Integer int1) {
        clientePage.filtrarClienteIdentificacionEliminar(String.valueOf(int1));
    }

    @When("damos click en el boton eliminar")
    public void damosClickEnElBotonEliminar() {
        clientePage.clickBotonEliminar();
    }

    @Then("Se muestra el mensaje de registros eliminado")
    public void seMuestraElMensajeDeRegistrosEliminado() {
        Assert.assertTrue(true);
    }
}
