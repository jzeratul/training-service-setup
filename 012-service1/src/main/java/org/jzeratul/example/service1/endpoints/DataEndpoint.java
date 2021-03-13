package org.jzeratul.example.service1.endpoints;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jzeratul.example.service1.api.Service1DataApi;
import org.jzeratul.example.service1.model.S1DataObject;
import org.jzeratul.example.service2.client.api.Service2DataApiClient;
import org.jzeratul.example.service2.client.model.S2DataObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DataEndpoint implements Service1DataApi {

  private final Service2DataApiClient service2DataApiClient;

  @Override
  public ResponseEntity<List<S1DataObject>> getData() {

    log.debug("In service1, calling service2");
    final List<S2DataObject> data = service2DataApiClient.getData().getBody();
    log.info("Received {} object from service2", data.size());

    return ResponseEntity.ok(
            data.stream()
                    .map(
                            s2do -> S1DataObject.builder()
                                    .value(s2do.getValue())
                                    .contents(s2do.getContents())
                                    .build()
                    )
                    .collect(Collectors.toList()));
  }
}
