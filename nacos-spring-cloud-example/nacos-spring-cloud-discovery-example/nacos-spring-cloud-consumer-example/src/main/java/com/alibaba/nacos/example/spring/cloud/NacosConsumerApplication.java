package com.alibaba.nacos.example.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojing
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {

    @Value("${server.port}")
    private Integer port;
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
    @Autowired
    private EchoService echoService;

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

    @RestController
    public class TestController {

//        private final RestTemplate restTemplate;
//
//        @Autowired
//        public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}
//
//        @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
//        public String echo(@PathVariable String str) {
//            return restTemplate.getForObject("http://service-provider/echo/" + "consumer port 8080 "+ str , String.class);
//        }


        @RequestMapping(value = "/user/{str}", method = RequestMethod.GET)
        public String echo(@PathVariable String str){
            return  echoService.echo(str+"--->"+"fe-consumer:"+port +" user--->" );
        }

    }
}
