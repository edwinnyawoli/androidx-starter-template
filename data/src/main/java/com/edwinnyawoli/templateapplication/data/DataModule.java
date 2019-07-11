package com.edwinnyawoli.templateapplication.data;

import android.content.Context;

import com.edwinnyawoli.templateapplication.common.annotations.AppScope;
import com.edwinnyawoli.templateapplication.data.local.AppDatabase;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class DataModule {
    @Provides
    @AppScope
    static AppDatabase provideAppDatabase(Context context) {
        return AppDatabase.getInstance(context);
    }
}
