package com.crud.springboot;

import com.crud.springboot.model.Client;
import com.crud.springboot.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.LongStream;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}


	CommandLineRunner init (ClientRepository repository){
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i ->{
						Client c1 = new Client();
						c1.setNome("Gabriel Accioli");
						c1.setEmail("Gabriel@test");
						c1.setTelefone(999999999);
						c1.setCpf(11111111111);
						c1.setStatus(true);
						return c1;
					}).map(obj -> repository.save(obj))
					.forEach(System.out::println);
		};
	}

}
