package pickzy.com.sampledagger.mvp;

import java.util.List;

import pickzy.com.sampledagger.model.CryptoData;

public interface MainActivityPresentator {
    interface View {
        void showData(List<CryptoData> data);

        void showError(String message);

        void showComplete();

        void showProgress();

        void hideProgress();
    }

    interface Presentor {
        void loadData();
    }
}
