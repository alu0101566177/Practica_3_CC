package algorithms;

import java.util.List;

import domain.PRFunction;
import domain.axioms.ProjectionFunction;
import domain.axioms.ZeroFunction;
import domain.operands.ComposedFunction;
import domain.operands.RecursiveFunction;

public class MultiplicationFactory {
  public static PRFunction create() {
    PRFunction add = SumFactory.create();

    // mult(x, 0) = 0
    PRFunction baseCase = new ZeroFunction();

    // mult(x, S(y)) = add(P_0(x, y, mult(x, y)), P_2(x, y, mult(x, y))) = add(x, mult(x, y))
    PRFunction recursiveCase = new ComposedFunction(
      add,
      List.of(
        new ProjectionFunction(0), // x
        new ProjectionFunction(2) // mult(x, y)
      )
    );

    return new RecursiveFunction(baseCase, recursiveCase);
  }
}
