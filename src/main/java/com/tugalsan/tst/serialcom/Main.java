package com.tugalsan.tst.serialcom;

import com.tugalsan.api.log.server.*;
import com.tugalsan.api.serialcom.server.TS_SerialComBuilder;
import com.tugalsan.api.serialcom.server.test.TS_SerialComTestJavaCode;
import com.tugalsan.api.serialcom.server.test.TS_SerialComTestKinConyKC868_A32_R1_2;

//WHEN RUNNING IN NETBEANS, ALL DEPENDENCIES SHOULD HAVE TARGET FOLDER!
//cd C:\me\codes\com.tugalsan\tst\com.tugalsan.tst.serialcom
//java --enable-preview --add-modules jdk.incubator.concurrent -jar target/com.tugalsan.tst.serialcom-1.0-SNAPSHOT-jar-with-dependencies.jar    
public class Main {

    final private static TS_Log d = TS_Log.of(Main.class);

    public static void main(String... s) {
//        TS_SerialComTestJavaCode.test_use_defaultMessageBroker();
        test_use_defaultMessageBroker();
    }

    public static void test_use_defaultMessageBroker() {
        d.cr("builder.result",
                TS_SerialComBuilder.portFirst()
                        .baudRate_115200().dataBits_8().oneStopBit().parityNone()
                        .onPortError(() -> d.ce("onPortError", "what2do?"))
                        .onSetupError(() -> d.ce("onSetupError", "what2do?"))
                        .onConnectError(() -> d.ce("onConnectError", "what2do?"))
                        .onReply_useDefaultMessageBroker_withMaxMessageCount(10)
                        .onSuccess_useAndClose_defaultMessageBroker((con, mb) -> {
                            var cmd = TS_SerialComTestKinConyKC868_A32_R1_2.chipName();
                            d.cr("with broker", "calling...");
                            var reply = mb.sendTheCommand_and_fetchMeReplyInMaxSecondsOf(cmd, 5);
                            d.cr("with broker", cmd, reply);
                        })
        );
    }
}
