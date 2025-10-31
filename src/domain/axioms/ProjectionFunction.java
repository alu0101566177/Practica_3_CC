package domain.axioms;

import java.util.List;

import domain.PRFunction;

/**
 * Función proyección (axioma): devuelve el i-ésimo argumento de la lista de
 * entrada.
 *
 * <p>Se construye con un índice {@code index} y su evaluación devuelve
 * {@code args[index]}. La clase asume índices 0-based.</p>
 */
public class ProjectionFunction extends PRFunction {
  private final Integer index;

  /**
   * Crea una función proyección con el índice dado.
   *
   * @param index índice (0-based) del argumento a devolver; debe ser >= 0
   */
  public ProjectionFunction(Integer index) {
    assert index >= 0;
    this.index = index;
  }

  /**
   * Devuelve el argumento en la posición {@link #index} de la lista.
   *
   * @param args lista de argumentos; debe contener al menos {@code index+1}
   *             elementos
   * @return el valor en {@code args[index]}
   */
  protected Integer _eval(List<Integer> args) {
    assert args.size() > index;
    return args.get(index);
  }
}
