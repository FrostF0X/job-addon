package com.frost_fox.jenkins.job_addon;

public class Result<T> {

    private final boolean success;
    private final T item;

    private Result(boolean success, T item) {
        this.success = success;
        this.item = item;
    }

    @SuppressWarnings("unused")
    public boolean isSuccess() {
        return success;
    }

    @SuppressWarnings("unused")
    public T getItem() {
        return item;
    }

    public static <E> Result<E> failedWith(E item) {
        return new Result<>(false, item);
    }

    public static <E> Result<E> successfulWith(E item) {
        return new Result<>(true, item);
    }

    public boolean successful() {
        return success;
    }

    public T get() {
        return item;
    }
}
