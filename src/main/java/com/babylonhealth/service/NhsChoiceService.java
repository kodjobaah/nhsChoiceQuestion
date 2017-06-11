package com.babylonhealth.service;

import com.babylonhealth.model.Article;
import com.babylonhealth.model.ArticleRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhsChoiceService {

  @Autowired ArticleRepository articleRepository;

  public NhsChoiceService() {}

  public NhsChoiceService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public Collection<Article> answerQuestion(String question) {
    throw new RuntimeException("Not implemented yet");
  }

  public Optional<Article> findByContent(String content) {
    return articleRepository.findOneByContentLike(content);
  }
}
