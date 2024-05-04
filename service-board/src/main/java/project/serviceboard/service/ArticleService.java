package project.serviceboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.reactive.function.client.WebClient;
import project.serviceboard.model.entity.ArticleEntity;
import project.serviceboard.model.Article;
import project.serviceboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final WebClient.Builder webClientBuilder;
    @Transactional
    public void create(String stockId, Integer userId, String title, String body) {
        ArticleEntity articleEntity = ArticleEntity.of(stockId, userId, title, body);
        articleRepository.save(articleEntity);
    }

    public Page<Article> list(Pageable pageable) {
        return articleRepository.findAll(pageable).map(Article::fromEntity);
    }

    public Page<Article> my(Integer userId, Pageable pageable) {
        return articleRepository.findAllByUserId(userId, pageable).map(Article::fromEntity);
    }

    public Page<Article> searchList(Pageable pageable, String searchKeyword, String type, String userId) {
        Page<Article> list = null;
        System.out.println(type + " " + searchKeyword + " " + userId);
        switch (type) {
            case "title":
                System.out.println("your searching title..");
                list = articleRepository.findByTitleContaining(searchKeyword, pageable).map(Article::fromEntity);
                break;
            case "writer":
                System.out.println("your searching writer..");
                String userName = getUserNameById(Integer.parseInt(userId));
                System.out.println(userName);
                // list = articleRepository.findByUsernameContaining(pageable, searchKeyword);
                break;
            case "body":
                list = articleRepository.findByBodyContaining(searchKeyword, pageable).map(Article::fromEntity);
                break;
        }
        System.out.println("리스트 " + list);
        return list;
    }

    public String getUserNameById(Integer userId) {
        String result = webClientBuilder.build().get()
            .uri("http://service-user/api/v1/users/" + userId)
            .retrieve()
            .bodyToMono(String.class)
            .block();
        System.out.println(result);
        return result;
    }
}