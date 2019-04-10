/*
 * Copyright 2018 Edwin Nyawoli
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.edwinnyawoli.templateapplication.common.concurrency;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
@Module
public class SchedulersModule {
    @Provides
    @IO
    public static Scheduler providesIOScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Computation
    public static Scheduler providesComputationScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Trampoline
    public static Scheduler providesTrampolineScheduler() {
        return Schedulers.trampoline();
    }

    @Provides
    @Single
    public static Scheduler providesSingleScheduler() {
        return Schedulers.single();
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface IO {
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Computation {
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Trampoline {
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.CLASS)
    public @interface Single {
    }
}
