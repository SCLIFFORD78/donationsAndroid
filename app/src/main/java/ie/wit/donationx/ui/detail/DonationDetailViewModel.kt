package ie.wit.donationx.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ie.wit.donationx.models.DonationManager
import ie.wit.donationx.models.DonationModel

class DonationDetailViewModel : ViewModel() {
    private val donation = MutableLiveData<DonationModel>()

    val observableDonation: LiveData<DonationModel>
        get() = donation

    fun getDonation(id: String) {
        donation.value = DonationManager.findById(id)
    }
}

