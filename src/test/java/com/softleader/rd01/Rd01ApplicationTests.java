package com.softleader.rd01;

import com.softleader.rd01.entity.CustomizedEntity;
import com.softleader.rd01.repository.CustomizedRepository;
import com.softleader.rd01.service.CustomizedService;
import com.softleader.rd01.service.impl.CustomizedServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class Rd01ApplicationTests {

  @Autowired CustomizedService service;


  @Test
  public void contextLoads() {
    CustomizedEntity form = new CustomizedEntity();
    form.setKey("5");
    form.setName("Dennis");
    form.setId(5L);
    service.insert(form);
  }

}
