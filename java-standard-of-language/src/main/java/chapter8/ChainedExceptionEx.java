package chapter8;

public class ChainedExceptionEx {
    public static void main(String[] args) {
        // Unchecked Exception 을 반환하므로 try-catch 절을 구현할 필요가 없음.
        install();
    }
    static void install() throws UncheckedException {
        try {
            // Checked Exception 을 반환하므로 반드시, try-catch 절을 구현하여야 한다.
            startInstall();
            copyFiles();
        } catch (SpaceException | MemoryException e) {
            UncheckedException ie = new UncheckedException("설치 중 예외 발생");
            ie.initCause(e);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }
    static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace()) throw new SpaceException("설치할 공간이 부족합니다.");
        if(!enoughMemory()) throw new MemoryException("메모리가 부족합니다.");
    }
    static void copyFiles() { /* do something. */ }
    static void deleteTempFiles() { /* do something. */ }
    static boolean enoughSpace() { return false; }
    static boolean enoughMemory() { return true; }
}

// RuntimeException 을 상속받으면 Unchecked Exception 을 구현할 수 있다.
class UncheckedException extends RuntimeException { UncheckedException(String msg) { super(msg); }}
class SpaceException extends Exception { SpaceException(String msg) { super(msg); }}
class MemoryException extends Exception { MemoryException(String msg) { super(msg); }}