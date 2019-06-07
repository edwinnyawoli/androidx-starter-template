package com.edwinnyawoli.templateapplication.di;

import android.content.Context;

import com.edwinnyawoli.templateapplication.TemplateApplication;
import com.edwinnyawoli.templateapplication.common.annotations.AppScope;
import com.edwinnyawoli.templateapplication.common.concurrency.SchedulersModule;
import com.edwinnyawoli.templateapplication.data.DataModule;
import com.edwinnyawoli.templateapplication.data.NetModule;
import com.edwinnyawoli.templateapplication.data.remote.Api;
import com.edwinnyawoli.templateapplication.di.module.ActivityModule;
import com.edwinnyawoli.templateapplication.di.module.AppModule;
import com.edwinnyawoli.templateapplication.di.module.FragmentModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 */
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityModule.class,
        FragmentModule.class,
        AppModule.class,
        DataModule.class,
        NetModule.class,
        SchedulersModule.class}
)
@AppScope
public interface AppComponent extends AndroidInjector<TemplateApplication> {

    @Component.Factory
    abstract class Factory {
        public abstract AppComponent create(@BindsInstance HttpLoggingInterceptor.Level loggingLevel,
                                            @BindsInstance Context context,
                                            @BindsInstance @Api.BaseUrl String baseUrl);
    }
}
