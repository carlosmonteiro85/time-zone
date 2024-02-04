package br.com.acme.fakeecomerce.timezone.util;

import java.math.BigDecimal;

public class AppConstantes {

	private static final String RESOURCES = "resources";
    public static final String ABSOLUT_PATH = System.getProperty("user.dir");
    public static final String SEPARADOR = System.getProperty("file.separator");
    public static final String PATH_IMAGES =  new StringBuilder(ABSOLUT_PATH)
    		.append(SEPARADOR).append("src").append(SEPARADOR)
    		.append(RESOURCES).append(SEPARADOR).append("static")
    		.append(SEPARADOR).append("assets").append(SEPARADOR)
    		.append("img").append(SEPARADOR).toString();

    public static final String ITEM_CART = "cartQuantidade";
    public static final String CHECKOUT = "checkout";
    public static final String CART = "cart";
    public static final String PRODUTOS = "produtos";
    
    public static final String NF_GERADA = new StringBuilder(ABSOLUT_PATH)
    		.append(SEPARADOR).append("src").append(SEPARADOR).append("main").append(SEPARADOR)
            .append(RESOURCES).append(SEPARADOR).append("templates").append(SEPARADOR).toString();
    
    public static final String NF_MODEL = new StringBuilder(NF_GERADA).append("nfe.html").toString();
    
    public static final BigDecimal FRETE_GRATUITO = new BigDecimal(3000);
    
    // paginas
    public static final String PAGE_PRODUTOS = "shop";
    public static final String CONTATOS = "contact";
    public static final String PAGE_PRODUTO = "product_details";
    public static final String FINALIZACAO = "confirmation";
    public static final String REDIRECT_CART = "redirect:/cart";
}

