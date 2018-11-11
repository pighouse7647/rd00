package com.softleader.rd01;

import com.softleader.rd01.entity.CustomizedEntity;
import com.softleader.rd01.entity.SequenceId;
import com.softleader.rd01.repository.CustomizedRepository;
import com.softleader.rd01.repository.SequenceIdRepository;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Rd01Application {

  public static void main(String[] args) {
    SpringApplication.run(Rd01Application.class, args);
  }

  @Bean
  CommandLineRunner init(CustomizedRepository repository) {
    return args -> {

//			CustomizedEntity customizedEntity = new CustomizedEntity();
//			customizedEntity.setName("thomas");
//			customizedEntity.setKey(UUID.randomUUID().toString());
//			CustomizedEntity obj = repository.save(customizedEntity);
//			System.out.println("開啟Service新增一筆資料" + obj.toString());

    };
  }

  /*
  @Bean
  CommandLineRunner init2(SequenceIdRepository repository) {
    return args -> {
      SequenceId sequenceId = new SequenceId();
			sequenceId.setSeq(0L);
			sequenceId.setId("sequence");
      SequenceId obj = repository.save(sequenceId);
			System.out.println("開啟Service新增一筆資料" + obj.toString());

    };
  }*/
}
