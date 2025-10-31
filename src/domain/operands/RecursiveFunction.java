package domain.operands;

import java.util.ArrayList;
import java.util.List;

import domain.PRFunction;

/**
 * Función recursiva primitiva: definida por un caso base y un caso recursivo.
 *
 * <p>Semántica informal:
 * f(x1, ..., xn) =
 *   baseCase(x1, ..., x_{n-1})           si x_n == 0
 *   recursiveCase(x1, ..., x_{n-1}, x_n-1, f(x1,...,x_n-1))  en otro caso
 * </p>
 */
public class RecursiveFunction extends PRFunction {
  private final PRFunction baseCase;
  private final PRFunction recursiveCase;

  /**
   * Crea una función recursiva con su caso base y caso recursivo.
   *
   * @param baseCase función que maneja el caso base (x_n == 0)
   * @param recursiveCase función que combina el resultado recursivo con los
   *                      argumentos para producir el resultado final
   */
  public RecursiveFunction(PRFunction baseCase, PRFunction recursiveCase) {
    this.baseCase = baseCase;
    this.recursiveCase = recursiveCase;
  }

  /**
   * Evalúa la función recursiva para la lista de argumentos dada.
   *
   * <p>Se asume que el último elemento de {@code args} es el parámetro de
   * recursión (n). El método construye las llamadas recursivas necesarias y
   * aplica {@code recursiveCase} para combinar los resultados.</p>
   *
   * @param args lista de argumentos donde el último elemento es el recursor
   * @return resultado de la evaluación recursiva
   */
  protected Integer _eval(List<Integer> args) {
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
