package algorithms;

import java.util.List;

import domain.PRFunction;
import domain.axioms.ProjectionFunction;
import domain.axioms.SuccessorFunction;
import domain.axioms.ZeroFunction;
import domain.operands.ComposedFunction;
import domain.operands.RecursiveFunction;

public class PowFactory {
  public static PRFunction create() {
    PRFunction mult = MultiplicationFactory.create();

    // pow(x, 0) = S(Z(x, 0)) = 1
    PRFunction baseCase = new ComposedFunction(
      new SuccessorFunction(),
      List.of(new ZeroFunction())
    );

    // pow(x, S(y)) = mult(P_0(x, y, pow(x, y)), P_2(x, y, pow(x, y))) = mult(x, pow(x, y))
    PRFunction recursiveCase = new ComposedFunction(
      mult,
      List.of(
        new ProjectionFunction(0),
        new ProjectionFunction(2)
      )
    );

    return new RecursiveFunction(baseCase, recursiveCase);
  }
}
