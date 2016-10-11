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
    
    @IBOutlet weak var detailField: UITextField!
    @IBOutlet weak var nameField: UITextField!
    
    let realm = try! Realm()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print(Realm.Configuration.defaultConfiguration.fileURL!)
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }
    
    
    @IBAction func addDatabase(_ sender: AnyObject) {
        
        let cat = Cat()
        
        cat.name = nameField.text!
        cat.detail = detailField.text!
        
        try! realm.write {
            realm.add(cat)
        }
        
    }

    
}

