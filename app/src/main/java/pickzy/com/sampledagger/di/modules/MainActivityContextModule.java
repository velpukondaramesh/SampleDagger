package pickzy.com.sampledagger.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pickzy.com.sampledagger.MainActivity;
import pickzy.com.sampledagger.di.qualifier.ActivityContext;
import pickzy.com.sampledagger.di.scopes.ActivityScope;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;
    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
