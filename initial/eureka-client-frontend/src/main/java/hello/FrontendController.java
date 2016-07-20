package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
// @RibbonClient(name="eureka-client-greet-service")
public class FrontendController {
	private static Logger log = LoggerFactory.getLogger(FrontendController.class);
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/hi")
	public String sayHi(@RequestParam(value = "name", defaultValue = "Java") String name) {
		log.info("Access /hi");
		
		String greeting = this.restTemplate.getForObject("http://eureka-client-greet-service/greeting", String.class);
		return String.format("%s, %s!", greeting, name);
		
	}
}