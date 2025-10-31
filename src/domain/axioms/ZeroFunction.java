package domain.axioms;

import java.util.List;

import domain.PRFunction;

public class ZeroFunction extends PRFunction {
  protected Integer _eval(List<Integer> args) {
    return 0;    
  }
}
