package components.verify;

public interface SwingInitializer<T> {
    void init();
    void addListeners(T ctrl);
}
