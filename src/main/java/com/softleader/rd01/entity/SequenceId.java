package com.softleader.rd01.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Entity
@Document(collection = "sequence")
public class SequenceId {
  @Id
  private String id;

  private Long seq;



}
