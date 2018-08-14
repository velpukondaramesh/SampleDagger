package pickzy.com.sampledagger.di.component;

import android.content.Context;

import dagger.Component;
import pickzy.com.sampledagger.MyApplication;
import pickzy.com.sampledagger.di.modules.ContextModule;
import pickzy.com.sampledagger.di.modules.RetrofitModule;
import pickzy.com.sampledagger.di.qualifier.ApplicationContext;
import pickzy.com.sampledagger.di.scopes.ApplicationScope;
import pickzy.com.sampledagger.retrofit.ApiInterface;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    ApiInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
