package com.softleader.rd01.web;

import com.softleader.rd01.entity.CustomizedEntity;
import com.softleader.rd01.service.CustomizedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/customized")
public class CustomizedController {

private CustomizedService service;

  public CustomizedController(CustomizedService service) {
    this.service = service;
  }


  @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "資料格式不正確")
  @ExceptionHandler(InvalidDataAccessApiUsageException.class)
  public void invalidDataAccess() {
    log.error("資料格式不正確",  "資料格式不正確");
  }


  @GetMapping("/all")
  public Flux<CustomizedEntity> list() {
    return this.service.getAll();
  }

  @PostMapping("/save")
  public Mono<CustomizedEntity> save(@RequestBody final CustomizedEntity customizedEntity) {
    return this.service.insert(customizedEntity);
  }

  @PostMapping("/insert")
  public Mono<CustomizedEntity> insert(@RequestBody final CustomizedEntity customizedEntity) {

    WebClient client = WebClient.create();

    Mono<CustomizedEntity> createdCustomizedEntity = client
        .post()
        .uri("http://localhost:8080/customized/save")
        .accept(MediaType.APPLICATION_JSON)
        .body(Mono.just(customizedEntity), CustomizedEntity.class)
        .exchange()
        .flatMap(res -> res.bodyToMono(CustomizedEntity.class))
;
    return createdCustomizedEntity;
  }

}
