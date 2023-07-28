package dsk.altlombard.test.fragments.entering;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.textfield.TextInputLayout;
import dsk.altlombard.test.R;
import dsk.altlombard.test.databinding.FragmentCodeEnteringBinding;
import dsk.altlombard.test.fragments.TestFragment;
import dsk.altlombard.test.fragments.WorkingMainFragment;

import java.util.concurrent.Executor;

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
        TextView titleText =(TextView) view.findViewById(R.id.pincode_subtitle1);
        if(newPinCode)
            titleText.setText("Придумайте пин-код для входа");
        else
            titleText.setText("Введите пин-код для входа");

        ViewGroup viewGroup = view.findViewById(R.id.layout_for_button_forgotpin);//сюда мы встявляем кнопку "забыли пин-код"
        TextInputLayout enteredPinCode = view.findViewById(R.id.enter_pincode);

        SharedPreferences registrationEntity = this.getActivity().getSharedPreferences("registration", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = registrationEntity.edit();

        binding.buttonPincodeEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkingMainFragment.isFirstTime = true;
                if(newPinCode){
                    myEdit.putString("pinCode", enteredPinCode.getEditText().getText().toString());
                    myEdit.commit();
                    NavHostFragment.findNavController(CodeEnteringFragment.this).navigate(R.id.action_codeEnteringFragment_to_workingMainFragment);
                } else {
                    String correctPinCode = registrationEntity.getString("pinCode", "");
                    if (correctPinCode.equals(enteredPinCode.getEditText().getText().toString())) {
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

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //настройка кнопки назад(выходим из приложения)
        //TODO посмотреть при всех ли ситуациях нужно выходить из приложения из данного фрагмента
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




        getActivity().setContentView(R.layout.fragment_code_entering);
        executor = ContextCompat.getMainExecutor(getContext());
        biometricPrompt = new BiometricPrompt(CodeEnteringFragment.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getActivity().getApplicationContext(),
                                "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getActivity().getApplicationContext(),
                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getActivity().getApplicationContext(), "Authentication failed",
                                Toast.LENGTH_SHORT)
                        .show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build();

        // Prompt appears when user clicks "Log in".
        // Consider integrating with the keystore to unlock cryptographic operations,
        // if needed by your app.
        Button biometricLoginButton = getActivity().findViewById(R.id.button_pincode_entering);
        biometricLoginButton.setOnClickListener(view -> {
            biometricPrompt.authenticate(promptInfo);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}