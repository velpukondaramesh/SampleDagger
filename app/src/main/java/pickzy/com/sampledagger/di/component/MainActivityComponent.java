package pickzy.com.sampledagger.di.component;

import android.content.Context;

import dagger.Component;
import dagger.Module;
import pickzy.com.sampledagger.MainActivity;
import pickzy.com.sampledagger.di.modules.AdapterModule;
import pickzy.com.sampledagger.di.modules.MainActivityMvpModule;
import pickzy.com.sampledagger.di.qualifier.ActivityContext;
import pickzy.com.sampledagger.di.scopes.ActivityScope;
import pickzy.com.sampledagger.mvp.MainActivityPresentator;

@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);

}
