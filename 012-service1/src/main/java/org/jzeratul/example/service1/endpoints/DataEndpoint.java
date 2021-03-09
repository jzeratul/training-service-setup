package org.jzeratul.example.service1.endpoints;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jzeratul.example.service1.api.DataApi;
import org.jzeratul.example.service1.model.DataObject;
import org.jzeratul.example.service2.client.api.Data2Api;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Builder
@Slf4j
@Data
@RequiredArgsConstructor
public class DataEndpoint implements DataApi {

  private final Data2Api data2Api;

  @Override
  public ResponseEntity<List<DataObject>> getData() {

    log.info("Calling service2");
    final ResponseEntity<List<org.jzeratul.example.service2.client.model.DataObject>> dataWithHttpInfo = data2Api.getDataWithHttpInfo();


    return null;
  }
}
