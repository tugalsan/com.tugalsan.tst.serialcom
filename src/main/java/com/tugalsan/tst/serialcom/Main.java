package com.tugalsan.tst.serialcom;

import com.tugalsan.api.serialcom.server.test.*;

//WHEN RUNNING IN NETBEANS, ALL DEPENDENCIES SHOULD HAVE TARGET FOLDER!
//cd C:\me\codes\com.tugalsan\tst\com.tugalsan.tst.serialcom
//java --enable-preview --add-modules jdk.incubator.concurrent -jar target/com.tugalsan.tst.serialcom-1.0-SNAPSHOT-jar-with-dependencies.jar    
public class Main {

    public static void main(String... s) {
        TS_SerialComTestJavaCode.test();
    }
}
