package cn.et.less02;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class ConfigBean {
	
	@Bean
	public ServletRegistrationBean druidStatView(){
			
		ServletRegistrationBean srb= new ServletRegistrationBean();
		//设置servlet的名字	
		srb.setName("DruidStatView");
		StatViewServlet sv= new StatViewServlet();
		//设置Servlet
		srb.setServlet(sv);
		String url="/druid/*";
		List<String> urls = new ArrayList();
		urls.add(url);
		//设置访问的路径
		srb.setUrlMappings(urls);
		//设置用户密码
		LinkedHashMap<String,String> lk= new LinkedHashMap<String,String>();
		lk.put("loginUsername", "admin");
		lk.put("loginPassword", "123456");
		srb.setInitParameters(lk);
		return srb;
	}
}
