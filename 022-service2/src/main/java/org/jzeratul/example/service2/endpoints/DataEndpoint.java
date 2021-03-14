package org.jzeratul.example.service2.endpoints;

import lombok.extern.slf4j.Slf4j;
import org.jzeratul.example.service2.api.Service2DataApi;
import org.jzeratul.example.service2.model.S2DataObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class DataEndpoint implements Service2DataApi {

  @Override
  public ResponseEntity<List<S2DataObject>> getData() {

    int capacity = getRandomNumberUsingThreadLocal(10);
    if (capacity < 0) {
      capacity = -1 * capacity;
    }

    int min = getRandomNumberUsingThreadLocal(100);
    int max = getRandomNumberUsingThreadLocal(100);

    log.info("Generating {} random numbers between {} and {}", capacity, min, max);

    var results = new Random().doubles(capacity, -min, max)
            .sorted()
            .boxed()
            .map(r -> S2DataObject.builder()
                    .value(r)
                    .contents("Useless string value " + r)
                    .build())
            .collect(Collectors.toList());

    return ResponseEntity.ok(results);
  }

  private int getRandomNumberUsingThreadLocal(int bound) {
    return ThreadLocalRandom.current().nextInt(bound);
  }

}
