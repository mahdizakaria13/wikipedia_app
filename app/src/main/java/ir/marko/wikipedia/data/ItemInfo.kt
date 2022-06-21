package ir.marko.wikipedia.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemInfo(
    val imgUrl :String ,
    val txtTitle :String ,
    val txtSubtitle :String ,
    val txtInfo :String ,
    val isTrends :Boolean ,
    val numOfTrend :String
):Parcelable
