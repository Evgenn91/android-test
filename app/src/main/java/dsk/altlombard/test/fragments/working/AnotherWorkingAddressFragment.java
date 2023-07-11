package dsk.altlombard.test.fragments.working;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingAddressBinding;
import dsk.altlombard.test.databinding.FragmentAnotherWorkingBinding;

public class AnotherWorkingAddressFragment extends Fragment {

    private FragmentAnotherWorkingAddressBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAnotherWorkingAddressBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //MY CODE HERE


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
