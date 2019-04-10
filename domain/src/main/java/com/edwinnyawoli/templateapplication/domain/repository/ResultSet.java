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

package com.edwinnyawoli.templateapplication.domain.repository;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import lombok.Data;

/**
 * A {@link ResultSet} provides an asynchronous way of retrieving the data requested. It also
 * allows the user to observe the state of the data loading process and a medium to retry any
 * failed data loading.
 */
public interface ResultSet<T> {
    Flowable<? extends List<T>> getItems();

    Observable<State> getState();

    /**
     * Attempts to reload the data that should be made available by this result set if a previous
     * load failed. This method <b>may</b> do nothing if a previous load completed successfully (
     * represented by the {@link Status#LOADED} status).
     */
    void retryFailedLoad();

    void refresh();

    enum Status {
        LOADING,
        LOADED,
        FAILED
    }

    @Data
    class State {
        private final Status status;
        private Throwable error;
    }
}
