package bean;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean result;
    private Object message;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", message=" + message +
                '}';
    }
}
