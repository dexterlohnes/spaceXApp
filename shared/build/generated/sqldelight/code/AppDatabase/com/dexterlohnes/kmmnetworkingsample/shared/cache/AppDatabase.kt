package com.dexterlohnes.kmmnetworkingsample.shared.cache

import com.dexterlohnes.kmmnetworkingsample.shared.cache.shared.newInstance
import com.dexterlohnes.kmmnetworkingsample.shared.cache.shared.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import comdexterlohneskmmnetworkingsamplesharedcache.AppDatabaseQueries

interface AppDatabase : Transacter {
  val appDatabaseQueries: AppDatabaseQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = AppDatabase::class.schema

    operator fun invoke(driver: SqlDriver): AppDatabase = AppDatabase::class.newInstance(driver)}
}
