# Dagger Hilt Practice & Dependency Injection Guide

Bu repo, modern Android geliştirme dünyasında **Dependency Injection (Bağımlılık Enjeksiyonu)** kavramını derinlemesine anlamak, Dagger Hilt kütüphanesinin iç mekanizmalarını çözmek ve manuel DI ile kıyaslamalı olarak pratik yapmak amacıyla oluşturulmuştur.

---

## 🚀 Öğrendiklerim ve Pratik Ettiklerim

### 1. Dagger Hilt Temelleri ve Kod Üretim Mekanizması
* **`@HiltAndroidApp` ve `Application` Sınıfı:** Uygulama seviyesinde global bir yaşam döngüsü oluşturarak Hilt'in kök bileşenini (`SingletonComponent`) nasıl ayağa kaldırdığını öğrendim.
* **Modüller ve Sağlayıcılar (`@Module`, `@Provides`, `@InstallIn`):** 
  * Harici kütüphanelerden (örneğin Retrofit) gelen nesneleri sisteme tanıtmak için `@Provides` anotasyonunu kullandım.
  * Modüllerin hangi kapsamda (`SingletonComponent` vb.) yaşayacağını `@InstallIn` ile belirledim.
* **Arayüz Bağlamaları (`@Binds`):** 
  * Somut sınıflar yerine arayüzler (`Interface`) üzerinden çalışmanın Clean Architecture prensiplerindeki önemini kavradım.
  * Hilt'e bir interface istendiğinde hangi somut sınıfın (`RepositoryImpl`) verileceğini `@Binds` ile öğrettim.
* **Nitelendiriciler (`@Named`):** 
  * Aynı türden (örneğin `String`) birden fazla nesne projede yer aldığında, Hilt'in bunları karıştırmaması için `@Named("Hello1")` gibi anahtarlarla nasıl ayrıştırılacağını deneyimledim.
* **Performans Optimizasyonu (`dagger.Lazy`):** 
  * Nesnelerin uygulamanın ilk açılışında değil, kod içinde ilk kez `.get()` çağrıldığı an üretilmesini sağlayan `Lazy<T>` sarmalını inceledim ve gereksiz bellek maliyetini engellemeyi öğrendim.

---

### 2. Dagger Hilt vs. Saf Kotlin (Manual Dependency Injection Araştırması)
Hilt'in arka planda bizim yerimize hangi problemleri çözdüğünü daha iyi kavramak amacıyla **Saf Kotlin (Manual DI)** yaklaşımlarını araştırdım, inceledim ve Dagger Hilt ile şu şekilde karşılaştırdım:

* **Konteyner ve Mimari Karşılaştırması:** Saf Kotlin projelerinde manuel olarak yazılan `AppContainer` ve `by lazy` mekanizmalarının, Hilt modüllerindeki `@Provides` / `@Singleton` yapılarıyla mantıken birebir aynı amaca hizmet ettiğini, ancak Hilt'in bu yapıyı derleme anında otomatik kod üreterek (`KSP/KAPT`) omuzlarımızdan aldığını fark ettim.
* **ViewModel ve Factory Zorunluluğu:** Android'in parametre alan ViewModel'leri doğrudan üretemediği için saf Kotlin'de her ViewModel için manuel bir `ViewModelProvider.Factory` yazmak gerektiğini; Hilt'in ise `@HiltViewModel` ve `hiltViewModel()` desteğiyle bu kodlama zorluğunu tamamen ortadan kaldırdığını öğrendim.

---

### 3. Mimari ve Android Yaşam Döngüsü Detayları
* **`Application` Sınıfının Rolü:** Uygulamanın en kök motor dairesi olduğunu, ekrandaki sayfalardan bağımsız olarak süreç boyu yaşayarak global konteynerleri barındırdığını kavradım.
* **Tip Dönüşümleri (`as MyApp`):** Standart `application` nesnesini özel `MyApp` sınıfımıza dönüştürerek global bileşenlere nasıl erişileceğini inceledim.
* **Modern UI Pratikleri:** `enableEdgeToEdge()` ile arayüzün ekranın en uç noktalarına kadar nasıl konumlandırıldığını öğrendim.
