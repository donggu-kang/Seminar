Android Realm Database
======================

초기 세팅

```JAVA

// RealmObject를 상속받는 클래스 등록

public class Cat extends RealmObject {

    String name, detail;

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setName(String name) {
        this.name = name;
    }

}


```


변수 등록및 init


```JAVA

Realm realm;

//...

Realm.init(this); // init Realm
realm = Realm.getDefaultInstance();


```

데이터 베이스 쓰기


```JAVA

realm.executeTransaction(new Realm.Transaction() {
    @Override
        public void execute(Realm realm) {

                Cat cat = realm.createObject(Cat.class); // 새 DB 항목 추가

                cat.setName("__CAT_NAME__"); // 이름 설정
                cat.setDetail("__CAT_DETAIL__"); // 디테일 설정


        }
});


```



