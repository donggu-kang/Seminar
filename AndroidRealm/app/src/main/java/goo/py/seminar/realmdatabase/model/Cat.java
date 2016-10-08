package goo.py.seminar.realmdatabase.model;

import io.realm.RealmObject;

/**
 * Created by tylenol on 2016. 10. 8..
 */

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
