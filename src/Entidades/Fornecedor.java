package Entidades;

public class Fornecedor extends Pessoa {

	public Fornecedor() {

	}

	private String cnpj;
	private String id;
	private String websites;
	private String banco;
	private String agencia;
	private int contacorrente;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWebsites() {
		return websites;
	}

	public void setWebsites(String websites) {
		this.websites = websites;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getContacorrente() {
		return contacorrente;
	}

	public void setContacorrente(int contacorrente) {
		this.contacorrente = contacorrente;
	}

}
