package com.l0122138.ridlo.responsi1wisatakebumen.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.l0122138.ridlo.responsi1wisatakebumen.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set onClickListener for shareButton using ViewBinding
        binding.shareButton.setOnClickListener {
            shareProfile()
        }

        return view
    }

    private fun shareProfile() {
        val shareText = """
            NIM: ${binding.nimDetail.text}
            Nama: ${binding.nameDetail.text}
            Jurusan: ${binding.majorDetail.text}
            Angkatan: ${binding.yearDetail.text}
            Fakultas: ${binding.facultyDetail.text}
            Universitas: ${binding.universityDetail.text}
            Deskripsi: ${binding.descriptionDetail.text}
        """.trimIndent()

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
