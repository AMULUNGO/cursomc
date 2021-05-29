package com.aprendeali.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.aprendeali.cursomc.domain.enums.Perfil;
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

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder password;
	
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

	
	public void instatiateTestDatabase() throws ParseException {
		
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
		//Categoria cat11 = new Categoria(null, "Teste");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Computador", 2000.00);
		Produto p3 = new Produto(null, "Impressora", 2000.00);
		Produto p4 = new Produto(null, "Mouse", 2000.00);
		Produto p5 = new Produto(null, "Mesa de Escritorio", 300.00);
		Produto p6 = new Produto(null, "Toalha", 50.00);
		Produto p7 = new Produto(null, "Colchao", 200.00);
		Produto p8 = new Produto(null, "TV True Color", 1200.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11= new Produto(null, "Champoo", 90.00);
		

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Maputo");
		Estado est2 = new Estado(null, "Sofala");

		Cidade c1 = new Cidade(null, "Cidade de Maputo", est1);
		Cidade c2 = new Cidade(null, "Beira", est2);
		Cidade c3 = new Cidade(null, "Cidade da Matola", est1);

		est1.getCidades().addAll(Arrays.asList(c1, c3));
		est2.getCidades().addAll(Arrays.asList(c2));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Isabel Rodolfo", "mulungo.ali07@gmail.com", "123654951",
				TipoCliente.PESSOAFISICA, password.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("828430178", "872072083"));
		
		Cliente cli2 = new Cliente(null, "Ali Abdul Mulungo", "mulungo.ali07@hotmail.com", "123654951",
				TipoCliente.PESSOAFISICA, password.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("820658674", "860658674"));
		cli2.addPerfil(Perfil.ADMIN);


		Endereco e1 = new Endereco(null, "Rua da Resistencia", "300", "1458", "Malhangalene", "12345", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Samora Machel", "105", "2004", "Estoril", "98745", cli1, c2);
		Endereco e3 = new Endereco(null, "Av. Dos Mapangas", "105", "2004", "Chamissava", "98745", cli2, c1);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

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
		
		ItemPedido ip1 = new ItemPedido(p1, ped1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(p3, ped1, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(p2, ped2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));	
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
