package ie.wit.donationx.firebase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ie.wit.donationx.models.DonationModel
import ie.wit.donationx.models.DonationStore
import timber.log.Timber

var database: DatabaseReference = FirebaseDatabase.getInstance().reference

object FirebaseDBManager : DonationStore {
    override fun findAll(donationsList: MutableLiveData<List<DonationModel>>) {
        TODO("Not yet implemented")
    }

    override fun findAll(userid: String, donationsList: MutableLiveData<List<DonationModel>>) {
        TODO("Not yet implemented")
    }

    override fun findById(userid: String, donationid: String, donation: MutableLiveData<DonationModel>) {
        TODO("Not yet implemented")
    }

    override fun create(firebaseUser: MutableLiveData<FirebaseUser>, donation: DonationModel) {
        Timber.i("Firebase DB Reference : $database")

        val uid = firebaseUser.value!!.uid
        val key = database.child("donations").push().key
        if (key == null) {
            Timber.i("Firebase Error : Key Empty")
            return
        }
        donation.uid = key
        val donationValues = donation.toMap()

        val childAdd = HashMap<String, Any>()
        childAdd["/donations/$key"] = donationValues
        childAdd["/user-donations/$uid/$key"] = donationValues

        database.updateChildren(childAdd)
    }

    override fun delete(userid: String, donationid: String) {
        TODO("Not yet implemented")
    }

    override fun update(userid: String, donationid: String, donation: DonationModel) {
        TODO("Not yet implemented")
    }
}