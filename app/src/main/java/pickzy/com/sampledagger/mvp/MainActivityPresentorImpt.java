package pickzy.com.sampledagger.mvp;

import java.util.List;

import javax.inject.Inject;

import pickzy.com.sampledagger.model.CryptoData;
import pickzy.com.sampledagger.retrofit.ApiInterface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresentorImpt implements MainActivityPresentator.Presentor {

    MainActivityPresentator.View mView;
    ApiInterface apiInterface;

    @Inject
    public MainActivityPresentorImpt(ApiInterface apiInterface, MainActivityPresentator.View view) {
        this.apiInterface = apiInterface;
        this.mView = view;
    }

    @Override
    public void loadData() {
        mView.showProgress();

        apiInterface.getData("10").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CryptoData>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                        mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("Error occurred");
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(List<CryptoData> data) {
                        mView.showData(data);
                    }
                });

    }
}
