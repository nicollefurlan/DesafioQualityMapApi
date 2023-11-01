package br.com.nfsb.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.com.nfsb.rest.core.BaseTest;
import br.com.nfsb.utils.UserCreate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CasesTestUsers extends BaseTest {

	private static String USER_ID;
	private static String CONTA_NAME = "User" + System.nanoTime();
	private static String CONTA_EMAIL = "Conta@" + System.nanoTime() + ".com";

	@Test
	public void t05_deveInserirUsuariocomSucesso() {
		UserCreate user = createNewUser();

		USER_ID = given()

				.body(user).when().post("/usuarios").then().statusCode(201).extract().path("_id");
	}

	@Test
	public void t06_consultarPorId() {

		given()

				.pathParam("_id", USER_ID)

				.when().get("/usuarios/{_id}").then().statusCode(200);
	}

	@Test
	public void t07_deveAtualizarComSucesso() {

		UserCreate user = createNewUser();

		given().pathParam("_id", USER_ID).body(user).log().all().when().put("/usuarios/{_id}")

				.then()

				.statusCode(200);
	}

	@Test
	public void t08_DeletePorId() {

		given().pathParam("_id", USER_ID)

				.when().delete("/usuarios/{_id}").then().statusCode(200)
				.body("message", is("Registro excluído com sucesso"));
	}

	private UserCreate createNewUser() {

		UserCreate user = new UserCreate();
		user.setNome(CONTA_NAME);
		user.setPassword("Teste");
		user.setEmail(CONTA_EMAIL);
		user.setAdministrador("true");
		return user;
	}

}
