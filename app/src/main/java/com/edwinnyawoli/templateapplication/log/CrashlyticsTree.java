package com.edwinnyawoli.templateapplication.log;

/**
 *
 */

import android.content.Context;
import android.util.Log;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * The Tree that logs to crashlytics
 */
public class CrashlyticsTree extends Timber.Tree {


    public CrashlyticsTree(Context context) {
        // Initialize Fabric with Crashlytics.
        Fabric.with(context, new Crashlytics());
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        // Log the message to Crashlytics, so we can see it in crash reports
        Crashlytics.log(message);

        // Log the exception in Crashlytics if we have one.
        if (t != null) {
            Crashlytics.logException(t);
        }

        // If this is an error or a warning, log it as a exception so we see it in Crashlytics.
        if (priority > Log.WARN) {
            Crashlytics.logException(new Throwable(message));
        }
    }
}