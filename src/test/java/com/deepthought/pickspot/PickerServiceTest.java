package com.deepthought.pickspot;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.deepthought.pickspot.model.Container;
import com.deepthought.pickspot.model.Slot;
import com.deepthought.pickspot.services.PickerService;

public class PickerServiceTest {
  private final PickerService picker = new PickerService();

  @Test
  void yardFullReturnsEmpty() {
      Container c = new Container("X", "small", false, 0, 0);
      List<Slot> fullYard = List.of(new Slot(0, 1, "small", false, true));
      assertTrue(picker.chooseBestSlot(c, fullYard).isEmpty());
  }
}
