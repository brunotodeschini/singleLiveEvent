# SingleLiveEvent
SingleLiveEvent é uma classe que extende da classe MutableLiveData, ela foi criada para resolver alguns problemas que enfrentamos utilizando o LiveData.


# Por que usar?
Em alguns casos, como para controle de navegação, exibição de Toasts e Snackbars no nosso aplicativo a utilização do LiveData acaba sendo um anti pattern, pois alguns desses eventos só devem ser consumidos uma única vez.

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
  val exampleSingleLiveEvent: SingleLiveEvent<Boolean>
  get() = _exampleSingleLiveEvent
```

* Usando o SingleLiveEvent
```kotlin
    viewModel.exampleSingleLiveEvent.observe(this) {
        TODO("You should implement your code here")
    }
```
