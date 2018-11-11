package com.softleader.rd01.entity;


import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Entity
@Document(collection = "customized")
public class CustomizedEntity {

  @Id
  private Long id;

  @Indexed(unique = true)
  private String key;

  private String name;


}
