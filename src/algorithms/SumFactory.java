package algorithms;

import java.util.List;

import domain.PRFunction;
import domain.axioms.ProjectionFunction;
import domain.axioms.SuccessorFunction;
import domain.operands.ComposedFunction;
import domain.operands.RecursiveFunction;

public class SumFactory {
  public static PRFunction create() {
    // add(x, 0) = x
    PRFunction baseCase = new ProjectionFunction(0);
    
    // add(x, S(y)) = S(P_2(x, y, add(x, y)))
    PRFunction recurisiveCase = new ComposedFunction(
      new SuccessorFunction(),
      List.of(new ProjectionFunction(2))
    );

    return new RecursiveFunction(baseCase, recurisiveCase);
  }
}
