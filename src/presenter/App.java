package presenter;

import java.util.List;

import algorithms.PowFactory;
import domain.PRFunction;
import domain.CallController;

public class App {
  public static void main(String[] args) {
    ArgumentParser.Result res = ArgumentParser.parse(args);

    if (res.showHelp) {
      ArgumentParser.printUsage();
      return;
    }
    if (res.showVersion) {
      System.out.println("presenter.App version " + ArgumentParser.VERSION);
      return;
    }
    if (res.error != null) {
      System.err.println(res.error);
      ArgumentParser.printUsage();
      return;
    }

    if (res.pairs.isEmpty()) {
      System.err.println("No se proporcionaron pares. Usa -p x,y para pasar pares.");
      ArgumentParser.printUsage();
      return;
    }

    PRFunction pow = PowFactory.create();

    for (int[] pair : res.pairs) {
      int x = pair[0];
      int y = pair[1];
      try {
        CallController.reset();
        Integer result = pow.eval(List.of(x, y));
        System.out.println(String.format("pow(%d, %d) = %d -- Calls %d\n", x, y, result, CallController.getCalls()));
      } catch (StackOverflowError e) {
        System.err.println(String.format("Stack overflow in pow(%d, %d)", x, y));
        System.err.println(String.format("With stacktrace length = %d\n", e.getStackTrace().length));
      }
    }
  }
}
