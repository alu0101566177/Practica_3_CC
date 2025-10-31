package domain.axioms;

import java.util.List;

import domain.PRFunction;

public class SuccessorFunction extends PRFunction {
  protected Integer _eval(List<Integer> args) {
    assert args.size() == 1;
    return args.getFirst() + 1;
  }
}