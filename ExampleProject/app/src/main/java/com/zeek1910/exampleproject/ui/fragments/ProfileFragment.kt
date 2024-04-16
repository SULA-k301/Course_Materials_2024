package com.zeek1910.exampleproject.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.zeek1910.exampleproject.R
import com.zeek1910.exampleproject.data.UserStorage
import com.zeek1910.exampleproject.ui.activities.SignInActivity

class ProfileFragment : Fragment() {

    private lateinit var buttonLogOut: Button

    private lateinit var userStorage: UserStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userStorage = UserStorage(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogOut = view.findViewById(R.id.logOutButton)
        buttonLogOut.setOnClickListener {
            userStorage.clear()
            startActivity(Intent(requireContext(), SignInActivity::class.java))
            requireActivity().finish()
        }
    }
}