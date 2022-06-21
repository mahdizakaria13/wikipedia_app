package ir.marko.wikipedia.interfaces

import ir.marko.wikipedia.data.ItemInfo

interface ItemEvents {
    fun itemClicked(itemInfo :ItemInfo)
}
