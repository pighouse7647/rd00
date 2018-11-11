package com.softleader.rd01.repository;

import com.softleader.rd01.entity.SequenceId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sequence", path = "sequence")
public interface SequenceIdRepository extends MongoRepository<SequenceId, String> {

  SequenceId findFirstById(String id);
  SequenceId findFirstByIdOrderBySeqDesc(String id);
}
