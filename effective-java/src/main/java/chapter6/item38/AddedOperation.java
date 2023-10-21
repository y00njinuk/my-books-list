package chapter6.item38;

// Emulated extensible enum (Pages 176-9)
public enum AddedOperation implements Operation {
    EXP("++") {
        public double apply(double x, double y) {
            return x + y;
        }
    };
    private final String symbol;
    AddedOperation(String symbol) {
        this.symbol = symbol;
    }
    @Override public String toString() {
        return symbol;
    }
}
