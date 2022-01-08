package me.hanhngo.homeps.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import me.hanhngo.homeps.R
import me.hanhngo.homeps.databinding.FragmentHomeBinding
import me.hanhngo.homeps.view.home.event.ListBillEvent

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.homeViewModel = viewModel

        viewModel.events.observe(requireActivity()) { event ->
            event.getContentIfNotHandled()?.let {
                handleAction(it)
            }

        }
    }

    private fun handleAction(event: ListBillEvent) {
        when (event) {
            is ListBillEvent.ShowBillDetail -> {
                NavHostFragment.findNavController(this)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToBillDetailFragment(event.bill))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}