package com.dexterlohnes.kmmnetworkingsample.shared

import com.dexterlohnes.kmmnetworkingsample.shared.cache.Database
import com.dexterlohnes.kmmnetworkingsample.shared.cache.DatabaseDriverFactory
import com.dexterlohnes.kmmnetworkingsample.shared.entity.RocketLaunch
import com.dexterlohnes.kmmnetworkingsample.shared.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.any() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}