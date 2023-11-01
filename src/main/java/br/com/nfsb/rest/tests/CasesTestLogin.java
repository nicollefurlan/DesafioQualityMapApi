package br.com.nfsb.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import java.util.HashMap;
import java.util.Map;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.hamcrest.Matchers.*;
import br.com.nfsb.rest.core.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CasesTestLogin extends BaseTest {

	private static String EMAIL_USER;
	private static String PASSWORD_USER;

	@Test
	public void t01_deveConsultarEmailDoPrimeiroUsuario() {
		EMAIL_USER = given().when().get("/usuarios").then().statusCode(200)
				.body("usuarios[1].email", is(notNullValue())).extract().path("usuarios[1].email");
	}

	@Test
	public void t02_deveConsultarSenhaDoPrimeiroUsuario() {
		PASSWORD_USER = given().when().get("/usuarios").then().body("usuarios[1].password", is(notNullValue()))
				.statusCode(200).extract().path("usuarios[1].password");
	}

	@Test
	public void t03_deveLogarUtlizandoPrimeiroUsuario() {

		Map<String, String> login = new HashMap<String, String>();

		login.put("email", EMAIL_USER);
		login.put("password", PASSWORD_USER);

		String TOKEN = given()

				.body(login).contentType(ContentType.JSON).when().post("/login").then().statusCode(200)
				.body("message", is("Login realizado com sucesso")).extract().path("token");

		RestAssured.requestSpecification.header("Authorization", "Bearer" + TOKEN);

	}

	@Test
	public void t04_ValidarlErroLoginUsuarioInvalido() {

		Map<String, String> login = new HashMap<String, String>();

		login.put("email", "errado");
		login.put("password", "errado");

		given().body(login).contentType(ContentType.JSON).when().post("/login").then().statusCode(400);

	}

}
