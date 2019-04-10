package com.edwinnyawoli.templateapplication.data.remote;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 *
 */

public interface Api {
    /**
     *
     */

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @interface BaseUrl {
    }
}
