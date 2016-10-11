package goo.py.seminar.realmdatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import goo.py.seminar.realmdatabase.model.Cat;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

  Realm realm;

  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.name)
  EditText editTextName;
  @BindView(R.id.detail)
  EditText editTextDetail;
  @BindView(R.id.search)
  EditText editTextSearch;
  @BindView(R.id.result)
  EditText textViewResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ButterKnife.bind(this);
    Realm.init(this);

    setSupportActionBar(toolbar);

    realm = Realm.getDefaultInstance(); // 기본 Instance를 가져옴

  }

  public void addDatabase(String name, String detail) {

    Cat cat = realm.createObject(Cat.class); // 새 데이터 항목 생성
    cat.setName(name); // name 행에 해당하는 변수 등록
    cat.setDetail(detail); // detail 행에 해당하는 변수 등록

  }

  @OnClick({R.id.button_search, R.id.fab})
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.button_search:

        Cat cat = realm.where(Cat.class).equalTo("name", editTextSearch.getText().toString()).findAll().first();
        textViewResult.setText(cat.getDetail());

        // name 이 editTextSearch에 기록된 텍스트의 스트링값을 포함하는 항목만 쿼리(.equalTo("name", ...))로 뽑아서
        // 제일 첫번째 항목(.first())을 가져옴.

        break;
      case R.id.fab:

        realm.executeTransaction(realm ->
            addDatabase(editTextName.getText().toString(), editTextDetail.getText().toString()));

        break;
    }
  }
}
