Swift Realm Database
====================

초기 세팅

```SWIFT

// 사용할 클래스 등록

class Cat : Object {
    dynamic var name = ""
    dynamic var detail = ""
}


```
변수 등록

```SWIFT

let realm = try! Realm()

```

데이터 베이스 쓰기


```SWIFT

let cat = Cat()

cat.name = nameField.text!
cat.detail = detailField.text!

// Class에 변수 저장

try! realm.write {

    realm.add(cat) //데이터베이스에 저장된 변수 데이터 기록
}


```



