package com.edwinnyawoli.templateapplication.di.module;

import com.edwinnyawoli.templateapplication.ui.TestViewModel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 *
 */
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel.class)
    abstract ViewModel bindsTestViewModel(TestViewModel testViewModel);

    @Documented
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    public @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    public static class DefaultViewModelFactory implements ViewModelProvider.Factory {

        private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelProviderMap;

        @Inject
        public DefaultViewModelFactory(Map<Class<? extends ViewModel>,
                Provider<ViewModel>> viewModelProviderMap) {
            this.viewModelProviderMap = viewModelProviderMap;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            Provider<? extends ViewModel> viewModelProvider = viewModelProviderMap.get(modelClass);
            if (viewModelProvider == null) {
                for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>>
                        entry : viewModelProviderMap.entrySet()) {
                    if (modelClass.isAssignableFrom(entry.getKey())) {
                        viewModelProvider = entry.getValue();
                        break;
                    }
                }
            }

            if (viewModelProvider == null) {
                throw new IllegalArgumentException("unknown model class " + modelClass);
            }

            try {
                return (T) viewModelProvider.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
