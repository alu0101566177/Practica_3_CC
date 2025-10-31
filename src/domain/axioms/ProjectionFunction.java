package domain.axioms;

import java.util.List;

import domain.PRFunction;

public class ProjectionFunction implements PRFunction {
  private final Integer index;

  public ProjectionFunction(Integer index) {
    assert index >= 0;
    this.index = index;
  }

  public Integer eval(List<Integer> args) {
    assert args.size() > index;
    return args.get(index);
  }
}
