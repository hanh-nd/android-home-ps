package me.hanhngo.homeps.view.billdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import me.hanhngo.homeps.databinding.FragmentBillDetailBinding
import me.hanhngo.homeps.util.Resource


@AndroidEntryPoint
class BillDetailFragment : Fragment() {

    private var _binding: FragmentBillDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BillDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBillDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments ?: return
        val args = BillDetailFragmentArgs.fromBundle(bundle)

        binding.lifecycleOwner = this.viewLifecycleOwner
        viewModel.fetchBillDetail(args.bill.id)
        binding.viewModel = viewModel
        viewModel._bill.value = Resource.Success(args.bill)
        binding.btnCheckOut.setOnClickListener {
            viewModel.checkout(args.bill.id)
            NavHostFragment.findNavController(this)
                .navigate(BillDetailFragmentDirections.actionBillDetailFragmentToHomeFragment())
        }

    }
}