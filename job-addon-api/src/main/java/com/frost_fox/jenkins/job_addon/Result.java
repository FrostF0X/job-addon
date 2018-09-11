package com.frost_fox.jenkins.job_addon;

public class Result<T> {

    private final boolean success;
    private final T item;
    private final String cause;

    private Result(boolean success, T item, String cause) {
        this.success = success;
        this.item = item;
        this.cause = cause;
    }

    @SuppressWarnings("unused")
    public boolean isSuccess() {
        return success;
    }

    @SuppressWarnings("unused")
    public T getItem() {
        return item;
    }


    public String getCause() {
        return cause;
    }

    public static Result failedWith(String cause) {
        return new Result<>(false, null, cause);
    }

    public static <E> Result<E> successfulWith(E item) {
        return new Result<>(true, item, "");
    }

    public boolean successful() {
        return success;
    }

    public T get() {
        return item;
    }
}
