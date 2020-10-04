package com.phattarapong.sealedapplication

sealed class Model {

    enum class ModelType(type: Int) {
        TYPE_HEADER(1), TYPE_BODY(2), TYPE_FOOTER(3)
    }

    abstract val type: ModelType

    data class Header(override var type: ModelType, var header: String) : Model()
    data class Body(override var type: ModelType, var text: String) : Model()
    data class Footer(override var type: ModelType, var text: String) : Model()
}

sealed class ShopModel {
    enum class ShopType(type: Int) {
        TYPE_TOPIC(1), TYPE_ITEM(2)
    }

    abstract val type: ShopType

    data class Topic(var topicStr: String, override val type: ShopType) : ShopModel()
    data class Item(
        var productName: String,
        var productImage: String,
        override val type: ShopType
    ) : ShopModel()
}
