package domain.operands;

import java.util.List;

import domain.PRFunction;

public class ComposedFunction implements PRFunction {
  private final PRFunction root;
  private final List<PRFunction> childs;
  
  public ComposedFunction(PRFunction root, List<PRFunction> childs) {
    this.root = root;
    this.childs = childs;
  }

  public Integer eval(List<Integer> args) {
    return root.eval(
      childs
        .stream()
        .map(function -> function.eval(args))
        .toList()
    );
  }
}
