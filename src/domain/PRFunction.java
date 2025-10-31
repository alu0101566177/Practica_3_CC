package domain;

import java.util.List;

public abstract class PRFunction {
  public Integer eval(List<Integer> args) {
    CallController.registerCall();
    return _eval(args);
  }

  protected abstract Integer _eval(List<Integer> args);
}