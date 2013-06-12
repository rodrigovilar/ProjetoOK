package Controle;

import java.util.ArrayList;
import java.util.List;

import Entidades.Cliente;
import Excecao.ExceptionGerenciadorCliente;

public class GerenciadorCliente {

	private List<Cliente> clientes;

	public GerenciadorCliente() {

		clientes = new ArrayList<Cliente>();

	}

	public void cadastrar(Cliente cliente) {
		clientes.add(cliente);

	}

	public Cliente getCliente(Cliente cliente)
			throws ExceptionGerenciadorCliente {
		for (Cliente c : clientes) {
			if (c.equals(cliente)) {
				return c;
			}
		}
		throw new ExceptionGerenciadorCliente("Cliente não cadastrado");
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Cliente pesquisarClientePorCpf(String cpf)	throws ExceptionGerenciadorCliente {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equals(cpf))
				return cliente;
		}
		return null;
	}

	public Cliente pesquisarClientePorNome(String nome)
			throws ExceptionGerenciadorCliente {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome))
				return cliente;
		}
		return null;
	}

	public Cliente pesquisaClientePorCategoria(String categoria) throws ExceptionGerenciadorCliente {
		for (Cliente cliente : clientes) {
			if (cliente.getCategoria().equals(categoria))
				return cliente;
		}
		return null;
	
}
	public boolean removeCliente(Cliente cliente)
			throws ExceptionGerenciadorCliente {
		for (Cliente c : clientes) {
			if (c.equals(cliente))
				;
			return clientes.remove(cliente);
		}
		throw new ExceptionGerenciadorCliente("Lista Nao Possui Cliente");
	}

	

	// public Cliente getCliente(String nome) throws ExceptionGerentePessoa{
	// for (Cliente c : clientes) {
	// if (c.getNome().equalsIgnoreCase(nome)) {
	// return c;
	// }
	// }
	// throw new ExceptionGerentePessoa("Cliente não cadastrado");
	// }

	// public Object getBuscarCliente() {
	// return BuscarCliente;
	// }

	//
	// public void setBuscarCliente(Object buscarCliente) {
	// BuscarCliente = buscarCliente;
	// }

	// private boolean contemCliente(String nome) {
	// for (Cliente c : clientes) {
	// if (c.getNome().contains(nome)) {
	// return true;
	// }
	// }
	// return false;
	// }
	//
	// public boolean addCliente(Cliente cliente) {
	// if (!contemCliente(cliente.getNome())) {
	// return clientes.add(cliente);
	// }
	// return false;
	// }
	//
	//
	//
	//
	// public Cliente pegaClientePorCpf(String cpf) throws ExceptionGerenciaRH {
	// for (Cliente cliente : clientes) {
	// if (cliente.getCpf().equals(cpf)) {
	// return cliente;
	// }
	// }
	// throw new ExceptionGerenciaRH("Cliente nao Existe");
	// }
	//
	// public Cliente pegaClientePorNome(String nome) throws
	// ExceptionGerenciaRH{
	// for(Cliente cliente : clientes){
	// if(cliente.getNome().equalsIgnoreCase(nome)){
	// return cliente;
	// }
	// }
	// throw new ExceptionGerenciaRH("Nao Existe Esta pessoa");
	// }
	//
	// public boolean removeClientePorNome(String nome)throws
	// ExceptionGerenciaRH {
	// return clientes.remove(pegaClientePorNome(nome));
	//
	// }
	// public boolean removeClientePorCpf(String cpf) throws ExceptionGerenciaRH
	// {
	// return clientes.remove(cpf);
	// }
	//
	// public int tamanhoListaCliente() {
	// return clientes.size();
	// }
	//
	// public List<Cliente> getClientes() {
	// return clientes;
	// }
	//
	// public void setClientes(List<Cliente> clientes) {
	// this.clientes = clientes;
	// }
	//
	//

}
