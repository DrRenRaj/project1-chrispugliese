package edu.msudenver.cs3013.project1_s24

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EditProfileFragment : Fragment() {

    private lateinit var profileNameInput: EditText
    private lateinit var profileEmailInput: EditText
    private lateinit var updateButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("EditProfileFragment", "onCreateView called")
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        (activity as MainActivity).setToolbarTitle("Edit Profile")


        profileNameInput = view.findViewById(R.id.edit_profile_name_input)
        profileEmailInput = view.findViewById(R.id.edit_profile_email_input)
        updateButton = view.findViewById(R.id.button_update_profile)

        updateButton.setOnClickListener {
            Log.d("EditProfileFragment", "Update button clicked")
            val profileName = profileNameInput.text.toString()
            val profileEmail = profileEmailInput.text.toString()

            if (profileName.isNotEmpty() && profileEmail.isNotEmpty()) {
                Log.d("EditProfileFragment", "Profile name and email are not empty")
                val bundle = Bundle().apply {
                    putString("profileName", profileName)
                    putString("profileEmail", profileEmail)
                }
                Log.d("EditProfileFragment", "Navigating with profileName: $profileName, profileEmail: $profileEmail")
                findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment, bundle)
            } else {
                Log.d("EditProfileFragment", "Profile name or email is empty")
                Toast.makeText(requireContext(), "Please enter both name and email", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
