package edu.msudenver.cs3013.project1_s24

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment() {

    private lateinit var profileName: TextView
    private lateinit var profileEmail: TextView
    private lateinit var editButton: Button
    private lateinit var createButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("ProfileFragment", "onCreateView called")
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        (activity as MainActivity).setToolbarTitle("Profile")

        profileName = view.findViewById(R.id.profile_name)
        profileEmail = view.findViewById(R.id.profile_email)
        editButton = view.findViewById(R.id.button_edit_profile)
        createButton = view.findViewById(R.id.button_create_profile)

        val profileNameArg = arguments?.getString("profileName")
        val profileEmailArg = arguments?.getString("profileEmail")

        if (profileNameArg != null && profileEmailArg != null) {
            profileName.text = profileNameArg
            profileEmail.text = profileEmailArg
            Log.d("ProfileFragment", "Loaded profile data from arguments: $profileNameArg, $profileEmailArg")
        } else {
            profileName.text = "Ex: Christopher Pugliese"
            profileEmail.text = "Ex: Chris.p@mail.com"
            Log.d("ProfileFragment", "Loaded default profile data")
        }

        editButton.setOnClickListener {
            Log.d("ProfileFragment", "Edit button clicked")
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        createButton.setOnClickListener {
            Log.d("ProfileFragment", "Create button clicked")
            findNavController().navigate(R.id.action_profileFragment_to_createProfileFragment)

        }

        return view

    }
}
