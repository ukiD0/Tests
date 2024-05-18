/**
 * This class created for SignInFragment
 * Author Korovkina Valentina
 * Create date 18/05/24
 * */
package com.example.saransk.presentation.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saransk.R
import com.example.saransk.common.Helper
import com.example.saransk.databinding.FragmentSignInBinding
import com.example.saransk.domain.AuthRepository


class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater,container, false)

        binding.btnHide.setOnClickListener {
            if (!AuthRepository.checkValidPass(binding.passId)){
                Helper.ALert(requireContext(),"Ошибка","Введите почту еще раз")
            }
        }
        binding.invisible.setOnClickListener {
            if (!AuthRepository.checkValidEmail(binding.emailId)){
                Helper.ALert(requireContext(),"Ошибка","Введите пароль еще раз")
            }
        }

        return binding.root
    }


}