package com.dexterlohnes.kmmnetworkingsample.shared


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
