package rs.sloman.leapyear

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val appModule = module{

    single {Repository()}

    viewModel { MainViewModel(get()) }
}
