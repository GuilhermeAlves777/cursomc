package com.guilhermealves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guilhermealves.cursomc.domain.Categoria;
import com.guilhermealves.cursomc.domain.Cidade;
import com.guilhermealves.cursomc.domain.Cliente;
import com.guilhermealves.cursomc.domain.Endereco;
import com.guilhermealves.cursomc.domain.Estado;
import com.guilhermealves.cursomc.domain.ItemPedido;
import com.guilhermealves.cursomc.domain.Pagamento;
import com.guilhermealves.cursomc.domain.PagamentoComBoleto;
import com.guilhermealves.cursomc.domain.PagamentoComCartao;
import com.guilhermealves.cursomc.domain.Pedido;
import com.guilhermealves.cursomc.domain.Produto;
import com.guilhermealves.cursomc.domain.enums.EstadoPagamento;
import com.guilhermealves.cursomc.domain.enums.TipoCliente;
import com.guilhermealves.repositories.CategoriaRepository;
import com.guilhermealves.repositories.CidadeRepository;
import com.guilhermealves.repositories.ClienteRepository;
import com.guilhermealves.repositories.EnderecoRepository;
import com.guilhermealves.repositories.EstadoRepository;
import com.guilhermealves.repositories.ItemPedidoRepository;
import com.guilhermealves.repositories.PagamentoRepository;
import com.guilhermealves.repositories.PedidoRepository;
import com.guilhermealves.repositories.ProdutoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.guilhermealves.repositories")
@EntityScan(basePackages ="com.guilhermealves.cursomc.domain")

//O método CommandLineRunner permiti a execução que está dentro da classe para quando a aplicação iniciar
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
	
	//Instanciando objetos logo após a inicialização do projeto
	@Override
	public void run(String... args) throws Exception {
		
		
		//Instâncias
		Categoria cat1 = new Categoria (null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		//Associações
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Ubêrlandia", est1);
		Cidade c2 = new Cidade (null, "São Paulo", est2);
		Cidade c3 = new Cidade (null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente (null, "Maria Silva", "maria@gmail.com","36428367564", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco (null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco (null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido (null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido (null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido (ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido (ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido (ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

}
 