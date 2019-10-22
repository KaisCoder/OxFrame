package cn.adair.frame.base;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class OxBaseFragment extends Fragment implements OxBaseCallback {

    public View _mView;
    protected Context _mContext;
    private Bundle _mSavedInstanceState;
    protected FragmentActivity _mActivity;

    /**
     * 视图是否加载完毕
     */
    private boolean isCompleted = false;

    /**
     * 数据是否加载过了
     */
    private boolean isPrepared = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        _mSavedInstanceState = savedInstanceState;
        _mView = inflater.inflate(initLayout(), null);
        _mContext = getContext();
        _mActivity = getActivity();
        return _mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _mSavedInstanceState = savedInstanceState;
        isCompleted = true;
        initView();
        loadCompleted(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            loadCompleted(_mSavedInstanceState);
        }
    }

    private void loadCompleted(Bundle savedInstanceState) {
        if (getUserVisibleHint() && isCompleted && !isPrepared) {
            initData(savedInstanceState);
            isPrepared = true;
        }
    }

}
