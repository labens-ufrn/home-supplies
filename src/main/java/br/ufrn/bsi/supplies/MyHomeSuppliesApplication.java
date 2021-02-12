package br.ufrn.bsi.supplies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.ufrn.bsi.supplies.dao.UserDao;
import br.ufrn.bsi.supplies.entity.User;

@SpringBootApplication
@EnableJpaRepositories
public class MyHomeSuppliesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeSuppliesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserDao repository) {
		return (args) -> {
			// save a few customers
			repository.save(new User("jack", "Jack", "Bauer"));
			repository.save(new User("chloe", "Chloe", "O'Brian"));
			repository.save(new User("kim", "Kim", "Bauer"));
			repository.save(new User("david", "David", "Palmer"));
			repository.save(new User("taciano", "Taciano", "Silva"));
			repository.save(new User("michelle", "Michelle", "Dessler"));
			

			// fetch all users
			System.out.println("Users found with findAll():");
			System.out.println("-------------------------------");
			for (User user : repository.findAll()) {
				System.out.println(user.toString());
			}
			System.out.println("");

			// fetch an individual customer by ID
			User user = repository.findById(1L);
			System.out.println("User found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(user.toString());
			System.out.println("");

			// fetch customers by last name
			System.out.println("User found with findByLastName('Bauer'):");
			System.out.println("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				System.out.println(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			System.out.println("");
			// delete an individual customer by ID
			repository.deleteById(5L);
			System.out.println("Delete User with deleteById(6L):");
			System.out.println("--------------------------------");
			System.out.println("");

			// fetch all users
			System.out.println("Users found with findAll():");
			System.out.println("-------------------------------");
			for (User user2 : repository.findAll()) {
				System.out.println(user2.toString());
			}
			System.out.println("");
		};
	}
}
