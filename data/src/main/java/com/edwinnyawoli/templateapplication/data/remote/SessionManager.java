package com.edwinnyawoli.templateapplication.data.remote;

import com.edwinnyawoli.templateapplication.common.annotations.AppScope;
import com.edwinnyawoli.templateapplication.domain.model.User;

import javax.inject.Inject;

/**
 *
 */

@AppScope
public class SessionManager {
    private User loggedInUser;

    @Inject
    public SessionManager() {
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User agent) {
        loggedInUser = agent;
    }
}
