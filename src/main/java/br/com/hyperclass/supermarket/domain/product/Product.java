package br.com.hyperclass.supermarket.domain.product;

import java.math.BigDecimal;

/**
 * A classe <code>Product</code> representa um produto com as suas devidas informações.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 11/10/2016
 */

public class Product implements Comparable<Product> {
	private final String barCode;
	private final String nameProduct;
	private final BigDecimal value;
	private final String productInformation;
	
	public Product (final String barCode, final String nameProduct, final BigDecimal value, final String productInformation) {
		this.barCode = barCode;
		this.nameProduct = nameProduct;
		this.value = value;
		this.productInformation = productInformation;
	}
	
	public String nameProduct() {
		return nameProduct;
	}
	
	public BigDecimal value() {
		return value;
	}
	public String barCode() {
		return barCode;
	}
	public String productInformation() {
		return productInformation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barCode == null) ? 0 : barCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (barCode == null) {
			if (other.barCode != null)
				return false;
		} else if (!barCode.equals(other.barCode))
			return false;
		return true;
	}

	@Override
	public int compareTo(final Product product) {
		return barCode().compareTo(product.barCode());
	}
}