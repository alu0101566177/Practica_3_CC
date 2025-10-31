package domain.axioms;

import java.util.List;

import domain.PRFunction;

/**
 * Función sucesora (axioma): toma un único argumento n y devuelve n+1.
 *
 * <p>Se espera una lista de aridad 1; la implementación actual usa {@code assert}
 * para comprobarlo.</p>
 */
public class SuccessorFunction extends PRFunction {
  /**
   * Devuelve el sucesor del único argumento proporcionado.
   *
   * @param args lista de un único {@link Integer}
   * @return args[0] + 1
   */
  protected Integer _eval(List<Integer> args) {
    assert args.size() == 1;
    return args.getFirst() + 1;
  }
}