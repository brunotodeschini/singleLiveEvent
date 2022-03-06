# SingleLiveEvent
SingleLiveEvent é uma classe que extende da classe MutableLiveData, ela foi criada para resolver alguns problemas que enfrentamos utilizando o LiveData.


# Por que usar?
Em alguns casos, como para controle de navegação, exibição de Toasts e Snackbars no nosso aplicativo a utilização do LiveData acaba sendo um anti pattern, pois alguns desses eventos só devem ser consumidos uma única vez.

# Ponto de atenção
Muitas vezes uma variável acaba sendo observada em vários lugares, o trecho de código a seguir mostra que com o SingleLiveEvent é diferente, não importa quantos observers estiverem registrados, ele vai notificar apenas um deles. O que estiver ativo, caso cada um esteja em uma fragment diferente ou o primeiro que for registrado na mesma fragment.

```kotlin
if (hasActiveObservers()) {
    Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
}
```

# Como usar:
A utilização do SingleLiveEvent é bem semelhante ao uso de um MutableLiveData, como podemos ver na seguinte comparação.

* Declarando o MutableLiveData
```kotlin
    private val exampleMutableLiveData = MutableLiveData<Boolean>()
    val exampleLiveData: LiveData<Boolean>
    get() = exampleMutableLiveData
```

* Usando o MutableLiveData
```kotlin
    viewModel.exampleLiveData.observe(this) {
        TODO("You should implement your code here")
    }
```

Agora vamos ver como é a declaração e a utilização do SingleLiveEvent

* Declarando o SingleLiveEvent
```kotlin
  private val _exampleSingleLiveEvent = SingleLiveEvent<Boolean>()
  val exampleSingleLiveEvent: LiveData<Boolean>
  get() = _exampleSingleLiveEvent
```

Nesse caso, utilizamos a `val exampleSingleLiveEvent` como LiveData, pois o LiveData não tem métodos públicos para alterar os valores armazenados, assim quem tiver acesso a ela, não poderá alterar o seu valor. O que aconteceria se fosse do tipo SingleLiveEvent, pois essa classe extende de MutableLiveData e ela tem métodos públicos para alterar os valores armazenados.

* Usando o SingleLiveEvent
```kotlin
    viewModel.exampleSingleLiveEvent.observe(this) {
        TODO("You should implement your code here")
    }
```
