package pickzy.com.sampledagger.di.modules;

import dagger.Module;
import dagger.Provides;
import pickzy.com.sampledagger.di.scopes.ActivityScope;
import pickzy.com.sampledagger.mvp.MainActivityPresentator;

@Module
public class MainActivityMvpModule {
    private final MainActivityPresentator.View mView;

    public MainActivityMvpModule(MainActivityPresentator.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityPresentator.View provideView() {
        return mView;
    }
}
