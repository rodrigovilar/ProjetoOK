package Entidades;

public class Funcionario extends Pessoa {
	
	public Funcionario(){
		
	}

		private String id;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}

		private String banco;
		private String agencia;
		private int contacorrente;
		private int salario;
		
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
		public int getSalario() {
			return salario;
		}
		public void setSalario(int salario) {
			this.salario = salario;
		}

}
