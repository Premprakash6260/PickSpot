package com.deepthought.pickspot.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PickResponse {
  private String containerId;
  private int targetX;
  private int targetY;
}
