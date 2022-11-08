package br.com.acme.fakeecomerce.timezone.util;

import lombok.Getter;

@Getter
public class AppConstantes {
	// assets/img/gallery/popular1.png
	public static final String ABSOLUT_PATH = System.getProperty("user.dir");
	public static final String SEPARADOR = System.getProperty("file.separator");
	public static final String PATH_IMAGES = System.getProperty("user.dir") + SEPARADOR + "src" + SEPARADOR
			+ "resources" + SEPARADOR + "static" + SEPARADOR + "assets" + SEPARADOR + "img" + SEPARADOR;
// //home/carlos-monteiro/desenvolvimento/prototipo/time-zone/src/main/resources/static/assets/img/gallery
	public static final String ITEM_CART =  "cartQuantidade";
}
