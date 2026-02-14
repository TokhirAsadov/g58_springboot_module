package uz.pdp.springboot_module;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import uz.pdp.springboot_module.entity.Post;
import uz.pdp.springboot_module.repository.PostRepository;

import java.net.URL;
import java.util.List;

@SpringBootApplication
public class SpringbootModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootModuleApplication.class, args);
	}

//	@Bean
	ApplicationRunner run(PostRepository postRepository, ObjectMapper objectMapper){
		return args -> {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			List<Post> posts = objectMapper.readValue(url.openStream(), new TypeReference<List<Post>>() {
			});
			postRepository.saveAll(posts.stream().map(post -> Post.builder()
					.userId(post.getUserId())
					.title(post.getTitle())
					.body(post.getBody())
					.build()).toList());
			System.out.println("Posts saved to database: " + posts.size());
		};
	}
}
