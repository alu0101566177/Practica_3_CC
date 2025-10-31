package domain.operands;

import java.util.ArrayList;
import java.util.List;

import domain.PRFunction;

public class RecursiveFunction implements PRFunction {
  private final PRFunction baseCase;
  private final PRFunction recursiveCase;

  public RecursiveFunction(PRFunction baseCase, PRFunction recursiveCase) {
    this.baseCase = baseCase;
    this.recursiveCase = recursiveCase;
  }

  public Integer eval(List<Integer> args) {
    List<Integer> reducedArgs = args.subList(0, args.size() - 1);
    Integer last = args.getLast();

    if (last == 0) return baseCase.eval(args);

    List<Integer> internalArgs = new ArrayList<>(reducedArgs);
    internalArgs.add(last - 1);
    // f(x_1, x_2, ..., x_n - 1)
    Integer internalResult = eval(internalArgs);

    List<Integer> recursiveArgs = new ArrayList<>(reducedArgs);
    recursiveArgs.add(last - 1);
    recursiveArgs.add(internalResult);

    // f(x_1, x_2, ..., x_n) = recursiveCase(x_1, x_2, ..., x_n, f(x_1, x_2, ..., x_n - 1))
    return recursiveCase.eval(recursiveArgs);
  }
}
