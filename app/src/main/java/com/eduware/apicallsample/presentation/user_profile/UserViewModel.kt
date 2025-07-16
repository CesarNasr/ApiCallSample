package com.eduware.apicallsample.presentation.user_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduware.apicallsample.core.network.ErrorType
import com.eduware.apicallsample.core.network.onError
import com.eduware.apicallsample.core.network.onNetworkError
import com.eduware.apicallsample.core.network.onSuccess
import com.eduware.apicallsample.domain.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            userRepository.getUserDetails("123")
                .onSuccess { user ->

                }
                .onError { code, msg, errorType ->
                    when (errorType) {
                        ErrorType.UNAUTHORIZED -> {

                        }

                        ErrorType.FORBIDDEN -> {

                        }

                        else -> {

                        }
                    }
                }
                .onNetworkError {


                }
        }

    }
}