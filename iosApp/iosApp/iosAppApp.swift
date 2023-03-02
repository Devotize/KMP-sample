//
//  iosAppApp.swift
//  iosApp
//
//  Created by Denis Sychev on 02.03.2023.
//

import SwiftUI
import shared

@main
struct iosAppApp: App {
    
    init() {
        KoinSetup().doInitKoin(modules: [])
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView(
                
            )
        }
    }
}
