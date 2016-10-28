package br.com.hyperclass.supermarket.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.supermarket.domain.cashier.Cashier;
import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.domain.shoppingcart.ShoppingCart;
import br.com.hyperclass.supermarket.domain.stock.Stock;

/**
 * A classe <code>SpringContextConfiguration<code> é onde fica a configuração
 * do contexto do Spring da aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 13/10/2016
 */

@Configuration
public class SpringContextConfiguration {
	
	@Bean
	public Stock getStock() {
		Stock stock = new Stock();
		loadStock(stock);
		return stock;
	}
	
	@Bean
	public Cashier getCashier() {
		Cashier cashier = new Cashier();
		return cashier;
	}
	
	@Bean
	public ShoppingCart getShoppingCart() {
		ShoppingCart cart = new ShoppingCart(getStock());
		return cart;
	}
	
	public void loadStock(final Stock stock) {
		stock.addProduct(new Product("333372", "bombom especialidades nestle caixa 300g", new BigDecimal(7.90), " informação qualquer"), 30);
		stock.addProduct(new Product("327510", "vodka sueca absolut garrafa 1 litro", new BigDecimal(93.00), "informação qualquer"), 30);
		stock.addProduct(new Product("322383", "cafe torrado e moido tradicional melitta pacote 500g", new BigDecimal(12.25), "informação qualquer"), 50);

	}
	
}