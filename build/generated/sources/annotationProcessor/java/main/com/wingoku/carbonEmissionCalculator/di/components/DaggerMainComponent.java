package com.wingoku.carbonEmissionCalculator.di.components;

import com.wingoku.carbonEmissionCalculator.CarbonEmissionCalculator;
import com.wingoku.carbonEmissionCalculator.Main;
import com.wingoku.carbonEmissionCalculator.Main_MembersInjector;
import com.wingoku.carbonEmissionCalculator.di.modules.CarbonEmissionCalculatorModule;
import com.wingoku.carbonEmissionCalculator.di.modules.CarbonEmissionCalculatorModule_ProvidesCarbonEmissionCalculatorFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.GeoLocationModule;
import com.wingoku.carbonEmissionCalculator.di.modules.GeoLocationModule_ProvidesGeoLocationAPIFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.LoggerModule;
import com.wingoku.carbonEmissionCalculator.di.modules.LoggerModule_ProvideLoggerFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.MainModule;
import com.wingoku.carbonEmissionCalculator.di.modules.MainModule_ProvidesCommandLineArgumentsFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule_ProvideOkHttpClientBuilderFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule_ProvidesCacheFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule_ProvidesOkHttpClientFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule_ProvidesOkhttpLoggingInterceptorFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule_ProvidesRetryInterceptorFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.OKHttpModule_ProvidesRewriteResponseInterceptorFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.RetrofitBaseUrlModule;
import com.wingoku.carbonEmissionCalculator.di.modules.RetrofitBaseUrlModule_ProvidesMarvelAPIUrlFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.RetrofitModule;
import com.wingoku.carbonEmissionCalculator.di.modules.RetrofitModule_ProvidesGsonConverterFactoryFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.RetrofitModule_ProvidesRetrofitFactory;
import com.wingoku.carbonEmissionCalculator.di.modules.RetrofitModule_ProvidesRxJava2AdapterFactoryFactory;
import com.wingoku.carbonEmissionCalculator.interfaces.GeolocationAPI;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMainComponent implements MainComponent {
  private final MainModule mainModule;

  private final LoggerModule loggerModule;

  private final OKHttpModule oKHttpModule;

  private final RetrofitModule retrofitModule;

  private final RetrofitBaseUrlModule retrofitBaseUrlModule;

  private final GeoLocationModule geoLocationModule;

  private final CarbonEmissionCalculatorModule carbonEmissionCalculatorModule;

  private DaggerMainComponent(CarbonEmissionCalculatorModule carbonEmissionCalculatorModuleParam,
      MainModule mainModuleParam, LoggerModule loggerModuleParam,
      GeoLocationModule geoLocationModuleParam, RetrofitModule retrofitModuleParam,
      OKHttpModule oKHttpModuleParam, RetrofitBaseUrlModule retrofitBaseUrlModuleParam) {
    this.mainModule = mainModuleParam;
    this.loggerModule = loggerModuleParam;
    this.oKHttpModule = oKHttpModuleParam;
    this.retrofitModule = retrofitModuleParam;
    this.retrofitBaseUrlModule = retrofitBaseUrlModuleParam;
    this.geoLocationModule = geoLocationModuleParam;
    this.carbonEmissionCalculatorModule = carbonEmissionCalculatorModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private Interceptor getNamedInterceptor() {
    return OKHttpModule_ProvidesRetryInterceptorFactory.providesRetryInterceptor(oKHttpModule, LoggerModule_ProvideLoggerFactory.provideLogger(loggerModule));}

  private OkHttpClient getOkHttpClient() {
    return OKHttpModule_ProvidesOkHttpClientFactory.providesOkHttpClient(oKHttpModule, LoggerModule_ProvideLoggerFactory.provideLogger(loggerModule), OKHttpModule_ProvideOkHttpClientBuilderFactory.provideOkHttpClientBuilder(oKHttpModule), OKHttpModule_ProvidesOkhttpLoggingInterceptorFactory.providesOkhttpLoggingInterceptor(oKHttpModule), OKHttpModule_ProvidesCacheFactory.providesCache(oKHttpModule), OKHttpModule_ProvidesRewriteResponseInterceptorFactory.providesRewriteResponseInterceptor(oKHttpModule), getNamedInterceptor());}

  private Retrofit getRetrofit() {
    return RetrofitModule_ProvidesRetrofitFactory.providesRetrofit(retrofitModule, getOkHttpClient(), RetrofitModule_ProvidesGsonConverterFactoryFactory.providesGsonConverterFactory(retrofitModule), RetrofitModule_ProvidesRxJava2AdapterFactoryFactory.providesRxJava2AdapterFactory(retrofitModule), RetrofitBaseUrlModule_ProvidesMarvelAPIUrlFactory.providesMarvelAPIUrl(retrofitBaseUrlModule));}

  private GeolocationAPI getGeolocationAPI() {
    return GeoLocationModule_ProvidesGeoLocationAPIFactory.providesGeoLocationAPI(geoLocationModule, getRetrofit());}

  private CarbonEmissionCalculator getCarbonEmissionCalculator() {
    return CarbonEmissionCalculatorModule_ProvidesCarbonEmissionCalculatorFactory.providesCarbonEmissionCalculator(carbonEmissionCalculatorModule, MainModule_ProvidesCommandLineArgumentsFactory.providesCommandLineArguments(mainModule), LoggerModule_ProvideLoggerFactory.provideLogger(loggerModule), getGeolocationAPI());}

  @Override
  public void inject(Main main) {
    injectMain(main);}

  private Main injectMain(Main instance) {
    Main_MembersInjector.injectCarbonEmissionCalculator(instance, getCarbonEmissionCalculator());
    return instance;
  }

  public static final class Builder {
    private CarbonEmissionCalculatorModule carbonEmissionCalculatorModule;

    private MainModule mainModule;

    private LoggerModule loggerModule;

    private GeoLocationModule geoLocationModule;

    private RetrofitModule retrofitModule;

    private OKHttpModule oKHttpModule;

    private RetrofitBaseUrlModule retrofitBaseUrlModule;

    private Builder() {
    }

    public Builder carbonEmissionCalculatorModule(
        CarbonEmissionCalculatorModule carbonEmissionCalculatorModule) {
      this.carbonEmissionCalculatorModule = Preconditions.checkNotNull(carbonEmissionCalculatorModule);
      return this;
    }

    public Builder mainModule(MainModule mainModule) {
      this.mainModule = Preconditions.checkNotNull(mainModule);
      return this;
    }

    public Builder loggerModule(LoggerModule loggerModule) {
      this.loggerModule = Preconditions.checkNotNull(loggerModule);
      return this;
    }

    public Builder geoLocationModule(GeoLocationModule geoLocationModule) {
      this.geoLocationModule = Preconditions.checkNotNull(geoLocationModule);
      return this;
    }

    public Builder retrofitModule(RetrofitModule retrofitModule) {
      this.retrofitModule = Preconditions.checkNotNull(retrofitModule);
      return this;
    }

    public Builder oKHttpModule(OKHttpModule oKHttpModule) {
      this.oKHttpModule = Preconditions.checkNotNull(oKHttpModule);
      return this;
    }

    public Builder retrofitBaseUrlModule(RetrofitBaseUrlModule retrofitBaseUrlModule) {
      this.retrofitBaseUrlModule = Preconditions.checkNotNull(retrofitBaseUrlModule);
      return this;
    }

    public MainComponent build() {
      if (carbonEmissionCalculatorModule == null) {
        this.carbonEmissionCalculatorModule = new CarbonEmissionCalculatorModule();
      }
      Preconditions.checkBuilderRequirement(mainModule, MainModule.class);
      if (loggerModule == null) {
        this.loggerModule = new LoggerModule();
      }
      if (geoLocationModule == null) {
        this.geoLocationModule = new GeoLocationModule();
      }
      if (retrofitModule == null) {
        this.retrofitModule = new RetrofitModule();
      }
      if (oKHttpModule == null) {
        this.oKHttpModule = new OKHttpModule();
      }
      if (retrofitBaseUrlModule == null) {
        this.retrofitBaseUrlModule = new RetrofitBaseUrlModule();
      }
      return new DaggerMainComponent(carbonEmissionCalculatorModule, mainModule, loggerModule, geoLocationModule, retrofitModule, oKHttpModule, retrofitBaseUrlModule);
    }
  }
}
