//
//  ViewController.swift
//  iOSRealm
//
//  Created by tylenol on 2016. 10. 8..
//  Copyright © 2016년 tylenolG00py. All rights reserved.
//

import UIKit
import RealmSwift

class ViewController: UIViewController {

    let realm = try! Realm() // Realm 등록
    
    @IBOutlet weak var nameField: UITextField!
    @IBOutlet weak var detailField: UITextField!
    
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var searchField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        print(Realm.Configuration.defaultConfiguration.fileURL!)
        // Realm 데이터 베이스 파일 위치 (로그 확인)
    
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }
    
    @IBAction func search(_ sender: AnyObject) {
        
        resultLabel.text = realm.objects(Cat.self).filter("name contains '" + searchField.text! + "'").first?.detail
        
        // name 이 searchField에 기록된 텍스트의 스트링값을 포함하는 항목만 쿼리(.filter("name contains...)로 뽑아서
        // 제일 첫번째 항목(.first?)을 가져옴.
        
    }

    @IBAction func add(_ sender: AnyObject) {
        
        
        let cat = Cat()
        
        cat.name = nameField.text!
        cat.detail = detailField.text!
        
        // Class에 변수 저장
        
        try! realm.write {
            
            realm.add(cat)
            
            //데이터베이스에 저장된 변수 데이터 기록
        }
        
    }
}


class Cat : Object {
    dynamic var name = ""
    dynamic var detail = ""
}

