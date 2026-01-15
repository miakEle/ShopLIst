package com.example.shoplist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.shoplist.domain.ShopItem
import com.example.shoplist.domain.ShopListRepository
import javax.inject.Inject


class ShopListRepositoryImpl @Inject constructor(
    private val application: Application,
    private val shopListDao: ShopListDao,
    private val mapper: ShopListMapper
): ShopListRepository {


    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbMoDel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbMoDel(shopItem))
    }

    override suspend fun getShopItemById(shopItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return  mapper.mapDbMoDelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        addSource(shopListDao.getShopList()){
            value = mapper.mapListDbModelToListEntity(it)
        }
    }

//    override fun getShopList(): LiveData<List<ShopItem>> =
//        Transformations.map(shopListDao.getShopList()) { dbList ->
//            mapper.mapListDbModelToListEntity(dbList)
//        }



}