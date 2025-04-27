package com.deepthought.pickspot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
  private int x;
  private int y;
  private String sizeCap;
  private boolean hasColdUnit;
  private boolean occupied;
}
