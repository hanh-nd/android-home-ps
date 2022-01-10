package me.hanhngo.homeps.view.addbill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import me.hanhngo.homeps.R
import me.hanhngo.homeps.databinding.FragmentAddBillBinding
import me.hanhngo.homeps.view.addbill.event.ListPsEvent

@AndroidEntryPoint
class AddBillFragment : Fragment() {

    private var _binding: FragmentAddBillBinding? = null
    private val binding: FragmentAddBillBinding get() = _binding!!

    private val viewModel: AddBillViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBillBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.events.observe(requireActivity()) { event ->
            event.getContentIfNotHandled()?.let {
                handleAction(it)
            }
        }
    }

    private fun handleAction(event: ListPsEvent) {
        when (event) {
            is ListPsEvent.CreateNewTurn -> {
                viewModel.createNewTurn(event.ps)
                NavHostFragment.findNavController(this)
                    .navigate(AddBillFragmentDirections.actionAddBillFragmentToHomeFragment())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}