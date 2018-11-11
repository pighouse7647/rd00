package com.softleader.rd01.generator;

import com.softleader.rd01.service.SequenceIdService;
import org.springframework.data.mongodb.core.mapping.Document;

public interface CrudIdGeneratable<T> {

  default Long getNextSequenceId(SequenceIdService sequenceIdService, T form) {
    return sequenceIdService.getNextSequenceId(form.getClass().getAnnotation(Document.class).collection());
  }


}
