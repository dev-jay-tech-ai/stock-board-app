package project.serviceboard.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.serviceboard.controller.request.WriteRequest;

import project.serviceboard.controller.response.ArticleResponse;
import project.serviceboard.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import project.serviceuser.controller.response.Response;

@RestController
@RequestMapping("/api/v1/articles")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public Response<Void> create(@RequestBody WriteRequest request, Authentication authentication) {
        articleService.create( "005930", 1, request.getTitle(), request.getBody());
        return Response.success();
    }

    @GetMapping
    public Response<Page<ArticleResponse>> list(Pageable pageable, String type, String searchKeyword, String userId, Authentication authentication) {
        Page<ArticleResponse> list = null;
        if(searchKeyword == null) {
            list = articleService.list(pageable).map(ArticleResponse::fromArticle);
        } else {
            list = articleService.searchList(pageable, searchKeyword, type, userId).map(ArticleResponse::fromArticle);
        }
        return Response.success(list);
    }
}
