package Fachada;

import java.util.List;

import Controle.GerenciadorCliente;
import Controle.GerenciadorFornecedor;
import Controle.GerenciadorFuncionario;
import Entidades.Cliente;
import Entidades.Fornecedor;
import Entidades.Funcionario;

import Excecao.ExceptionGerenciadorCliente;
import Excecao.ExceptionGerenciadorFornecedor;
import Excecao.ExceptionGerenciadorFuncionario;

public class Loja {

	GerenciadorFornecedor gFornecedor = new GerenciadorFornecedor();
	GerenciadorFuncionario gFunc = new GerenciadorFuncionario();
	GerenciadorCliente gCliente = new GerenciadorCliente();

	public void cadastrar(Cliente cliente) {
		gCliente.cadastrar(cliente);
	}

	public void cadastrar(Fornecedor fornecedor) {
		gFornecedor.cadastrar(fornecedor);
	}
	public void cadastrar(Funcionario funcionario1) {
		gFunc.cadastrar(funcionario1);
		
	}

	public List<Cliente> listarClientes() {
		return gCliente.getClientes();
	}

	public List<Fornecedor> listarFornecedor() {
		return gFornecedor.getFornecedores();
	}

	public List<Funcionario> listarFuncionario() {
		return gFunc.getFuncionarios();
	}

	public void remove(Cliente cliente) throws ExceptionGerenciadorCliente {
		gCliente.removeCliente(cliente);

	}

	public void removeFornecedor(Fornecedor f) throws ExceptionGerenciadorFornecedor {
		gFornecedor.removeFornecedor(f);
		
	}
	public Cliente pesquisaClienteCpf(String cpf)
			throws ExceptionGerenciadorCliente {
		return gCliente.pesquisarClientePorCpf(cpf);
	}

	public Fornecedor pesquisaFornecedorCnpj(String cnpj)
			throws ExceptionGerenciadorFornecedor {
		return gFornecedor.pesquisarFornecedorPorCnpj(cnpj);

	}

	public Cliente pesquisaClienteNome(String nome)
			throws ExceptionGerenciadorCliente {
		return gCliente.pesquisarClientePorNome(nome);

	}

	public Fornecedor pesquisaFornecedorNome(String nome)
			throws ExceptionGerenciadorFornecedor {
		return gFornecedor.pesquisarFornecedorPorNome(nome);
	}

	public Fornecedor pesquisaFornecedorId(String id)
			throws ExceptionGerenciadorFornecedor {
		return gFornecedor.pesquisarFornecedorId(id);
	}

	public Cliente pesquisaClienteCategoria(String categoria)
			throws ExceptionGerenciadorCliente {
		return gCliente.pesquisaClientePorCategoria(categoria);

	}

	public Funcionario pesquisaFuncionarioCpf(String cpf) throws ExceptionGerenciadorFuncionario {
		return gFunc.pesquisarFuncionarioPorCpf(cpf);
		
	}

		
	

	

	//
	// public Pessoa buscaCliente(String nome) {
	// return gRH.pegaClientePorNome(nome);
	//
	// }
	//
	// public int tamanhoListaCliente() {
	// return gRH.tamanhoListaCliente();
	//
	// }
	//
	// public boolean removeCliente(String nome) {
	// return gRH.removeClientePorNome(nome);
	// }
	//
	// public boolean addCliente(Cliente c) {
	// return gRH.addCliente(c);
	//
	// }
	//
	//
	// public List<Cliente> buscaListaCliente() {
	// return gRH.getClientes();
	// }

}
