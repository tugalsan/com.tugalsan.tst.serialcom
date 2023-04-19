package com.tugalsan.tst.serialcom;

import com.tugalsan.api.cast.client.TGS_CastUtils;
import com.tugalsan.api.log.server.TS_Log;
import com.tugalsan.api.serialcom.server.test.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//WHEN RUNNING IN NETBEANS, ALL DEPENDENCIES SHOULD HAVE TARGET FOLDER!
//cd C:\me\codes\com.tugalsan\tst\com.tugalsan.tst.serialcom
//java --enable-preview --add-modules jdk.incubator.concurrent -jar target/com.tugalsan.tst.serialcom-1.0-SNAPSHOT-jar-with-dependencies.jar    
public class Main {

    final private static TS_Log d = TS_Log.of(true, Main.class);

    public static void main(String... s) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in));) {
            boolean debugEnabled = true;
            while (true) {
                d.ci("test", "--------------------------------------------");
                d.ci("test", "choice", "0: exit");
                d.ci("test", "choice", debugEnabled ? "1: debugEnabled" : "1: debugDisabled");
                d.ci("test", "choice", "2: test_chipname");
                d.ci("test", "choice", "3: test_digitalIn_getAll");
                d.ci("test", "choice", "4: test_digitalIn_getIdx");
                d.ci("test", "choice", "5: test_digitalOut_getAll");
                d.ci("test", "choice", "6: test_digitalOut_getIdx");
                d.ci("test", "choice", "7: test_digitalOut_setAll");
                d.ci("test", "choice", "8: test_digitalOut_setIdx");
                d.ci("test", "choice", "9: test_oscillate");
                d.ci("test", "choice", "10: test_register");
                System.out.print("choice: ");
                var choiceStr = reader.readLine();
                var choiceInt = TGS_CastUtils.toInteger(choiceStr);
                if (choiceInt == null) {
                    d.ce("test", "ERROR_CHOICE", choiceStr);
                    continue;
                }
                switch (choiceInt) {
                    case 0 ->
                        System.exit(0);
                    case 1 ->
                        debugEnabled = !debugEnabled;
                    case 2 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, true, false, false, false, false, false, false, false, false);
                    case 3 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, true, false, false, false, false, false, false, false);
                    case 4 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, true, false, false, false, false, false, false);
                    case 5 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, false, true, false, false, false, false, false);
                    case 6 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, false, false, true, false, false, false, false);
                    case 7 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, false, false, false, true, false, false, false);
                    case 8 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, false, false, false, false, true, false, false);
                    case 9 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, false, false, false, false, false, true, false);
                    case 10 ->
                        TS_SerialComTestJavaCode.test(debugEnabled, false, false, false, false, false, false, false, false, true);
                    default ->
                        d.ce("test", "WHAT_TO_DO_WITH_THIS", choiceStr);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
