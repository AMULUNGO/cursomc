package com.aprendeali.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aprendeali.cursomc.domain.Categoria;
import com.aprendeali.cursomc.domain.Cidade;
import com.aprendeali.cursomc.domain.Cliente;
import com.aprendeali.cursomc.domain.Endereco;
import com.aprendeali.cursomc.domain.Estado;
import com.aprendeali.cursomc.domain.ItemPedido;
import com.aprendeali.cursomc.domain.Pagamento;
import com.aprendeali.cursomc.domain.PagamentoComBoleto;
import com.aprendeali.cursomc.domain.PagamentoComCartao;
import com.aprendeali.cursomc.domain.Pedido;
import com.aprendeali.cursomc.domain.Produto;
import com.aprendeali.cursomc.domain.enums.EstadoPagamento;
import com.aprendeali.cursomc.domain.enums.TipoCliente;
import com.aprendeali.cursomc.repositories.CategoriaRepository;
import com.aprendeali.cursomc.repositories.CidadeRepository;
import com.aprendeali.cursomc.repositories.ClienteRepository;
import com.aprendeali.cursomc.repositories.EnderecoRepository;
import com.aprendeali.cursomc.repositories.EstadoRepository;
import com.aprendeali.cursomc.repositories.ItemPedidoRepository;
import com.aprendeali.cursomc.repositories.PagamentoRepository;
import com.aprendeali.cursomc.repositories.PedidoRepository;
import com.aprendeali.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Eletrodomestico");
		Categoria cat4 = new Categoria(null, "Mobilia");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoracao");
		Categoria cat7 = new Categoria(null, "Celulares e Acessorios");
		Categoria cat8 = new Categoria(null, "Consumives Informaticos");
		Categoria cat9 = new Categoria(null, "Decoracao");
		Categoria cat10 = new Categoria(null, "Perfumaria");

		Produto prod1 = new Produto(null, "Computador", 2000.00);
		Produto prod2 = new Produto(null, "Impressora", 800.00);
		Produto prod3 = new Produto(null, "Mouse", 200.00);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));

		Estado est1 = new Estado(null, "Maputo");
		Estado est2 = new Estado(null, "Sofala");

		Cidade c1 = new Cidade(null, "Cidade de Maputo", est1);
		Cidade c2 = new Cidade(null, "Beira", est2);
		Cidade c3 = new Cidade(null, "Cidade da Matola", est1);

		est1.getCidades().addAll(Arrays.asList(c1, c3));
		est2.getCidades().addAll(Arrays.asList(c2));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Isabel Rodolfo", "isabel.rodolfo@ubagroup.com", "123654951",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("828430178", "872072083"));

		Endereco e1 = new Endereco(null, "Rua da Resistencia", "300", "1458", "Malhangalene", "12345", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Samora Machel", "105", "2004", "Estoril", "98745", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("10/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:38"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(prod1, ped1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(prod3, ped1, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(prod2, ped2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));	
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
