package project.serviceboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.domain.Page;
import project.serviceboard.model.Article;
import project.serviceboard.repository.ArticleRepository;

import java.awt.print.Pageable;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBoardApplication {

    private final ArticleRepository articleRepository;

    public ServiceBoardApplication(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceBoardApplication.class, args);
    }

}
