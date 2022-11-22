package br.com.acme.fakeecomerce.timezone.util;

public class AppConstantes {

    public static final String ABSOLUT_PATH = System.getProperty("user.dir");
    public static final String SEPARADOR = System.getProperty("file.separator");
    public static final String PATH_IMAGES = System.getProperty("user.dir") + SEPARADOR + "src" + SEPARADOR
            + "resources" + SEPARADOR + "static" + SEPARADOR + "assets" + SEPARADOR + "img" + SEPARADOR;

    public static final String ITEM_CART = "cartQuantidade";
    public static final String CHECKOUT = "checkout";
    public static final String NF_MODEL = ABSOLUT_PATH + SEPARADOR + "src" + SEPARADOR + "main" + SEPARADOR
            + "resources" + SEPARADOR + "templates" + SEPARADOR +"nfe.html";
    public static final String NF_GERADA = ABSOLUT_PATH + SEPARADOR + "src" + SEPARADOR + "main" + SEPARADOR
            + "resources" + SEPARADOR + "templates" + SEPARADOR;
}
