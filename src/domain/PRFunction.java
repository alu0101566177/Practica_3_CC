package domain;

import java.util.List;

/**
 * Representa una función primitiva recursiva (PR) genérica.
 *
 * <p>Las implementaciones concretas deben proporcionar la lógica de evaluación
 * sobrescribiendo el método protegido {@link #_eval(List)}. La llamada pública
 * {@link #eval(List)} envuelve la llamada a la implementación concreta y
 * registra la invocación en {@link CallController}.</p>
 *
 * <p>Contrato resumido:
 * <ul>
 *   <li>Entrada: una lista de argumentos {@code List<Integer>} que dependen de la
 *   función concreta.</li>
 *   <li>Salida: un {@code Integer} con el resultado de la evaluación.</li>
 *   <li>Modo de error: las implementaciones pueden usar {@code assert} para
 *   validar aridades/condiciones dentro de {@link #_eval(List)}.</li>
 * </ul>
 * </p>
 */
public abstract class PRFunction {
  /**
   * Evalúa la función con los argumentos proporcionados.
   *
   * <p>Este método registra la invocación llamando a {@link CallController#registerCall()}
   * y delega la evaluación real a {@link #_eval(List)}.</p>
   *
   * @param args lista de argumentos (no debe ser {@code null} salvo que la
   *             implementación concrete lo permita)
   * @return el resultado de la evaluación como {@link Integer}
   */
  public Integer eval(List<Integer> args) {
    CallController.registerCall();
    return _eval(args);
  }

  /**
   * Implementación concreta de la evaluación de la función.
   *
   * <p>Las subclases deben implementar la lógica real aquí. Se asume que
   * cualquier validación de aridad/argumentos se realiza dentro de esta
   * implementación (por ejemplo, usando {@code assert}).</p>
   *
   * @param args lista de argumentos
   * @return el resultado de la evaluación
   */
  protected abstract Integer _eval(List<Integer> args);
}