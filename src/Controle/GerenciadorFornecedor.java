package Controle;

import java.util.ArrayList;
import java.util.List;

import Entidades.Fornecedor;
import Excecao.ExceptionGerenciadorFornecedor;

public class GerenciadorFornecedor {

	private List<Fornecedor> fornecedores;

	public GerenciadorFornecedor() {

		fornecedores = new ArrayList<Fornecedor>();

	}

	public void cadastrar(Fornecedor fornecedor) {
		fornecedores.add(fornecedor);

	}

	public Fornecedor getFornecedor(Fornecedor fornecedor)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor f : fornecedores) {
			if (f.equals(fornecedor)) {
				return f;
			}
		}
		throw new ExceptionGerenciadorFornecedor("Fornecedor não cadastrado");
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public Fornecedor pesquisarFornecedorPorCnpj(String cnpj)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getCnpj().equals(cnpj))
				return fornecedor;
		}
		return null;
	}

	public Fornecedor pesquisarFornecedorPorNome(String nome)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getNome().equals(nome))
				return fornecedor;
		}
		return null;
	}

	public Fornecedor pesquisarFornecedorId(String id)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getId().equals(id))
				;
			return fornecedor;
		}
		return null;
	}

	// public Fornecedor pesquisaClientePorIR(int ir) throws
	// ExceptionGerenciadorFornecedor {
	// for (Fornecedor fornecedor : fornecedores) {
	// if (fornecedor.getIr()==ir));{
	// return fornecedor;
	// }
	// }
	// return null;
	//
	// }
	public boolean removeFornecedor(Fornecedor fornecedor)
			throws ExceptionGerenciadorFornecedor {
		for (Fornecedor f : fornecedores) {
			if (f.equals(fornecedor))
				;
			return fornecedores.remove(fornecedor);
		}
		throw new ExceptionGerenciadorFornecedor("Lista Nao Possui Cliente");
	}

}
