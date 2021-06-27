package com.example.tpjee;
import com.example.tpjee.Entities.Category;
import com.example.tpjee.Entities.Product;
import com.example.tpjee.dao.CategoryRepository;
import com.example.tpjee.dao.ProductRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class TpjeeApplication implements CommandLineRunner {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public TpjeeApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TpjeeApplication.class, args);

	}

	@Override
	public void run(String... args) {
		categoryRepository.save(new Category(null, null, "computer", null, null));
		categoryRepository.save(new Category(null, "Smartphone", null, null, null));
		categoryRepository.save(new Category(null, "Printers", null, null, null));
		Random rnd = new Random();
		categoryRepository.findAll().forEach(c -> {
			for (int i = 0; i < 10; i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCurrentprice(300 + rnd.nextInt(2000));
				p.setAvailable(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setCategory(c);
				p.setPhotoName("inconnu.png");
				productRepository.save(p);
			}
		});
	}
}
