package me.hanhngo.homeps.view.billdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import me.hanhngo.homeps.R
import me.hanhngo.homeps.databinding.DetailBillItemBinding
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