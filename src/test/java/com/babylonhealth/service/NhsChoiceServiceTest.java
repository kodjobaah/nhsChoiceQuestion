package com.babylonhealth.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import com.babylonhealth.model.Article;
import com.babylonhealth.model.ArticleRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhsChoiceServiceTest {

  private ArticleRepository articleRepository;

  private NhsChoiceService nhsChoiceService;

  @Before
  public void setUp() {

    articleRepository = Mockito.mock(ArticleRepository.class);
    nhsChoiceService = new NhsChoiceService(articleRepository);
  }

  @Test
  public void testFindByContent() {
    String content = "content";
    Article article = new Article();
    article.setUrl("myurl");
    when(articleRepository.findOneByContentLike(eq(content))).thenReturn(Optional.of(article));

    Article response = nhsChoiceService.findByContent(content).get();
    assertThat("myurl").isEqualToIgnoringCase("myUrl");
  }
}
