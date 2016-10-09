package goo.py.seminar.realmdatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import goo.py.seminar.realmdatabase.model.Cat;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

	Realm realm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Realm.init(this);
		realm = Realm.getDefaultInstance();
		// 기본 Instance를 가져옴

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		final EditText editTextName = (EditText) findViewById(R.id.name);
		final EditText editTextDetail = (EditText) findViewById(R.id.detail);
		final EditText editTextSearch = (EditText) findViewById(R.id.search);

		final TextView textViewResult = (TextView) findViewById(R.id.result);

		findViewById(R.id.button_search).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Cat cat = realm.where(Cat.class).equalTo("name", editTextSearch.getText().toString()).findAll().first();

				// name 이 editTextSearch에 기록된 텍스트의 스트링값을 포함하는 항목만 쿼리(.equalTo("name", ...))로 뽑아서
				// 제일 첫번째 항목(.first())을 가져옴.

				textViewResult.setText(cat.getDetail());

			}
		});

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				realm.executeTransaction(new Realm.Transaction() {
					@Override
					public void execute(Realm realm) {

						Cat cat = realm.createObject(Cat.class); // 새 데이터 항목 생성

						cat.setName(editTextName.getText().toString()); // name 행에 해당하는 변수 등록
						cat.setDetail(editTextDetail.getText().toString()); // detail 행에 해당하는 변수 등록

						Snackbar.make(view, "Database Added", Snackbar.LENGTH_LONG).show();
					}
				});
			}
		});

	}
}
