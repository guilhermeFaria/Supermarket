package br.com.hyperclass.supermarket.config;

import javax.servlet.Filter;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * A classe <code>WebApplicationInitializer</code> representa a inicialização
 * do contexto do Spring na aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 13 de out de 2016
 */
public class SupermarketWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {SpringContextConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setForceEncoding(true);
        encodingFilter.setEncoding("UTF-8");

        return new Filter[] {encodingFilter};
    }
}