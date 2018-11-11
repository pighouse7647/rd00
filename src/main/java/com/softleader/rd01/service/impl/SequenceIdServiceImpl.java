package com.softleader.rd01.service.impl;

import com.softleader.rd01.entity.SequenceId;
import com.softleader.rd01.exception.SequenceException;
import com.softleader.rd01.repository.SequenceIdRepository;
import com.softleader.rd01.service.SequenceIdService;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


/**
 * 取Sequence邏輯
 */
@Service
public class SequenceIdServiceImpl implements SequenceIdService {


  private SequenceIdRepository repository;
  private MongoOperations mongoOperation;


  public SequenceIdServiceImpl(SequenceIdRepository repository, MongoOperations mongoOperation) {
    this.repository = repository;
    this.mongoOperation = mongoOperation;
  }


  @Override
  public Long getNextSequenceId(String key) {
    //get sequence id
    Query query = new Query(Criteria.where("_id").is(key));

    //increase sequence id by 1
    Update update = new Update();
    update.inc("seq", 1);

    //return new increased id
    FindAndModifyOptions options = new FindAndModifyOptions();
    options.returnNew(true);

    //this is the magic happened.
    SequenceId seqId =
        mongoOperation.findAndModify(query, update, options, SequenceId.class);

    //if no id, throws SequenceException
    //optional, just a way to tell user when the sequence id is failed to generate.
    if (seqId == null) {
      throw new SequenceException("Unable to get sequence id for key : " + key);
    }

    return seqId.getSeq();
  }
}
