package com.softleader.rd01.service.impl;

import com.softleader.rd01.entity.CustomizedEntity;
import com.softleader.rd01.repository.CustomizedRepository;
import com.softleader.rd01.service.CustomizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomizedServiceImpl implements CustomizedService {

  private CustomizedRepository repository;

  @Autowired
  public CustomizedServiceImpl(CustomizedRepository repository) {
    this.repository = repository;
  }


  @Override
  public Mono<CustomizedEntity> insert(CustomizedEntity form) {
    return Mono.just(repository.save(form));
  }

  @Override
  public Mono<CustomizedEntity> update(CustomizedEntity form) {
    return Mono.just(repository.save(form));
  }

  @Override
  public Mono<CustomizedEntity> getOne(Long id) {
    return Mono.justOrEmpty(repository.findById(id));
  }

  @Override
  public Mono<CustomizedEntity> getByKey(String key) {
    return Mono.justOrEmpty(repository.findFirstByKey(key));
  }

  @Override
  public Flux<CustomizedEntity> getByName(String name) {
    return Flux.fromIterable(repository.findByNameLike(name));
  }

  @Override
  public Flux<CustomizedEntity> getAll() {
    return Flux.fromIterable(repository.findAll());
  }

  @Override
  public Mono<CustomizedEntity> delete(CustomizedEntity form) {
    repository.delete(form);
    return Mono.justOrEmpty(form);
  }
}
