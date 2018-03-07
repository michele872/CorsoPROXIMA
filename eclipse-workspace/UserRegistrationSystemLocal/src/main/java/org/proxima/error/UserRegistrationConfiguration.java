package org.proxima.error;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class UserRegistrationConfiguration {
	//mette il file di properties dentro il pool "messageSource" a disposizione di spring insieme a tutte le annotation utili
	//come @Autowired
	@Bean(name = "messageSource")
		public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle =
		new ReloadableResourceBundleMessageSource();
			messageBundle.setBasename("classpath:messages/messages");
			messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}
	
}
