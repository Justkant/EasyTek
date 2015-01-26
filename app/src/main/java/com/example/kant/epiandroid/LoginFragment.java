package com.example.kant.epiandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.kant.epiandroid.EpitechAPI.EpitechAPI;
import com.example.kant.epiandroid.EpitechAPI.Login;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginFragment extends Fragment {
    private EditText mLogin;
    private EditText mPassword;
    private Button mBtnLogin;
    private boolean isLoginValide;
    private boolean isPasswordValide;
    private RestAdapter restAdapter;
    private EpitechAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.base_url))
                .build();

        api = restAdapter.create(EpitechAPI.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mLogin = (EditText) view.findViewById(R.id.loginText);
        mPassword = (EditText) view.findViewById(R.id.passwordText);
        mBtnLogin = (Button) view.findViewById(R.id.loginButton);

        mLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateLogin(s.toString());
                updateLoginBtnState();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePassword(s.toString());
                updateLoginBtnState();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnLogin.setEnabled(false);
                api.loginPost(mLogin.getText().toString(), mPassword.getText().toString(), new Callback<Login>() {
                    @Override
                    public void success(Login login, Response response) {
                        MySharedPreferences.saveToPreferences(getActivity(), getString(R.string.token_string), login.token);
                        toggleFragment();
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        mPassword.setText(getString(R.string.empty_string));
                        mPassword.setError(getString(R.string.login_error));
                    }
                });
            }
        });

        return view;
    }

    private void toggleFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .remove(this)
                .commit();
    }

    private void validateLogin(String text) {
        isLoginValide = !text.isEmpty();
    }

    private void validatePassword(String text) {
        isPasswordValide = !text.isEmpty();
    }

    private void updateLoginBtnState() {
        if (isLoginValide && isPasswordValide) {
            mBtnLogin.setEnabled(true);
        } else {
            mBtnLogin.setEnabled(false);
        }
    }
}
