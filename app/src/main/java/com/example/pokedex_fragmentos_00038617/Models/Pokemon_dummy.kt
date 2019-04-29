package com.example.pokedex_fragmentos_00038617.Models

import android.os.Parcel
import android.os.Parcelable

data class Pokemon_dummy(val url : String, val name:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon_dummy> {
        override fun createFromParcel(parcel: Parcel): Pokemon_dummy {
            return Pokemon_dummy(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon_dummy?> {
            return arrayOfNulls(size)
        }
    }
}