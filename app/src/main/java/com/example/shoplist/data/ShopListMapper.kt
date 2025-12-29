package com.example.shoplist.data

import com.example.shoplist.domain.ShopItem

class ShopListMapper {

    fun mapEntityToDbMoDel(shopItem: ShopItem): ShopItemDbModel {
        return ShopItemDbModel(
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enable = shopItem.enable
        )
    }

    fun mapDbMoDelToEntity(shopItemDbModel: ShopItemDbModel): ShopItem {
        return ShopItem(
            id = shopItemDbModel.id,
            name = shopItemDbModel.name,
            count = shopItemDbModel.count,
            enable = shopItemDbModel.enable
        )
    }


    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbMoDelToEntity(it)
    }


}