package com.frost_fox.jenkins.job_addon;

import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class ResultAssert extends AbstractAssert<ResultAssert, Result<?>> {
    private Result result;

    private ResultAssert(Result result) {
        super(result, ResultAssert.class);
        this.result = result;
    }

    public static ResultAssert assertThat(Result result) {
        return new ResultAssert(result);
    }

    @SuppressWarnings("UnusedReturnValue")
    public ResultAssert successfulWith(Object item) {
        isNotNull();
        successful();
        with(item);

        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public ResultAssert failedWith(Object item) {
        isNotNull();
        failed();
        with(item);

        return this;
    }

    @SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
    public ResultAssert successful() {
        isNotNull();

        if(!result.successful()){
            failWithMessage("Expected result to be successful");
        }

        return this;
    }

    @SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
    public ResultAssert failed() {
        isNotNull();

        if(result.successful()){
            failWithMessage("Expected result to be failed");
        }

        return this;
    }

    private void with(Object item) {
        if (!Objects.equals(result.get(), item)) {
            failWithMessage("Expected result to contain <%s> but was <%s>", result.get(), item);
        }
    }

}

