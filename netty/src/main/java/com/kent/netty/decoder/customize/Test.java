package com.kent.netty.decoder.customize;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("sfdsa");
        src.add("fspig");

        MessagePack messagePack = new MessagePack();

        byte[] raw = messagePack.write(src);

        List<String> dst1 = messagePack.read(raw, Templates.tList(Templates.TString));
        System.out.println(dst1.get(0));
        System.out.println(dst1.get(1));
        System.out.println(dst1.get(2));

    }
}
