package me.hanhngo.homeps.view.billdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import me.hanhngo.homeps.databinding.FragmentBillDetailBinding


@AndroidEntryPoint
class BillDetailFragment : Fragment() {

    private var _binding: FragmentBillDetailBinding? = null
    private val binding get() = _binding!!

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
        binding.bill = args.bill
    }
}