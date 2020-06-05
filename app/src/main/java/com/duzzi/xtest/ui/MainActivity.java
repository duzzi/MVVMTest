package com.duzzi.xtest.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.duzzi.xtest.R;
import com.duzzi.xtest.bean.TestFactory;
import com.duzzi.xtest.databinding.ActivityMainBinding;
import com.duzzi.xtest.test.TestUtils;
import com.duzzi.xtest.test.TestViewModel;
import com.duzzi.xtest.viewmodel.HomeViewModel;
import com.duzzi.xtest.viewmodel.HomeViewModelFactory;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mBinding;
    private HomeAdapter mAdapter;
    private HomeViewModel mHomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRefreshView();


        TestViewModel testViewModel = new ViewModelProvider(this, new TestFactory(10000)).get(TestViewModel.class);
        testViewModel.getCount().observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //通过观察者更新数据
                mBinding.text.setText(String.valueOf(integer));
            }
        });
        getLifecycle().addObserver(new TestUtils(testViewModel));
    }

    private void initRefreshView() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        mAdapter = new HomeAdapter();
        mBinding.recyclerView.setAdapter(mAdapter);

        mHomeViewModel = new ViewModelProvider(MainActivity.this,
                new HomeViewModelFactory()).get(HomeViewModel.class);

        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refresh());
        mHomeViewModel.getLiveData().observeForever(articlesBean -> {
            mAdapter.setNewInstance(articlesBean.getDatas());
            mBinding.refreshLayout.finishRefresh();
        });
        mBinding.refreshLayout.autoRefresh();

    }

    public void refresh() {
        if (mHomeViewModel != null) {
            mHomeViewModel.refresh();
        }
    }
}
