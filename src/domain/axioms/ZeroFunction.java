package domain.axioms;

import java.util.List;

import domain.PRFunction;

public class ZeroFunction implements PRFunction {
  public Integer eval(List<Integer> args) {
    return 0;    
  }
}
