package org.jzeratul.example.service1.endpoints;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jzeratul.example.service1.api.Service1DataApi;
import org.jzeratul.example.service1.model.S1DataObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Builder
@Slf4j
@Data
@RequiredArgsConstructor
public class DataEndpoint implements Service1DataApi {

//  private final Data2Api data2Api;

  @Override
  public ResponseEntity<List<S1DataObject>> getData() {

    log.info("Calling service2");
//    final ResponseEntity<List<org.jzeratul.example.service2.client.model.DataObject>> dataWithHttpInfo = data2Api.getDataWithHttpInfo();


    return null;
  }
}
