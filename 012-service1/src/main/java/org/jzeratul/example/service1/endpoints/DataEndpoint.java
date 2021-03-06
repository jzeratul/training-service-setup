package org.jzeratul.example.service1.endpoints;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jzeratul.example.service1.api.DataApi;
import org.jzeratul.example.service1.model.DataObject;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Builder
@Slf4j
@Data
public class DataEndpoint implements DataApi {

  @Override
  public ResponseEntity<List<DataObject>> getData() {







    return null;
  }
}
