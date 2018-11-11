package com.softleader.rd01.service;

import com.softleader.rd01.entity.CustomizedEntity;
import java.util.Optional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomizedService {


  Mono<CustomizedEntity> insert(CustomizedEntity form);
  Mono<CustomizedEntity> update(CustomizedEntity form);
  Mono<CustomizedEntity> getOne(Long id);
  Mono<CustomizedEntity> getByKey(String key);
  Flux<CustomizedEntity> getByName(String name);
  Flux<CustomizedEntity> getAll();
  Mono<CustomizedEntity> delete(CustomizedEntity form);







}
