package com.example.shoplist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopListRepository

class ShopListRepositoryImpl: ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for( i in 0 until 10){
            val item = ShopItem("name * $i",i,true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateShopList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateShopList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItemById(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Elemant with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateShopList() {
        shopListLD.value = shopList.toList()
    }
}