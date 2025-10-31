package domain.operands;

import java.util.List;

import domain.PRFunction;

/**
 * Función compuesta: aplica una lista de funciones (childs) a los mismos
 * argumentos, toma sus resultados y se los pasa como argumentos a la
 * función root.
 *
 * <p>Semántica: root(child1(args...), child2(args...), ...)</p>
 */
public class ComposedFunction extends PRFunction {
  private final PRFunction root;
  private final List<PRFunction> childs;
  
  /**
   * Construye una función compuesta.
   *
   * @param root   función que recibirá los resultados de las funciones child
   * @param childs lista de funciones que se evaluarán con los mismos argumentos
   */
  public ComposedFunction(PRFunction root, List<PRFunction> childs) {
    this.root = root;
    this.childs = childs;
  }

  /**
   * Evalúa cada función child con {@code args}, crea una lista con sus
   * resultados y pasa esa lista como argumentos a {@code root}.
   *
   * @param args argumentos de entrada para las funciones child
   * @return resultado de evaluar {@code root} con los resultados de los childs
   */
  protected Integer _eval(List<Integer> args) {
    return root.eval(
      childs
        .stream()
        .map(function -> function.eval(args))
        .toList()
    );
  }
}
