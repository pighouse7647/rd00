package com.softleader.rd01.repository;

import com.softleader.rd01.entity.CustomizedEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "customized", path = "customized")
public interface CustomizedRepository extends MongoRepository<CustomizedEntity, Long> {

  CustomizedEntity findFirstByKey(@Param("key") String key);

  CustomizedEntity findByKeyAndName(@Param("key") String key, @Param("name") String name);

  List<CustomizedEntity> findByNameLike(@Param("name")String name);

//  Supports native JSON query string
  @Query("{key:'?0'}")
  CustomizedEntity findCustomByKey(@Param("key") String key);

  @Query("{key: { $regex: ?0 } })")
  List<CustomizedEntity> findCustomByRegExKey(@Param("key")String key);



  CustomizedEntity save(@Param("form") CustomizedEntity form);
}
