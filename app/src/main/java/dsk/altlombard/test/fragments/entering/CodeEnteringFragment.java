package dsk.altlombard.test.fragments.entering;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentCodeEnteringBinding;
import dsk.altlombard.test.fragments.WorkingMainFragment;

public class CodeEnteringFragment extends Fragment {

    private FragmentCodeEnteringBinding binding;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCodeEnteringBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        boolean newPinCode = getArguments().getBoolean("newPinCode");

        ViewGroup viewGroup = view.findViewById(R.id.layout_for_button_forgotpin);//сюда мы встявляем кнопку "забыли пин-код"
        EditText enteredPinCode = view.findViewById(R.id.enter_pincode);

        SharedPreferences registrationEntity = this.getActivity().getSharedPreferences("registration", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = registrationEntity.edit();

        binding.buttonPincodeEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkingMainFragment.isFirstTime = true;
                if(newPinCode){
                    myEdit.putString("pinCode", enteredPinCode.getText().toString());
                    myEdit.commit();
                    NavHostFragment.findNavController(CodeEnteringFragment.this).navigate(R.id.action_codeEnteringFragment_to_workingMainFragment);
                } else {
                    String correctPinCode = registrationEntity.getString("pinCode", "");
                    if (correctPinCode.equals(enteredPinCode.getText().toString())) {
                        NavHostFragment.findNavController(CodeEnteringFragment.this).navigate(R.id.action_codeEnteringFragment_to_workingMainFragment);
                    }
                }
            }
        });

        if(!newPinCode){
            Button deleteButton = new Button(getActivity());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.topMargin = 70;
            deleteButton.setLayoutParams(params);
            deleteButton.setText("забыли пин-код");
            deleteButton.setPadding(20,20,20,20);
            viewGroup.addView(deleteButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myEdit.remove("globalGUID");
                    myEdit.remove("pinCode");
                    myEdit.remove("smsCode");
                    myEdit.remove("contractNumber");
                    NavHostFragment.findNavController(CodeEnteringFragment.this).navigate(R.id.action_codeEnteringFragment_to_authorizationEnteringFragment);
                }
            });
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //настройка кнопки назад(выходим из приложения)
        //TODO посмотреть при всех ли ситуациях нужно выходить их приложения из данного фрагмента
        //просто данный фрагмент работает в друх режимах(вход, одновременно создание кода для входа и вход)
        //во втором режиме определить куда нужно выходить пользователю
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().moveTaskToBack(true);
                getActivity().finish();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}