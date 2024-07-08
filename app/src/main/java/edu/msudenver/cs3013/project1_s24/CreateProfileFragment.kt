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

class CreateProfileFragment : Fragment() {

    private lateinit var profileNameInput: EditText
    private lateinit var profileEmailInput: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CreateProfileFragment", "onCreateView called")
        val view = inflater.inflate(R.layout.fragment_create_profile, container, false)
        (activity as MainActivity).setToolbarTitle("Create Profile")

        profileNameInput = view.findViewById(R.id.create_profile_name_input)
        profileEmailInput = view.findViewById(R.id.create_profile_email_input)
        saveButton = view.findViewById(R.id.button_create_profile)

        saveButton.setOnClickListener {
            Log.d("CreateProfileFragment", "Save button clicked")
            val profileName = profileNameInput.text.toString()
            val profileEmail = profileEmailInput.text.toString()

            if (profileName.isNotEmpty() && profileEmail.isNotEmpty()) {
                Log.d("CreateProfileFragment", "Profile name and email are not empty")
                val bundle = Bundle().apply {
                    putString("profileName", profileName)
                    putString("profileEmail", profileEmail)
                }
                Log.d("CreateProfileFragment", "Navigating with profileName: $profileName, profileEmail: $profileEmail")
                findNavController().navigate(R.id.action_createProfileFragment_to_profileFragment, bundle)
            } else {
                Log.d("CreateProfileFragment", "Profile name or email is empty")
                Toast.makeText(requireContext(), "Please enter both name and email", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
