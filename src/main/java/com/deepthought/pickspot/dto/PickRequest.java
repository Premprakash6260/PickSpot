package com.deepthought.pickspot.dto;
import java.util.List;
import com.deepthought.pickspot.model.Slot;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.deepthought.pickspot.model.Container;
import com.deepthought.pickspot.model.Slot;

@Data
@NoArgsConstructor
public class PickRequest {
  private Container container;
  private List<Slot> yardMap;
}
