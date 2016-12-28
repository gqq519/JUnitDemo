package com.feicuiedu.junitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.feicuiedu.junitdemo.bombapi.BombClient;
import com.feicuiedu.junitdemo.bombapi.entity.NewsEntity;
import com.feicuiedu.junitdemo.bombapi.result.QueryResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewTestActivity extends AppCompatActivity {

    @BindView(R.id.lvNews)
    ListView mLvNews;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        ButterKnife.bind(this);

        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        mLvNews.setAdapter(mAdapter);

        mLvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewTestActivity.this, "第"+i+"条数据", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick(R.id.btnLoad)
    public void onClick() {

        BombClient.getInstance().getNewsApi().getVideoNewsList(5,0).enqueue(new Callback<QueryResult<NewsEntity>>() {
            @Override
            public void onResponse(Call<QueryResult<NewsEntity>> call, Response<QueryResult<NewsEntity>> response) {
                QueryResult<NewsEntity> body = response.body();
                if (body!=null){
                    List<NewsEntity> entityList = body.getResults();
                    for (NewsEntity entity :
                            entityList) {
                        mAdapter.add(entity.getNewsTitle());
                    }
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<QueryResult<NewsEntity>> call, Throwable t) {

            }
        });

    }
}
