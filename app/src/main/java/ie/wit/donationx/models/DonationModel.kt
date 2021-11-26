package ie.wit.donationx.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class DonationModel(
      val _id: String = "N/A",
      @SerializedName("paymenttype")
      val paymentmethod: String = "N/A",
      var message: String = "N/A",
      var amount: Int = 0,
      var upvotes: Int = 0,
      val email: String = "joe@bloggs.com") : Parcelable



