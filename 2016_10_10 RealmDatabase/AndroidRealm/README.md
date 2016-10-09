Android Realm Database
======================

Primary Settings

```JAVA

Realm realm;

//...

Realm.init(this); // init Realm
realm = Realm.getDefaultInstance();


```

Write Database


```JAVA

realm.executeTransaction(new Realm.Transaction() {
    @Override
        public void execute(Realm realm) {

                Cat cat = realm.createObject(Cat.class); // New Database Row

                cat.setName("__CAT_NAME__"); // set name
                cat.setDetail("__CAT_DETAIL__"); // set detail


        }
});


```



