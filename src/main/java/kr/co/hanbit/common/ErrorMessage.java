package kr.co.hanbit.common;

import java.util.List;

public class ErrorMessage {
    private final List<String> errors;
    public ErrorMessage(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
