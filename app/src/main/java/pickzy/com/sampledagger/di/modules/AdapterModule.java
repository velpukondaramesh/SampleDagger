package pickzy.com.sampledagger.di.modules;

import dagger.Module;
import dagger.Provides;
import pickzy.com.sampledagger.MainActivity;
import pickzy.com.sampledagger.di.scopes.ActivityScope;
import pickzy.com.sampledagger.ui.RecyclerViewAdapter;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {
    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
