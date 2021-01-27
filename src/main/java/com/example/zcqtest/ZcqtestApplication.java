package com.example.zcqtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Date;

@SpringBootApplication
@RestController
public class ZcqtestApplication {

	public static int b = 0;

	public static void main(String[] args) {

		SpringApplication.run(ZcqtestApplication.class, args);

	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/zcqtest")
	public String zcqtest(@RequestParam(value = "name", defaultValue = "World") String name) throws IOException {

		String url = "http://zcqtest2/getdate2";

		return String.format(restTemplate.getForObject(url,String.class) + ", Hello zcqtest v1 %s! \n", name);

	}

	@GetMapping("/getdate")
	public String getdate()throws Exception{

		Date date = new Date() ;

		// 测容错时添加try catch段
		try{
			int a = 5;
			float result = a / b;
		}catch (Exception e){
			throw e;
		}finally {
			b++;
			if(b > 4){
				b = -1;
			}
		}

		return String.format(" --> NSF: zcqtest v1: " + date.toString() + " --result: " + b + " --" + " <-- \n");

	}

}
