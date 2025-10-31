package domain;

public class CallController {
  private static int calls = 0;
  
  public static void reset() {
    calls = 0;
  }

  public static void registerCall() {
    calls++;
  }

  public static int getCalls() {
    return calls;
  }
}
