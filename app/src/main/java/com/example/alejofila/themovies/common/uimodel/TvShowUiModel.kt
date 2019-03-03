package com.alejofila.newsdemo.common.uimodel

import android.os.Parcel
import android.os.Parcelable

data class TvShowUiModel(val name:String,val rating: Double
                         ,val image:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString())


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(rating)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvShowUiModel> {
        override fun createFromParcel(parcel: Parcel): TvShowUiModel {
            return TvShowUiModel(parcel)
        }

        override fun newArray(size: Int): Array<TvShowUiModel?> {
            return arrayOfNulls(size)
        }
    }
}

