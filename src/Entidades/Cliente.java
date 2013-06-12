package Entidades;

public class Cliente extends Pessoa {
	
	public Cliente(){
		
	}

	private String cpf;
	private String categoria;
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	private int cartaoFidelidade;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCartaoFidelidade() {
		return cartaoFidelidade;
	}
	public void setCartaoFidelidade(int cartaoFidelidade) {
		this.cartaoFidelidade = cartaoFidelidade;
	}
}
