package com.babylonhealth.controller;

import com.babylonhealth.model.Article;
import com.babylonhealth.service.NhsChoiceService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nhsChoice")
public class NhsChoiceController {

  private static final Logger logger = LoggerFactory.getLogger(NhsChoiceController.class);
  @Autowired private NhsChoiceService nhsChoiceService;

  @GetMapping("/question/{question}")
  public ResponseEntity<?> askQuestion(@PathVariable String question)
      throws UnsupportedEncodingException {

    logger.info("question[{}]", URLDecoder.decode(question, "UTF-8"));
    Collection<Article> answer = nhsChoiceService.answerQuestion(question);
    if (answer.size() > 0) {
      return ResponseEntity.ok(
          answer.stream().map(article -> article.getUrl()).collect(Collectors.toList()));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/content/{content}")
  public ResponseEntity<String> findByContent(@PathVariable String content)
      throws UnsupportedEncodingException {
    Optional<Article> articleOptional = nhsChoiceService.findByContent(content);
    if (articleOptional.isPresent()) {
      return ResponseEntity.ok(articleOptional.get().getUrl());
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
