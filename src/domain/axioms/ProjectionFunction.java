package domain.axioms;

import java.util.List;

import domain.PRFunction;

public class ProjectionFunction extends PRFunction {
  private final Integer index;

  public ProjectionFunction(Integer index) {
    assert index >= 0;
    this.index = index;
  }

  protected Integer _eval(List<Integer> args) {
    assert args.size() > index;
    return args.get(index);
  }
}
