package br.com.acme.fakeecomerce.timezone.core.exception;

public class ErrorInfo {
	public final String url;
	public final String ex;

	public ErrorInfo(String url, RuntimeException ex) {
		this.url = url;
		this.ex = ex.getLocalizedMessage();
	}
}
