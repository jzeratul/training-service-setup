package org.jzeratul.example.service2.endpoints;

import lombok.extern.slf4j.Slf4j;
import org.jzeratul.example.service2.api.DataApi;
import org.jzeratul.example.service2.model.DataObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
public class DataEndpoint implements DataApi {

  @Override
  public ResponseEntity<List<DataObject>> getData() {

    int capacity = getRandomNumberUsingThreadLocal(1000);
    if (capacity < 0) {
      capacity = -1 * capacity;
    }

    int min = getRandomNumberUsingThreadLocal(100);
    int max = getRandomNumberUsingThreadLocal(Integer.MAX_VALUE);

    log.info("Generating {} random numbers between {} and {}", capacity, min, max);

    var results = new Random().doubles(capacity, min, max)
            .sorted()
            .boxed()
            .map(r -> DataObject.builder()
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
