package pickzy.com.sampledagger.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import pickzy.com.sampledagger.di.qualifier.ApplicationContext;
import pickzy.com.sampledagger.di.scopes.ApplicationScope;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
