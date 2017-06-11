package com.babylonhealth.model;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, ObjectId> {

  Optional<Article> findOneByContentLike(String content);
}
