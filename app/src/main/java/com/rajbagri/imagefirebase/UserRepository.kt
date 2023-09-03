package com.rajbagri.imagefirebase

class UserRepository(
    private val db: UserDatabase
) {
    suspend fun upsert(item: useritem) = db.getUserDao().upsert(item)

    suspend fun delete(item: useritem) = db.getUserDao().delete(item)

    fun getItemInfo() = db.getUserDao().getItemInfo()
}