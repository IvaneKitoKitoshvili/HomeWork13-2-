package com.example.homework132

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework132.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    class ItemFragment : Fragment() {
        private lateinit var binding: ActivityMainBinding

        private val viewModel: ItemViewModel by viewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = ActivityMainBinding.inflate(inflater,container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            with(viewModel) {
                viewState.observe(viewLifecycleOwner) {
                    if (viewState.value?.isSuccessful == true) {
                        binding.tvText.text = viewState.value!!.itemData.toString()
                    } else if(viewState.value?.error != null){
                        Toast.makeText(
                            requireContext(),
                            viewState.value?.error ?: "",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    }
}