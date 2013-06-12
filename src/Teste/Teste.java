package Teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Entidades.Cliente;
import Entidades.Fornecedor;
import Entidades.Funcionario;
import Excecao.ExceptionGerenciadorCliente;
import Excecao.ExceptionGerenciadorFornecedor;
import Excecao.ExceptionGerenciadorFuncionario;
import Fachada.Loja;

public class Teste {

	Loja fachada;
	Cliente c;
	Fornecedor f;
	Funcionario func;
	List<Cliente> listaCliente = null;
	List<Fornecedor> listaFornecedor = null;
	List<Funcionario> listaFuncionarios = null;

	@Before
	public void CriarFachada() {
		fachada = new Loja();
		c = new Cliente();
		f = new Fornecedor();
		func = new Funcionario();
		listaFornecedor = new ArrayList<Fornecedor>();
		listaCliente = new ArrayList<Cliente>();
		listaFuncionarios = new ArrayList<Funcionario>();
	}

	private Cliente criarClientePadrao() {

		c.setNome("Flavio");
		c.setCpf("111.111.111.11");
		c.setCidade("Jacarau");
		c.setRua("Treze de Maio");
		c.setNumero(97);
		c.setBairro("Centro");
		c.setCep("123");
		c.setEstado("PB");
		c.setEmails("flavio.batista@dce.ufpb.br");
		c.setCategoria("A");
		return c;

	}

	@Test
	public void cadastrarCliente() {
		Cliente cliente1 = new Cliente();
		cliente1.setNome("flavio");
		cliente1.setCpf("123");

		fachada.cadastrar(cliente1);

		List<Cliente> clienteSalvos = fachada.listarClientes();
		Assert.assertEquals(1, clienteSalvos.size());

		Cliente clienteSalvo = clienteSalvos.get(0);
		Assert.assertEquals(cliente1, clienteSalvo);
		Assert.assertEquals("flavio", cliente1.getNome());
	}

	@Test
	public void cadastrarMesmoCliente() {
		c = criarClientePadrao();
		Assert.assertEquals(0, listaCliente.size());
		fachada.cadastrar(c);
		fachada.cadastrar(c);

		List<Cliente> clientes = fachada.listarClientes();
		Cliente cadastrado = clientes.get(0);
		Assert.assertEquals(cadastrado, c);

		Assert.assertEquals(2, fachada.listarClientes().size());

	}

	@Test
	public void pesquisaClientePorCpf() throws ExceptionGerenciadorCliente {
		c = criarClientePadrao();
		Cliente c2 = new Cliente();
		c2.setNome("Nil");
		c2.setCpf("123");

		fachada.cadastrar(c);
		fachada.cadastrar(c2);
		fachada.pesquisaClienteCpf("123");

		List<Cliente> clientes = fachada.listarClientes();

		Cliente clientePesquisado = clientes.get(1);
		Assert.assertEquals(clientePesquisado,
				fachada.pesquisaClienteCpf("123"));

	}

	@Test
	public void pesquisaClientePorNome() throws ExceptionGerenciadorCliente {
		c = criarClientePadrao();
		Cliente c2 = new Cliente();

		c2.setNome("Nil");
		c2.setCpf("123");
		c2.setCategoria("B");

		fachada.cadastrar(c);
		fachada.cadastrar(c2);
		fachada.pesquisaClienteNome("Flavio");

		List<Cliente> clientes = fachada.listarClientes();

		Cliente clientePesquisado = clientes.get(0);
		Assert.assertEquals(clientePesquisado,
				fachada.pesquisaClienteCategoria("A"));

	}

	@Test
	public void pesquisaClientePorCategoria()
			throws ExceptionGerenciadorCliente {
		c = criarClientePadrao();
		Cliente c2 = new Cliente();
		c2.setNome("Nil");
		c2.setCpf("123");
		c2.setCategoria("B");

		fachada.cadastrar(c);
		fachada.cadastrar(c2);
		fachada.pesquisaClienteCategoria("B");

		List<Cliente> clientes = fachada.listarClientes();

		Cliente clientePesquisado = clientes.get(0);
		Assert.assertEquals(clientePesquisado,
				fachada.pesquisaClienteNome("Flavio"));

	}

	@Test
	public void alterarNomeCliente() {
		c = criarClientePadrao();
		fachada.cadastrar(c);
		Assert.assertEquals("Flavio", c.getNome());
		c.setNome("Nil");
		Assert.assertEquals("Nil", c.getNome());

	}

	@Test
	public void alterarCpfCliente() {
		c = criarClientePadrao();
		fachada.cadastrar(c);
		Assert.assertEquals("111.111.111.11", c.getCpf());
		c.setCpf("222.222.222.22");
		Assert.assertEquals("222.222.222.22", c.getCpf());
	}

	@Test
	public void addClienteNomeNulo() {
		c = criarClientePadrao();
		c.setNome(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteCpfNulo() {
		c = criarClientePadrao();
		c.setCpf(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteCidadeNulo() {
		c = criarClientePadrao();
		c.setCidade(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteRuaNulo() {
		c = criarClientePadrao();
		c.setRua(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteBairroNulo() {
		c = criarClientePadrao();
		c.setBairro(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteCepNulo() {
		c = criarClientePadrao();
		c.setCep(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteEstadoNulo() {
		c = criarClientePadrao();
		c.setEstado(null);
		fachada.cadastrar(c);
	}

	@Test
	public void addClienteEmailsNulo() {
		c = criarClientePadrao();
		c.setEmails(null);
		fachada.cadastrar(c);
	}

	@Test
	public void removeCliente() throws ExceptionGerenciadorCliente {
		c = criarClientePadrao();
		Cliente c2 = criarClientePadrao();
		fachada.cadastrar(c);
		fachada.cadastrar(c2);
		Assert.assertEquals(2, fachada.listarClientes().size());
		fachada.remove(c);
		fachada.remove(c2);
		Assert.assertEquals(0, fachada.listarClientes().size());

	}

	/*
	 * --------------- TESTES -------Fornecedor
	 * __________________________________________________________________
	 */
	private Fornecedor criarFornecedorPadrao() {
		f.setNome("Amanco");
		f.setCnpj("111");
		f.setWebsites("Amanco.com");
		f.setTelefone("111");
		f.setCidade("Sao Paulo");
		f.setBairro("Morumbi");
		f.setRua("Tricolor");
		f.setNumero(3);
		f.setCep("111");
		f.setContacorrente(123454);
		f.setAgencia("111");
		f.setBanco("Banco do Brasil");
		f.setId("111");

		return f;
	}

	@Test
	public void cadastrarFornecedor() {
		Fornecedor fornecedor1 = new Fornecedor();
		fornecedor1.setNome("Tigre");
		fornecedor1.setCnpj("12311");

		fachada.cadastrar(fornecedor1);

		List<Fornecedor> fornecedorSalvos = fachada.listarFornecedor();
		Assert.assertEquals(1, fornecedorSalvos.size());

		Fornecedor fornecedorSalvo = fornecedorSalvos.get(0);
		Assert.assertEquals(fornecedor1, fornecedorSalvo);
		Assert.assertEquals("Tigre", fornecedor1.getNome());
	}

	@Test
	public void cadastrarMesmoFornecedor() {
		f = criarFornecedorPadrao();
		Assert.assertEquals(0, listaFornecedor.size());
		fachada.cadastrar(f);
		fachada.cadastrar(f);

		List<Fornecedor> fornecedores = fachada.listarFornecedor();
		Fornecedor cadastrado = fornecedores.get(0);
		Assert.assertEquals(cadastrado, f);

		Assert.assertEquals(2, fachada.listarFornecedor().size());

	}

	@Test
	public void pesquisaFornecedorPorCnpj()
			throws ExceptionGerenciadorFornecedor {
		f = criarFornecedorPadrao();
		Fornecedor f2 = new Fornecedor();
		f2.setNome("Amanco");
		f2.setCnpj("123");

		fachada.cadastrar(f);
		fachada.cadastrar(f2);
		fachada.pesquisaFornecedorCnpj("123");

		List<Fornecedor> fornecedores = fachada.listarFornecedor();

		Fornecedor fornecedorPesquisado = fornecedores.get(1);
		Assert.assertEquals(fornecedorPesquisado,
				fachada.pesquisaFornecedorCnpj("123"));

	}

	@Test
	public void pesquisaFornecedorPorNome()
			throws ExceptionGerenciadorFornecedor {
		f = criarFornecedorPadrao();
		Fornecedor f2 = new Fornecedor();

		f2.setNome("Amanco");
		f2.setCnpj("123");

		fachada.cadastrar(f);
		fachada.cadastrar(f2);
		fachada.pesquisaFornecedorNome("Amanco");

		List<Fornecedor> fornecedores = fachada.listarFornecedor();

		Fornecedor FornecedorPesquisado = fornecedores.get(0);
		Assert.assertEquals(FornecedorPesquisado,
				fachada.pesquisaFornecedorNome("Amanco"));

	}

	@Test
	public void pesquisaFornecedorPorCategoria()
			throws ExceptionGerenciadorFornecedor {
		f = criarFornecedorPadrao();
		Fornecedor f2 = new Fornecedor();
		f2.setNome("Amanco");
		f2.setCnpj("123");
		f2.setId("12");

		fachada.cadastrar(f);
		fachada.cadastrar(f2);
		fachada.pesquisaFornecedorId("12");

		List<Fornecedor> fornecedores = fachada.listarFornecedor();

		Fornecedor fornecedorPesquisado = fornecedores.get(0);
		Assert.assertEquals(fornecedorPesquisado,
				fachada.pesquisaFornecedorId("12"));

	}

	@Test
	public void alterarNomeFornecedor() {
		f = criarFornecedorPadrao();
		fachada.cadastrar(f);
		Assert.assertEquals("Amanco", f.getNome());
		f.setNome("Tigre");
		Assert.assertEquals("Tigre", f.getNome());

	}

	@Test
	public void alterarCnpjFornecedor() {
		f = criarFornecedorPadrao();
		fachada.cadastrar(f);
		Assert.assertEquals("111", f.getCnpj());
		f.setCnpj("222");
		Assert.assertEquals("222", f.getCnpj());
	}

	@Test
	public void addFornecedorNomeNulo() {
		f = criarFornecedorPadrao();
		f.setNome(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorCnpjNulo() {
		f = criarFornecedorPadrao();
		f.setCnpj(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorCidadeNulo() {
		f = criarFornecedorPadrao();
		f.setCidade(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorRuaNulo() {
		f = criarFornecedorPadrao();
		f.setRua(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorBairroNulo() {
		f = criarFornecedorPadrao();
		f.setBairro(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorCepNulo() {
		f = criarFornecedorPadrao();
		f.setCep(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorEstadoNulo() {
		f = criarFornecedorPadrao();
		f.setEstado(null);
		fachada.cadastrar(f);
	}

	@Test
	public void addFornecedorEmailsNulo() {
		f = criarFornecedorPadrao();
		f.setEmails(null);
		fachada.cadastrar(f);
	}

	@Test
	public void removeFornecedor() throws ExceptionGerenciadorFornecedor {
		f = criarFornecedorPadrao();
		Fornecedor f2 = criarFornecedorPadrao();
		fachada.cadastrar(f);
		fachada.cadastrar(f2);
		Assert.assertEquals(2, fachada.listarFornecedor().size());
		fachada.removeFornecedor(f);
		fachada.removeFornecedor(f2);
		Assert.assertEquals(0, fachada.listarFornecedor().size());

	}

	/*
	 * --------------- TESTES -------Funcionario
	 * __________________________________________________________________
	 */

	private Funcionario criarFuncionarioPadrao() {
		func.setNome("Nil");
		func.setCpf("111");
		func.setTelefone("111");
		func.setCidade("Sao Paulo");
		func.setBairro("Morumbi");
		func.setRua("Tricolor");
		func.setNumero(3);
		func.setCep("111");
		func.setContacorrente(123454);
		func.setAgencia("111");
		func.setBanco("Banco do Brasil");
		return func;
	}

	@Test
	public void cadastrarFuncionario() {
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Flavio");
		funcionario1.setCep("111");

		fachada.cadastrar(funcionario1);

		List<Funcionario> funcionarioSalvos = fachada.listarFuncionario();
		Assert.assertEquals(1, funcionarioSalvos.size());

		Funcionario funcionarioSalvo = funcionarioSalvos.get(0);
		Assert.assertEquals(funcionario1, funcionarioSalvo);
		Assert.assertEquals("Flavio", funcionario1.getNome());
	}

	@Test
	public void cadastrarMesmoFuncionario() {
		func = criarFuncionarioPadrao();
		Assert.assertEquals(0, listaFuncionarios.size());
		fachada.cadastrar(func);
		fachada.cadastrar(func);

		List<Funcionario> funcionarios = fachada.listarFuncionario();
		Funcionario cadastrado = funcionarios.get(0);
		Assert.assertEquals(cadastrado, func);

		Assert.assertEquals(2, fachada.listarFuncionario().size());

	}

	@Test
	public void pesquisaFuncionarioPorCnpj()
			throws ExceptionGerenciadorFuncionario {
		func = criarFuncionarioPadrao();
		Funcionario func2 = new Funcionario();
		func2.setNome("Carla");
		func2.setCpf("123");

		fachada.cadastrar(func);
		fachada.cadastrar(func2);
		fachada.pesquisaFuncionarioCpf("123");

		List<Funcionario> funcionarios = fachada.listarFuncionario();

		Funcionario funcionarioPesquisado = funcionarios.get(1);
		Assert.assertEquals(funcionarioPesquisado,
				fachada.pesquisaFuncionarioCpf("123"));

	}
	
	@Test
	public void alterarNomeFuncionario() {
		func = criarFuncionarioPadrao();
		fachada.cadastrar(func);
		Assert.assertEquals("Nil", func.getNome());
		func.setNome("Carla");
		Assert.assertEquals("Carla", func.getNome());

	}

	@Test
	public void alterarCnpjFuncinario() {
		func = criarFuncionarioPadrao();
		fachada.cadastrar(func);
		Assert.assertEquals("111", func.getCpf());
		func.setCpf("222");
		Assert.assertEquals("222", func.getCpf());
	}


}