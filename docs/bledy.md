# Zadanie 7

1. `findViewById` z nieistniejącym id:
   
   Zmieniłem ID w `activity_main.xml` z `"@+id/appTitle` na `"@+id/app`.
   
   Zmienił się tylko wygląd aplikacji, ponieważ system nie odnajduje po ID istnienia napisu i cała aplikacja podniosła się w górę, oprócz samego napisu.
   
   W Logcat pierwsze pięć linijek nie sugeruje błędu o tym ale i tak je wkleje:

   2026-09-18 18:00:41.648  6340-6340  nativeloader            com.example.kalkulatorbmi            D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
    2026-09-18 18:00:41.696  6340-6340  e.kalkulatorbmi         com.example.kalkulatorbmi            W  Suspending all threads took: 26.446ms
    2026-09-18 18:00:41.702  6340-6340  nativeloader            com.example.kalkulatorbmi            D  Load /data/user/0/com.example.kalkulatorbmi/code_cache/startup_agents/d77b4fbe-agent.so using system ns (caller=<unknown>): ok
    2026-09-18 18:00:41.692  6340-6340  re-initialized>         com.example.kalkulatorbmi            W  type=1400 audit(0.0:36): avc:  granted  { execute } for  path="/data/data/com.example.kalkulatorbmi/code_cache/startup_agents/d77b4fbe-agent.so" dev="dm-6" ino=573457 scontext=u:r:untrusted_app:s0:c230,c256,c512,c768 tcontext=u:object_r:app_data_file:s0:c230,c256,c512,c768 tclass=file app=com.example.kalkulatorbmi
    2026-09-18 18:00:41.713  6340-6340  e.kalkulatorbmi         com.example.kalkulatorbmi            W  hiddenapi: DexFile /data/data/com.example.kalkulatorbmi/code_cache/.studio/instruments-c3716e42.jar is in boot class path but is not in a known location

2. `findViewById` przed `setContentView`:

   Aplikacja włączyła się, lecz gdy próbowałem ją przetestować to się wyłączyła.

   2026-09-18 18:07:20.509  6668-6668  nativeloader            com.example.kalkulatorbmi            D  Load libframework-connectivity-tiramisu-jni.so using APEX ns com_android_tethering for caller /apex/com.android.tethering/javalib/framework-connectivity-t.jar: ok
2026-09-18 18:07:20.601  1942-2245  Finsky                  com.android.vending                  E  [57] ItemStore: getItems RPC failed for item com.example.kalkulatorbmi
2026-09-18 18:07:20.601  1942-2245  Finsky                  com.android.vending                  E  [57] ItemStore: getItems RPC failed for item com.example.kalkulatorbmi
2026-09-18 18:07:20.643  6668-6668  CompatChangeReporter    com.example.kalkulatorbmi            D  Compat change id reported: 333566037; UID 10230; state: ENABLED
2026-09-18 18:07:20.791  6668-6668  nativeloader            com.example.kalkulatorbmi            D  Configuring clns-9 for other apk /data/app/~~IxFaRxYIA0zYqiz9np5l9A==/com.example.kalkulatorbmi-PoiTUQQygLGvpDEOFiEsXA==/base.apk. target_sdk_version=37, uses_libraries=, library_path=/data/app/~~IxFaRxYIA0zYqiz9np5l9A==/com.example.kalkulatorbmi-PoiTUQQygLGvpDEOFiEsXA==/lib/x86_64, permitted_path=/data:/mnt/expand:/data/user/0/com.example.kalkulatorbmi
2026-09-18 18:07:20.809  6668-6668  ActivityThread          com.example.kalkulatorbmi            D  Set OS env TMPDIR to /data/user/0/com.example.kalkulatorbmi/cache

3. `Toast` bez `.show()`:

   Aplikacja działa, lecz błąd, który miał wyświetlić okienko z powiadomieniem o błędnie wprowadzonych danych, nie wyświetlił się.
