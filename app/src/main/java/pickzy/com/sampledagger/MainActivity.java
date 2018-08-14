package pickzy.com.sampledagger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import pickzy.com.sampledagger.di.component.ApplicationComponent;
import pickzy.com.sampledagger.di.component.DaggerMainActivityComponent;
import pickzy.com.sampledagger.di.component.MainActivityComponent;
import pickzy.com.sampledagger.di.modules.MainActivityContextModule;
import pickzy.com.sampledagger.di.modules.MainActivityMvpModule;
import pickzy.com.sampledagger.di.qualifier.ActivityContext;
import pickzy.com.sampledagger.di.qualifier.ApplicationContext;
import pickzy.com.sampledagger.model.CryptoData;
import pickzy.com.sampledagger.mvp.MainActivityPresentator;
import pickzy.com.sampledagger.mvp.MainActivityPresentorImpt;
import pickzy.com.sampledagger.ui.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements MainActivityPresentator.View, RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    MainActivityPresentorImpt presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

        presenter.loadData();
    }

    @Override
    public void showData(List<CryptoData> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void launchIntent(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    }
}
