//
//  ContentView.swift
//  iosApp
//
//  Created by Denis Sychev on 02.03.2023.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundColor(.accentColor)
            Text(MyHWKt.myHelloWorldString())
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
