package Controle;

import java.util.ArrayList;
import java.util.List;

import Entidades.Funcionario;
import Entidades.Funcionario;
import Excecao.ExceptionGerenciadorFornecedor;
import Excecao.ExceptionGerenciadorFuncionario;

public class GerenciadorFuncionario {

	private List<Funcionario> funcionarios;

	public GerenciadorFuncionario() {

		funcionarios = new ArrayList<Funcionario>();

	}

	public void cadastrar(Funcionario funcionario) {
		funcionarios.add(funcionario);

	}

	public Funcionario getFuncionario(Funcionario funcionario)
			throws ExceptionGerenciadorFuncionario {
		for (Funcionario f : funcionarios) {
			if (f.equals(funcionario)) {
				return f;
			}
		}
		throw new ExceptionGerenciadorFuncionario("funcionario não cadastrado");
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Funcionario pesquisarFuncionarioPorCpf(String cpf)
			throws ExceptionGerenciadorFuncionario {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equals(cpf))
				return funcionario;
		}
		return null;
	}
	
	public Funcionario pesquisarFuncionarioPorNome(String nome)
			throws ExceptionGerenciadorFuncionario {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNome().equals(nome))
				return funcionario;
		}
		return null;
	}

	public Funcionario pesquisarFuncionarioId(String id)
			throws ExceptionGerenciadorFuncionario {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId().equals(id))
				;
			return funcionario;
		}
		return null;
	}

}
