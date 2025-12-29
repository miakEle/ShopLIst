package com.example.shoplist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopListDao {


    @Query("SELECT * FROM SHOP_ITEMS")
    fun getShopList(): LiveData<List<ShopItemDbModel>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM SHOP_ITEMS WHERE ID=:shopItemId")
    fun deleteShopItem(shopItemId: Int)


    @Query("SELECT * FROM SHOP_ITEMS WHERE ID=:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int): ShopItemDbModel
}