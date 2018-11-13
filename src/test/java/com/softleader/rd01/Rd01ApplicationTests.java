package com.softleader.rd01;

import com.softleader.rd01.entity.CustomizedEntity;
import com.softleader.rd01.entity.SequenceId;
import com.softleader.rd01.repository.CustomizedRepository;
import com.softleader.rd01.service.CustomizedService;
import com.softleader.rd01.service.SequenceIdService;
import com.softleader.rd01.service.impl.CustomizedServiceImpl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class Rd01ApplicationTests {

  @Autowired CustomizedService service;

  @Test
  public void contextLoads() {
    List<String> names = Arrays.asList("Thomas", "Willy", "Tim", "Dennis", "Sunny", "Naomi", "Gary");

    names
        .forEach(name -> {
          CustomizedEntity form = new CustomizedEntity();
          form.setKey(UUID.randomUUID().toString());
          form.setName(name);
          form.setAmount(BigDecimal.valueOf(10000).multiply(BigDecimal.valueOf(names.indexOf(name)+1)));
          form.setValue(BigDecimal.valueOf(Math.random()*5*1000000));
          service.insert(form);
        });
  }

  @Test
  public void testDelete() {
    List<String> names = Arrays.asList("Thomas", "Willy", "Tim", "Dennis", "Sunny", "Naomi", "Gary");
    names.forEach(name -> {
      Flux<CustomizedEntity> byName = service.getAll();
      Mono<List<CustomizedEntity>> listMono = byName.map(a -> a).collectList();
      listMono.block().forEach(a -> {
        service.delete(a);
      });
    });




  }

}
