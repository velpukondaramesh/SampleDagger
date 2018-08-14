package pickzy.com.sampledagger;

import android.app.Activity;
import android.app.Application;

import pickzy.com.sampledagger.di.component.ApplicationComponent;
import pickzy.com.sampledagger.di.component.DaggerApplicationComponent;
import pickzy.com.sampledagger.di.modules.ContextModule;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);
    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
