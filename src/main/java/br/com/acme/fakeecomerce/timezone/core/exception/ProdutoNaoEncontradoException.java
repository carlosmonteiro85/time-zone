package br.com.acme.fakeecomerce.timezone.core.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public String msn;
	
	public ProdutoNaoEncontradoException(String msn) {
		super();
		this.msn = msn;
	} 
}
