package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Element cannot be null.");
    }

  public NullNotAllowedException(String message) {
      super(message);
  }
}
