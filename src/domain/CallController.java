package domain;

/**
 * Controlador simple de contadores de llamadas a funciones.
 *
 * <p>Esta clase mantiene un contador estático que registra cuántas veces se
 * han invocado funciones (vía {@link domain.PRFunction#eval(List)}), lo que
 * permite obtener métricas sencillas sobre recursión/llamadas durante la
 * ejecución.</p>
 */
public class CallController {
  private static int calls = 0;
  
  /**
   * Reinicia el contador de llamadas a cero.
   */
  public static void reset() {
    calls = 0;
  }

  /**
   * Incrementa el contador para registrar una nueva llamada.
   *
   * <p>Este método es usado por {@link domain.PRFunction#eval(List)} antes de
   * delegar la evaluación real de cada función.</p>
   */
  public static void registerCall() {
    calls++;
  }

  /**
   * Obtiene el número total de llamadas registradas.
   *
   * @return número de invocaciones registradas
   */
  public static int getCalls() {
    return calls;
  }
}
