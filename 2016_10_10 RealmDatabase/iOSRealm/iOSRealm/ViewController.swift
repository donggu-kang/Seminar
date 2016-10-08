//
//  ViewController.swift
//  iOSRealm
//
//  Created by tylenol on 2016. 10. 8..
//  Copyright © 2016년 tylenolG00py. All rights reserved.
//

import UIKit
import RealmSwift

class Cat : Object {
    dynamic var name = ""
    dynamic var detail = ""
}

class ViewController: UIViewController {

    let realm = try! Realm()
    
    @IBOutlet weak var nameField: UITextField!
    @IBOutlet weak var detailField: UITextField!
    
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var searchField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }
    
    @IBAction func search(_ sender: AnyObject) {
        
        resultLabel.text = realm.objects(Cat.self).filter("name contains '" + searchField.text! + "'").first?.detail
        
        
    }

    @IBAction func add(_ sender: AnyObject) {
        
        
        let cat = Cat()
        
        cat.name = nameField.text!
        cat.detail = detailField.text!
        
        try! realm.write {
            realm.add(cat)
        }
        
    }

}

