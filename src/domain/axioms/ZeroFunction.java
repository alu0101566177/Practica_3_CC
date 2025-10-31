package domain.axioms;

import java.util.List;

import domain.PRFunction;

/**
 * Función cero (axioma): siempre devuelve 0 independientemente de los
 * argumentos.
 *
 * <p>Usada como función base en construcciones de funciones primitivo-recursivas.</p>
 */
public class ZeroFunction extends PRFunction {
  /**
   * Devuelve siempre 0.
   *
   * @param args lista de argumentos (se ignoran)
   * @return 0
   */
  protected Integer _eval(List<Integer> args) {
    return 0;    
  }
}
