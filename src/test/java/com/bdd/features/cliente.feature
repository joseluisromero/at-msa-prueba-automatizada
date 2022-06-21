@Test
Feature: GESTION CLIENTES
  Procedimiento de administración de la pantalla de clientes

  Background: Ingresar al modulo de clientes
    Given El usuario navega a la pagina de clientes

  Scenario Outline: Filtra y actualiza los datos de un cliente
    When filtramos identificacion <cedula>
    And registramos los datos a modificar
    And click en el boton guardar
    Then muestra el mensaje del proceso
    Examples:
      | cedula     |
      | 1711263895 |


  Scenario: Registrar un cliente nuevo
    When damos click nuevo cliente
    And registramos los datos del nuevo cliente
    And damos click en el boton guardar nuevo cliente
    Then Se muestra el mensaje de registros creado


  Scenario Outline: Eliminar un cliente
    When filtramos el registro eliminar <cedula>
    And damos click en el boton eliminar
    Then Se muestra el mensaje de registros eliminado
    Examples:
      | cedula     |
      | 1750901595 |
