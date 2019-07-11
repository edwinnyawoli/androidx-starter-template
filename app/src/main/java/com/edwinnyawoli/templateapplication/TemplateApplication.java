package com.edwinnyawoli.templateapplication;

import com.edwinnyawoli.templateapplication.di.DaggerAppComponent;
import com.edwinnyawoli.templateapplication.log.CrashlyticsTree;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.squareup.leakcanary.LeakCanary;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 *
 */

public class TemplateApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }

        AndroidThreeTen.init(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        HttpLoggingInterceptor.Level loggingLevel;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            loggingLevel = HttpLoggingInterceptor.Level.BODY;
        } else {
            Timber.plant(new CrashlyticsTree(this));
            loggingLevel = HttpLoggingInterceptor.Level.NONE;
        }

        return DaggerAppComponent.factory()
                .create(loggingLevel, this, "http://127.0.0.1/");
    }
}
