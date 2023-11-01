package br.com.nfsb.rest.core;

import io.restassured.http.ContentType;

public interface Constantes {

	String APP_BASE_URL = "https://serverest.dev";
	String APP_BASE_PATH = "";
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMEOUT = 13000L;

}
