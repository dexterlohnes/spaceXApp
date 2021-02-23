//
//  RocketLaunchRow.swift
//  iosApp
//
//  Created by Dexter Lohnes on 2/23/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketLaunchRow: View {
    var rocketLaunch: RocketLaunch
    var body: some View {
        HStack() {
            VStack(alignment: .leading, spacing: 10.0) {
                Text("Launch name: \(rocketLaunch.missionName)")
                Text(launchText).foregroundColor(launchColor)
                Text("Launch year: \(rocketLaunch.launchYear)")
                Text("Launch details: \(rocketLaunch.details ?? "None")")
                
            }
        }
    }
}

extension RocketLaunchRow {
    private var launchText: String {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? "Successful" : "Unsuccessful"
        } else {
            return "No data"
        }
    }
    
    private var launchColor: Color {
        if let isSuccess = rocketLaunch.launchSuccess {
            return isSuccess.boolValue ? Color.green : Color.red
        } else {
            return Color.gray
        }
    }
}

struct RocketLaunchRow_Previews: PreviewProvider {
    static var previews: some View {
        RocketLaunchRow(rocketLaunch: RocketLaunch(flightNumber: 001, missionName: "Test mission", launchYear: 2001, launchDateUTC: "Date str", rocket: Rocket(id: "1", name: "Test rocket", type: "Falcon Test"), details: nil, launchSuccess: true, links: Links.init(missionPatchUrl: nil, articleUrl: nil)))
    }
}
