package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // SampleVO(Integer, String, String)
@NoArgsConstructor // SampleVO()
public class SampleVO {

  private Integer mno;
  private String firstName;
  private String lastName;

}
