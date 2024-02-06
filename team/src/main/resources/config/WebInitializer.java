package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import context.Context_1_dataSource;
import context.Context_2_mybatis;
import context.Context_3_dao;
import context.Context_4_fileupload;
import mvc.Servlet_Context;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {  Context_1_dataSource.class,
							  Context_2_mybatis.class,
							  Context_3_dao.class,
							  Context_4_fileupload.class};
	}

	

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { Servlet_Context.class };
	}

	// getServletMappings
	// DispatcherServlet�� URL ������ �����Ѵ�.
	// "/" : ��� ��û�� ó���ϰڴ�.

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

	// filter
	// Client�� ��û�� Servlet�� �����ϱ� ���̳� �Ŀ� ��û �� ���� �����͸� �����ϰų�
	// �߰����� �۾��� �����ϴµ� ���Ǵ� �ڹ� ������Ʈ

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
		return new Filter[] {characterEncodingFilter};
	}
}