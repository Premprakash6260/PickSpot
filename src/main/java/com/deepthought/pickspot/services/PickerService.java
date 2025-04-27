package com.deepthought.pickspot.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.deepthought.pickspot.model.Slot;
import com.deepthought.pickspot.model.Container;

@Service
public class PickerService {
  private static final int INVALID = 10_000;

  public Optional<Slot> chooseBestSlot(Container c, List<Slot> slots) {
    Slot best = null;
    int bestScore = INVALID + 1;

    for (Slot s : slots) {
        int score = score(c, s);
        if (score < bestScore) {
            bestScore = score;
            best = s;
        }
    }
    return bestScore >= INVALID ? Optional.empty() : Optional.of(best);
  }

  private int score(Container c, Slot s) {
    int distance = Math.abs(c.getX() - s.getX()) + Math.abs(c.getY() - s.getY());
    int sizePenalty = (c.getSize().equals("big") && s.getSizeCap().equals("small")) ? INVALID : 0;
    int coldPenalty = (c.isNeedsCold() && !s.isHasColdUnit()) ? INVALID : 0;
    int occPenalty = s.isOccupied() ? INVALID : 0;

    return distance + sizePenalty + coldPenalty + occPenalty;
  }
}
