package com.deepthought.pickspot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Container {
  private String id;
  private String size;
  private boolean needsCold;
  private int x;
  private int y;
}
