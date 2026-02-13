Celem niniejszego zadania jest ukazanie cyklu życia aplikacji jako kluczowego aspektu tworzenia aplikacji przez programistę. System sam zarządza procesami aplikacji, dlatego jeśli cykl nie zostanie uwzględniony przy projektowaniu, aplikacja będzie zużywać duże ilości zasobów lub po prostu się zawieszać. Wpływa on także na stabilność aplikacji, wydajność i baterię urządzenia oraz kluczowe zarządzanie pamięcią. Skoro cykl życia to fundament Androida, należy reagować na zmiany stanu aplikacji, co idealnie pokaże stworzona aplikacja LifecycleApp. Program ten został zaprojektowany w celu demonstracji działania cyklu życia w systemie Android. Mechanizm wywołuje określone metody systemowe w zależności od stanu aplikacji i interakcji użytkownika z systemem operacyjnym.

Program przechwytuje podstawowe metody cyklu życia aktywności:
	• onCreate()
	• onStart()
	• onResume()
	• onPause()
	• onStop()
	• onRestart()
	• onDestroy()
	• onSaveInstanceState()
 
Komunikaty odnośnie aktualnie wywołanej metody wyświetlane są przy pomocy komunikatu pop-up typu Toast. 

Dodatkowo z mojej inicjatywy zamiast zwykłej zmiany tła dodano ColorPicker z repozytorium com.github.yukuku:ambilwarna, który umożliwia wybranie koloru tła przez paletę kolorów, a nie przez wpisanie tekstu do pola EditText. Wykorzystałem także obliczanie jasności ekranu, aby dostosować obramowanie elementów interfejsu.

Działanie metod zostało opisane w kodzie.
