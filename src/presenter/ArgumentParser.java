package presenter;

import java.util.ArrayList;
import java.util.List;

public class ArgumentParser {
  public static final String VERSION = "0.1.0";

  public static class Result {
    public final List<int[]> pairs = new ArrayList<>();
    public boolean showHelp = false;
    public boolean showVersion = false;
    public String error = null;
  }

  public static Result parse(String[] args) {
    Result r = new Result();

    for (int i = 0; i < args.length; i++) {
      String a = args[i];
      if ("-h".equals(a) || "--help".equals(a)) {
        r.showHelp = true;
        return r;
      }
      if ("-v".equals(a) || "--version".equals(a)) {
        r.showVersion = true;
        return r;
      }

      if (a.startsWith("--pair=")) {
        String val = a.substring("--pair=".length());
        if (!parseAndAddPair(val, r)) return r;
        continue;
      }

      if ("-p".equals(a)) {
        if (i + 1 >= args.length) {
          r.error = "La opción -p requiere un argumento en forma x,y";
          return r;
        }
        String val = args[++i];
        if (!parseAndAddPair(val, r)) return r;
        continue;
      }

      r.error = "Argumento no reconocido: " + a;
      return r;
    }

    return r;
  }

  private static boolean parseAndAddPair(String token, Result r) {
    String[] parts = token.split(",");
    if (parts.length != 2) {
      r.error = "Par inválido (usar x,y): " + token;
      return false;
    }
    try {
      int x = Integer.parseInt(parts[0]);
      int y = Integer.parseInt(parts[1]);
      if (x < 0 || y < 0) {
        r.error = "Los valores deben ser enteros no negativos: " + token;
        return false;
      }
      r.pairs.add(new int[] { x, y });
      return true;
    } catch (NumberFormatException ex) {
      r.error = "Los valores deben ser enteros: " + token;
      return false;
    }
  }

  public static void printUsage() {
    System.out.println("Uso: java presenter.App [OPCIONES]\n\n" +
      "Calcula pow(x,y) para uno o varios pares usando funciones recursivas primitivas.\n\n" +
      "Opciones:\n" +
      "  -h, --help         Muestra esta ayuda\n" +
      "  -v, --version      Muestra la versión\n" +
      "  -p, --pair x,y     Añade un par (x,y). Puede repetirse para múltiples pares.\n\n" +
      "Ejemplo:\n" +
      "  java presenter.App -p 2,3 -p 4,2\n");
  }
}
